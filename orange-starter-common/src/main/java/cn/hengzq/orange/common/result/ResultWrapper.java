package cn.hengzq.orange.common.result;

import cn.hengzq.orange.common.constant.GlobalErrorCodeConstant;
import cn.hengzq.orange.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

/**
 * result 接口封装
 *
 * @author hengzq
 */
@Slf4j
public class ResultWrapper {

    public static <T> Result<T> result() {
        Result<T> result = new Result<>();
        result.setRequestId(Thread.currentThread().getName());
        return result;
    }

    /**
     * 返回成功
     *
     * @param <T> 数据类型
     * @return 成功 空结果集
     */
    public static <T> Result<T> ok() {
        return result();
    }

    /**
     * 返回成功结果
     *
     * @param data 返回数据
     * @param <T>  数据类型
     * @return 封装结果集
     */
    public static <T> Result<T> ok(T data) {
        Result<T> result = ok();
        result.setData(data);
        return result;
    }

    /**
     * 返回失败提示信息
     *
     * @return 返回失败提示信息
     */
    public static <T> Result<T> fail() {
        return fail(GlobalErrorCodeConstant.GLOBAL_REQUEST_FAILED);
    }

    /**
     * 根据错误码 封装返回信息
     *
     * @param errorCode 错误码
     * @return 返回封装对象
     */
    public static <T> Result<T> fail(ErrorCode errorCode) {
        Result<T> result = result();
        String code = errorCode.getCode();
        result.setCode(code);
        result.setMsg(errorCode.getMsg());
        return result;
    }
}
