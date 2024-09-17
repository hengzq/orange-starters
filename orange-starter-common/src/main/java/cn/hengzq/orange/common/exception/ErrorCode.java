package cn.hengzq.orange.common.exception;

import java.io.Serializable;

/**
 * 错误码对象
 *
 * @author hengzq
 */
public class ErrorCode implements Serializable {

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(String code, String message) {
        this.code = code;
        this.msg = message;
    }


    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
