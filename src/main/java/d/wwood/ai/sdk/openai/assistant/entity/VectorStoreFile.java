package d.wwood.ai.sdk.openai.assistant.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import d.wwood.ai.sdk.openai.assistant.entity.inner.LastError;
import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-04-19 14:41
 **/


@Data
@Builder
public class VectorStoreFile {

    private String id;

    private String object;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("vector_store_id")
    private String vectorStoreId;

    private String status;

    @JsonProperty("last_error")
    private LastError lastError;
}
