package d.wwood.ai.sdk.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import d.wwood.ai.sdk.gemini.GeminiClient;
import d.wwood.ai.sdk.gemini.api.GeminiApi;
import d.wwood.ai.sdk.gemini.entity.ChatMessage;
import d.wwood.ai.sdk.gemini.exception.VacSdkException;
import d.wwood.ai.sdk.gemini.request.ChatRequest;
import d.wwood.ai.sdk.gemini.response.ChatResponse;
import d.wwood.ai.sdk.gemini.response.StreamChatResponse;
import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;

import static d.wwood.ai.sdk.gemini.GeminiClient.defaultClient;
import static d.wwood.ai.sdk.gemini.GeminiClient.defaultObjectMapper;
import static d.wwood.ai.sdk.gemini.GeminiClient.defaultRetrofit;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-06 11:14
 **/

public class GeminiTest {

    public static final String API_KEY = "***";


    @Test
    public void chat() {
        GeminiClient client = new GeminiClient(API_KEY);
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage("user", "introduce yourself pls"));
        ChatRequest request = ChatRequest.builder()
                .contents(messages)
                .build();
        try {
            ChatResponse response = client.chat(request);
            System.out.println(response);
        } catch (VacSdkException e) {
            if (e.getDetails() != null) {
                System.out.println(e.getDetails().get(0).getError().getMessage());
            }
        }
    }

    @Test
    public void streamChat() {
        GeminiClient client = new GeminiClient(API_KEY);
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage("user", "introduce yourself please"));
        ChatRequest request = ChatRequest.builder()
                // set model here, if not set the default is gemini-pro 
                .model("gemini-pro")
                .contents(messages)
                .build();
        System.out.println(request);
        try {
            Flowable<StreamChatResponse> response = client.streamChat(request);
            response.doOnNext(s -> {

                if (s.getUsageMetadata() == null) {
                    System.out.println(s.getText());
                } else {
                    System.out.println(s.getUsageMetadata());
                }
            }).blockingSubscribe();
        } catch (VacSdkException e) {
            if (e.getDetails() != null) {
                System.out.println(e.getDetails().get(0).getError().getMessage());
            }
        }
    }

    @Test
    public void proxyChat() {
        String host = "127.0.0.1";
        int port = 7890;
        ObjectMapper mapper = defaultObjectMapper();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
        OkHttpClient httpClient = defaultClient(Duration.ofSeconds(60))
                .newBuilder()
                .proxy(proxy)
                .build();
        Retrofit retrofit = defaultRetrofit(httpClient, mapper, null);
        GeminiApi api = retrofit.create(GeminiApi.class);
        GeminiClient client = new GeminiClient(API_KEY, api);

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage("user", "introduce yourself please"));
        ChatRequest request = ChatRequest.builder()
                .contents(messages)
                .build();
        try {
            ChatResponse response = client.chat(request);
            System.out.println(response.getCandidates().get(0).getContent().getParts().get(0).getText());
        } catch (VacSdkException e) {
            if (e.getDetails() != null) {
                System.out.println(e.getDetails().get(0).getError().getMessage());
            }
        }
    }
}
