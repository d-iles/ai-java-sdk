package d.wwood.ai.sdk.openai.assistant.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import d.wwood.ai.sdk.openai.assistant.entity.inner.ToolResources;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-19 18:24
 **/


@Data
@Builder
public class ThreadRequest {

    private List<AssistantMessageRequest> messages;

    @JsonProperty("tool_resources")
    private ToolResources toolResources;

    private Map<String, Object> metadata;
}
