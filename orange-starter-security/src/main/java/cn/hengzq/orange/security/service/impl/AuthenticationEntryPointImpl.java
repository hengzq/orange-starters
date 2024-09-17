package cn.hengzq.orange.security.service.impl;

import cn.hengzq.orange.common.constant.GlobalErrorCodeConstant;
import cn.hengzq.orange.common.result.Result;
import cn.hengzq.orange.common.result.ResultWrapper;
import cn.hutool.extra.servlet.JakartaServletUtil;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * 访问需要认证的资源失败，返回错误提示信息
 */
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        if (log.isDebugEnabled()) {
            log.debug("No permission to access. URL:{}", request.getRequestURI());
        }
        Result<Object> result = ResultWrapper.fail(GlobalErrorCodeConstant.GLOBAL_FORBIDDEN);
        String content = JSONUtil.toJsonStr(result);
        response.setCharacterEncoding("UTF-8");
        JakartaServletUtil.write(response, content, MediaType.APPLICATION_JSON_VALUE);
    }
}
