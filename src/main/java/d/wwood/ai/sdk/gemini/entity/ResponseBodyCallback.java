package d.wwood.ai.sdk.gemini.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import d.wwood.ai.sdk.gemini.GeminiClient;
import d.wwood.ai.sdk.gemini.error.ChatResponseError;
import d.wwood.ai.sdk.gemini.exception.VacSdkException;
import io.reactivex.FlowableEmitter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Callback to parse Server Sent Events (SSE) from raw InputStream and
 * emit the events with io.reactivex.FlowableEmitter to allow streaming of
 * SSE.
 */
public class ResponseBodyCallback implements Callback<ResponseBody> {
    private static final ObjectMapper mapper = GeminiClient.defaultObjectMapper();

    private FlowableEmitter<SSE> emitter;
    private boolean emitDone;

    public ResponseBodyCallback(FlowableEmitter<SSE> emitter, boolean emitDone) {
        this.emitter = emitter;
        this.emitDone = emitDone;
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        BufferedReader reader = null;

        try {
            if (!response.isSuccessful()) {
                HttpException e = new HttpException(response);
                ResponseBody errorBody = response.errorBody();

                if (errorBody == null) {
                    throw e;
                } else {

                    List<ChatResponseError> errors = mapper.readValue(
                            errorBody.string(),
                            mapper.getTypeFactory().constructCollectionType(List.class, ChatResponseError.class)
                    );
                    throw new VacSdkException("-1", "stream error", errors);
                }
            }

            InputStream in = response.body().byteStream();
            reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            String line;
            SSE sse = null;

            Map<String, Integer> usage = new HashMap<>();
            while (!emitter.isCancelled() && (line = reader.readLine()) != null) {
                if (line.contains("\"text\":")) {
                    sse = new SSE("{" + line + "}");
                    emitter.onNext(sse);
                } else if (line.contains("promptTokenCount") || line.contains("candidatesTokenCount") || line.contains("totalTokenCount")) {
                    String key = line.substring(line.indexOf("\"") + 1, line.indexOf("\":"));
                    Integer value = Integer.parseInt(line.substring(line.indexOf(":") + 1).replace(",", "").trim());
                    usage.put(key, value);
                }

            }
            Map<String, Object> useagePar = new HashMap<>();
            useagePar.put("usageMetadata", usage);
            sse = new SSE(mapper.writeValueAsString(useagePar));
            emitter.onNext(sse);
            emitter.onComplete();
        } catch (Throwable t) {
            onFailure(call, t);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // do nothing
                }
            }
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        emitter.onError(t);
    }
}
