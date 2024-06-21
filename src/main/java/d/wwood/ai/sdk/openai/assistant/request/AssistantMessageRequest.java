package d.wwood.ai.sdk.openai.assistant.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

import d.wwood.ai.sdk.openai.assistant.entity.inner.Attachment;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-19 18:26
 **/


@Data
@Builder
public class AssistantMessageRequest {

    private String role;

    private String content;

    private List<Attachment> attachments;

    private Map<String, Object> metadata;


}
