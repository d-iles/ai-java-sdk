package d.wwood.ai.sdk.openai.assistant.entity.inner;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-20 10:12
 **/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RunImage {

    @JsonProperty("file_id")
    private String fileId;
}
