package d.wwood.ai.sdk.gemini.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import d.wwood.ai.sdk.gemini.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-06 10:12
 **/


@Data
@Builder
public class ChatRequest {

    // default model: gemini-pro
    @Builder.Default
    private String model = "gemini-pro";

    private List<ChatMessage> contents;

    private List<SafetySetting> safetySettings;

    private GenerationConfig generationConfig;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SafetySetting {

        @JsonProperty("mime_type")
        private String category;

        private String threshold;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GenerationConfig {

        private List<String> stopSequences;

        private float temperature;

        private Integer maxOutputTokens;

        private float topP;

        private float topK;
    }
}
