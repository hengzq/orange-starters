package cn.hengzq.orange.webmvc.config;

import cn.hengzq.orange.common.constant.GlobalErrorCodeConstant;
import cn.hengzq.orange.common.exception.ServiceException;
import cn.hengzq.orange.common.message.GlobalMessageSource;
import cn.hengzq.orange.common.result.Result;
import cn.hengzq.orange.common.result.ResultWrapper;
import cn.hengzq.orange.webmvc.constant.WebmvcErrorCode;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

/**
 * 基础异常统一处理
 */
@Slf4j
@AutoConfiguration
@AllArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义参数异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handle(MethodArgumentNotValidException e) {
        //获取参数校验错误集合
        List<FieldError> fieldErrors = e.getFieldErrors();
        log.warn("the request parameter verification failed. fieldErrors:{}", fieldErrors);
        //给用户提供友好的错误提示
        StringBuilder msg = new StringBuilder();
        msg.append(String.format("[%s]个参数校验错误: ", fieldErrors.size()));
        for (FieldError error : fieldErrors) {
            msg.append("[").append(error.getField()).append("]");
            if (StrUtil.isNotBlank(error.getDefaultMessage())) {
                String tempMsg = GlobalMessageSource.getAccessor().getMessage(error.getDefaultMessage(), "参数错误");
                msg.append(tempMsg);
            }
            msg.append(";");
        }
        Result<Object> result = ResultWrapper.fail();
        result.setCode(GlobalErrorCodeConstant.GLOBAL_REQUEST_PARAMETER_CHECK_ERROR.getCode());
        result.setMsg(msg.toString());
        return result;
    }

    /**
     * 自定义参数异常
     */
    @ExceptionHandler(HandlerMethodValidationException.class)
    public Result<Object> handlerMethodValidationException(HandlerMethodValidationException e) {
        //获取参数校验错误集合
        List<? extends MessageSourceResolvable> fieldErrors = e.getAllErrors();
        log.warn("the request parameter verification failed. fieldErrors:{}", fieldErrors);
        //给用户提供友好的错误提示
        StringBuilder msg = new StringBuilder();
        msg.append(String.format("[%s]个参数校验错误: ", fieldErrors.size()));
        for (MessageSourceResolvable error : fieldErrors) {
            if (error instanceof FieldError fieldError) {
                msg.append("[").append(fieldError.getField()).append("]");
            }
            if (StrUtil.isNotBlank(error.getDefaultMessage())) {
                String tempMsg = GlobalMessageSource.getAccessor().getMessage(error.getDefaultMessage(), "参数错误");
                msg.append(tempMsg);
            }
            msg.append(";");
        }
        Result<Object> result = ResultWrapper.fail();
        result.setCode(GlobalErrorCodeConstant.GLOBAL_REQUEST_PARAMETER_CHECK_ERROR.getCode());
        result.setMsg(msg.toString());
        return result;
    }

    /**
     * 自定义服务异常处理
     */
    @ExceptionHandler({ServiceException.class,})
    public Result<?> handleServiceException(ServiceException e) {
        log.error("handleServiceException, code:{} msg:{}", e.getErrorCode().getCode(), e.getErrorCode().getMsg());
        return ResultWrapper.fail(e.getErrorCode());
    }

    /**
     * 不支持接口异常处理
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class,})
    public Result<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException msg:{}", e.getMessage());
        return ResultWrapper.fail(WebmvcErrorCode.WEBMVC_HTTP_REQUEST_METHOD_NOT_SUPPORTED);
    }

    /**
     * 枚举值匹配异常
     */
    @ExceptionHandler({HttpMessageNotReadableException.class,})
    public Result<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("handleHttpMessageNotReadableException msg:{}", e.getMessage());
        return ResultWrapper.fail(WebmvcErrorCode.GLOBAL_REQUEST_PARAMETER_CHECK_ERROR);
    }

    /**
     * security 异常处理
     */
//    @ExceptionHandler(AccessDeniedException.class)
//    public Result<?> handleException(AccessDeniedException e) {
//        log.error("handleException msg:{} ", e.getMessage(), e);
//        return ResultWrapper.fail(GlobalErrorCodeConstant.GLOBAL_FORBIDDEN);
//    }


    /**
     * 资源未找到异常
     */
    @ExceptionHandler({NoResourceFoundException.class,})
    public Result<?> handleNoResourceFoundException(NoResourceFoundException e) {
        log.error("handleNoResourceFoundException msg:{}", e.getMessage());
        return ResultWrapper.fail(WebmvcErrorCode.GLOBAL_NOT_FOUND);
    }

    /**
     * 最大的异常捕获
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error("handleException msg:{} ", e.getMessage(), e);
        return ResultWrapper.fail();
    }

}
