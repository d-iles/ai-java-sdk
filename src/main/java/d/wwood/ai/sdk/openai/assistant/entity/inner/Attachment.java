package d.wwood.ai.sdk.openai.assistant.entity.inner;

import com.fasterxml.jackson.annotation.JsonProperty;

import d.wwood.ai.sdk.openai.entity.ChatTool;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-04-19 15:03
 **/


@Data
@Builder
public class Attachment {

    @JsonProperty("file_id")
    private String fileId;

    private List<ChatTool> tools;
}
