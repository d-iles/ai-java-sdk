package d.wwood.ai.sdk.gemini.response;

import d.wwood.ai.sdk.gemini.entity.Usage;
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

    private String text;

    private Usage usageMetadata;
}
