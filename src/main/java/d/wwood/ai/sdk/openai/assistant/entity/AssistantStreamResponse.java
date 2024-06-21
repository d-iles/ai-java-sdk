package d.wwood.ai.sdk.openai.assistant.entity;

import d.wwood.ai.sdk.openai.error.ChatResponseError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-20 11:06
 **/


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssistantStreamResponse {

    private String event;

    private Class dataClass;

    private Thread thread;

    private Run run;

    private RunStep runStep;

    private RunStepDelta runStepDelta;

    private AssistantMessage message;

    private AssistantMessageDelta messageDelta;

    private ChatResponseError.ChatResponseErrorDetails error;
}
