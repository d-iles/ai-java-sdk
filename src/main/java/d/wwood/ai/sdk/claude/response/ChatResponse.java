package d.wwood.ai.sdk.claude.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import d.wwood.ai.sdk.claude.entity.ChatMessageContent;
import d.wwood.ai.sdk.claude.entity.Usage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-06 10:17
 **/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {

    private String id;

    private String type;

    private String role;

    private List<ChatMessageContent> content;

    private String model;

    @JsonProperty("stop_reason")
    private String stopReason;

    @JsonProperty("stop_sequence")
    private String stopSequence;

    private Usage usage;
}
