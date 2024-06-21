package d.wwood.ai.sdk.openai.assistant.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import d.wwood.ai.sdk.openai.assistant.entity.inner.ExpiresAfter;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-04-19 14:42
 **/


@Data
@Builder
public class VectorStoreRequest {

    @JsonProperty("file_ids")
    private List<String> fileIds;

    private String name;

    @JsonProperty("expires_after")
    private ExpiresAfter expiresAfter;

    private Map<String, Object> metadata;
}
