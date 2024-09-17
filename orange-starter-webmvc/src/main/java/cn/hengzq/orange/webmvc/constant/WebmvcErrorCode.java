package cn.hengzq.orange.webmvc.constant;


import cn.hengzq.orange.common.constant.GlobalErrorCodeConstant;
import cn.hengzq.orange.common.exception.ErrorCode;

public interface WebmvcErrorCode extends GlobalErrorCodeConstant {
    String PREFIX = "Webmvc.";

    ErrorCode WEBMVC_HTTP_REQUEST_METHOD_NOT_SUPPORTED = new ErrorCode(PREFIX + "0001", "不支持该请求，请检查URL是否正确");
}
