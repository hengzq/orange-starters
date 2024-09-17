package cn.hengzq.orange.common.constant;


import cn.hengzq.orange.common.exception.ErrorCode;

/**
 * 全局错误码
 * HTTP 响应状态码 https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status
 *
 * @author hengzq
 */
public interface GlobalErrorCodeConstant {

    String PREFIX = "Global.";

    ErrorCode SUCCESS = new ErrorCode("200", "success");

    // 客户端异常码

    ErrorCode GLOBAL_BAD_REQUEST = new ErrorCode(generateCode(400), "请求异常,稍后重试");

    String GLOBAL_UNAUTHORIZED_CODE = PREFIX + 401;
    ErrorCode GLOBAL_UNAUTHORIZED = new ErrorCode(GLOBAL_UNAUTHORIZED_CODE, "请登录账号后再试");

    ErrorCode GLOBAL_FORBIDDEN = new ErrorCode(generateCode(403), "您没有操作该资源的权限");
    ErrorCode GLOBAL_NOT_FOUND = new ErrorCode(generateCode(404), "资源未找到,请联系管理人员");
    ErrorCode GLOBAL_METHOD_NOT_ALLOWED = new ErrorCode(generateCode(405), "请求方法异常,请联系管理人员");
    ErrorCode GLOBAL_LOCKED = new ErrorCode(generateCode(423), "正在访问的资源已锁定，请稍后重试");

    // 服务端异常码
    ErrorCode GLOBAL_INTERNAL_SERVER_ERROR = new ErrorCode(generateCode(500), "系统异常");

    // 请求相关错误提示 编码 [1000,2000)
    ErrorCode GLOBAL_REQUEST_MISSING_PARAMETER = new ErrorCode(generateCode(1000), "请求参数缺失");
    ErrorCode GLOBAL_REQUEST_PARAMETER_CHECK_ERROR = new ErrorCode(generateCode(1001), "请求参数校验失败,请检查参数");
    ErrorCode GLOBAL_REQUEST_FAILED = new ErrorCode(generateCode(1002), "请求失败,请稍后重试");

    // 参数相关错误提示 编码 [2000,3000)
    ErrorCode GLOBAL_PARAMETER_IS_INVALID = new ErrorCode(generateCode(2000), "无效参数，请检查");

    ErrorCode GLOBAL_PARAMETER_ID_CANNOT_NULL = new ErrorCode(generateCode(2080), "ID不能为空");
    ErrorCode GLOBAL_PARAMETER_ID_IS_NULL = new ErrorCode(generateCode(2081), "ID是空的,请检查");
    ErrorCode GLOBAL_PARAMETER_ID_IS_INVALID = new ErrorCode(generateCode(2082), "无效ID,请检查");

    ErrorCode GLOBAL_PARAMETER_CANNOT_NULL = new ErrorCode(generateCode(2100), "参数不能为空");
    ErrorCode GLOBAL_PARAMETER_IS_NULL = new ErrorCode(generateCode(2101), "参数为空");
    ErrorCode GLOBAL_PARAMETER_IS_FALSE = new ErrorCode(generateCode(2102), "参数为False");
    ErrorCode GLOBAL_PARAMETER_IS_TRUE = new ErrorCode(generateCode(2103), "参数为True");

    ErrorCode GLOBAL_PARAMETER_NAME_CANNOT_NULL = new ErrorCode(generateCode(2104), "名称不能为空");


    // 数据相关提示 编码 [3000,4000)
    ErrorCode GLOBAL_DATA_NOT_EXIST = new ErrorCode(generateCode(3000), "数据不存在");
    ErrorCode GLOBAL_DATA_PRESET_CANNOT_MODIFY = new ErrorCode(generateCode(3001), "预置数据不允许修改");
    ErrorCode GLOBAL_DATA_PRESET_CANNOT_DELETE = new ErrorCode(generateCode(3002), "预置数据不允许删除");


    ErrorCode GLOBAL_AUTH_ACCOUNT_ERROR = new ErrorCode(PREFIX + "400", "登陆账号错误");
    ErrorCode GLOBAL_AUTH_PASSWORD_ERROR = new ErrorCode(PREFIX + "400", "密码错误");


    // ------------------------------- 基础业务相关错误提示 [5000,6000) -------------------------------
    String GLOBAL_USER_ID_CANNOT_NULL_CODE = PREFIX + "5000";
    ErrorCode GLOBAL_USER_ID_CANNOT_NULL = new ErrorCode(GLOBAL_USER_ID_CANNOT_NULL_CODE, "用户ID不能为空.");


    static String generateCode(Integer code) {
        return PREFIX + code;
    }
}
