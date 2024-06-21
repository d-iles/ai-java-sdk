package d.wwood.ai.sdk.test.openai;

import org.junit.jupiter.api.Test;

import d.wwood.ai.sdk.openai.OpenaiClient;
import d.wwood.ai.sdk.openai.file.entity.OpenaiFile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-20 12:00
 **/

public class OpenaiFileTest {

    OpenaiClient client = new OpenaiClient(OpenaiConstant.API_KEY);


    @Test
    public void uploadFile() {
        String filePath = "/Users/vacuity/Downloads/hello.pdf";
        OpenaiFile file = client.uploadFile("assistants", filePath);
        assertNotNull(file);
        System.out.println(file);
        // file-cyXRLxSuPQI65qRoEDVy3tK7
    }

    @Test
    public void listFiles() {
        List<OpenaiFile> files = client.listFiles("assistants");
        assertNotNull(files);
        System.out.println(files);
    }

    @Test
    public void retrieveFile() {
        String fileId = "file-cyXRLxSuPQI65qRoEDVy3tK7";
        OpenaiFile file = client.retrieveFile(fileId);
        assertNotNull(file);
        System.out.println(file);
    }
}
