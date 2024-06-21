package d.wwood.ai.sdk.openai.exception;

import lombok.Data;

import java.io.Serializable;

import d.wwood.ai.sdk.openai.error.ChatResponseError;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-06 10:59
 **/


@Data
public class VacSdkException extends RuntimeException implements Serializable {

    private String code;

    private String msg;

    private ChatResponseError detail;

    public VacSdkException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public VacSdkException(String code, String msg, ChatResponseError detail) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }
}
