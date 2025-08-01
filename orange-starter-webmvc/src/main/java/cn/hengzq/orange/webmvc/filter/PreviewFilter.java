package cn.hengzq.orange.webmvc.filter;

import cn.hengzq.orange.common.constant.GlobalErrorCodeConstant;
import cn.hengzq.orange.common.result.ResultWrapper;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class PreviewFilter implements Filter {



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if ("DELETE".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405
            httpResponse.setContentType("application/json;charset=UTF-8");
            httpResponse.getWriter().write(JSONUtil.toJsonStr(ResultWrapper.fail(GlobalErrorCodeConstant.GLOBAL_PREVIEW)));
            httpResponse.getWriter().flush();
            return;
        }
        chain.doFilter(request, response);
    }
}
