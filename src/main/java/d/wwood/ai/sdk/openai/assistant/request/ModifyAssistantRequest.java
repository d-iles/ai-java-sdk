package d.wwood.ai.sdk.openai.assistant.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import d.wwood.ai.sdk.openai.assistant.entity.inner.ToolResources;
import d.wwood.ai.sdk.openai.entity.ChatTool;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-19 18:18
 **/


@Data
@Builder
public class ModifyAssistantRequest {

    private String model;

    private String name;

    private String description;

    private String instructions;

    private List<ChatTool> tools;

    @JsonProperty("tool_resources")
    private ToolResources toolResources;

    private Map<String, Object> metadata;

    private Float temperature;

    @JsonProperty("top_p")
    private Double topP;

    @JsonProperty("response_format")
    private Object responseFormat;
}
