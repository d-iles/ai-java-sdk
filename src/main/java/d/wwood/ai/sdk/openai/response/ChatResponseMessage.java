package d.wwood.ai.sdk.openai.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import d.wwood.ai.sdk.openai.entity.ChatFunctionCall;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-13 14:25
 **/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponseMessage {

    private Object content;


    @JsonProperty("tool_calls")
    private List<ChatFunctionCall> toolCalls;
}
