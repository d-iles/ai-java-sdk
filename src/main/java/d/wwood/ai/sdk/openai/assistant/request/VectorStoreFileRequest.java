package d.wwood.ai.sdk.openai.assistant.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-04-19 15:28
 **/


@Data
@Builder
public class VectorStoreFileRequest {

    @JsonProperty("file_id")
    private String fileId;
}
