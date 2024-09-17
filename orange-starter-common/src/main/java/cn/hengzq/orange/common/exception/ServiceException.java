package cn.hengzq.orange.common.exception;

/**
 * @author hengzq
 */
public class ServiceException extends RuntimeException {

    protected ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
