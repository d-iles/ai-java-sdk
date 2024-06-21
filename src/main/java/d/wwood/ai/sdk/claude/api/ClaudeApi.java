package d.wwood.ai.sdk.claude.api;

import d.wwood.ai.sdk.claude.request.ChatRequest;
import d.wwood.ai.sdk.claude.response.ChatResponse;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Streaming;

public interface ClaudeApi {

    @Headers({"anthropic-beta: tools-2024-04-04"})
    @POST("v1/messages")
    Single<ChatResponse> chat(@Body ChatRequest request);


    @Headers({"anthropic-beta: tools-2024-04-04"})
    @Streaming
    @POST("v1/messages")
    Call<ResponseBody> streamChat(@Body ChatRequest request);
}
