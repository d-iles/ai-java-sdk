package d.wwood.ai.sdk.claude.response;

import d.wwood.ai.sdk.claude.entity.ChatMessageContent;
import d.wwood.ai.sdk.claude.entity.ResponseStartMessage;
import d.wwood.ai.sdk.claude.entity.Usage;
import d.wwood.ai.sdk.claude.error.ChatResponseError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-06 10:17
 **/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StreamChatResponse {


    private String type;

    private ResponseStartMessage message;

    private ChatMessageContent delta;

    private ChatResponseError.ChatResponseErrorDetail error;

    private Usage usage;
}
