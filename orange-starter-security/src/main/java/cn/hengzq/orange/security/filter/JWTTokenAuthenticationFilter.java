package cn.hengzq.orange.security.filter;

import cn.hengzq.orange.common.constant.GlobalErrorCodeConstant;
import cn.hengzq.orange.common.constant.SecurityConstant;
import cn.hengzq.orange.common.dto.LoginUserInfo;
import cn.hengzq.orange.common.result.ResultWrapper;
import cn.hengzq.orange.common.util.JwtToken;
import cn.hengzq.orange.context.GlobalContextHelper;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

@Slf4j
public class JWTTokenAuthenticationFilter extends OncePerRequestFilter {

    public JWTTokenAuthenticationFilter() {
        if (log.isDebugEnabled()) {
            log.debug("init JWTTokenAuthenticationFilter complete.");
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (log.isDebugEnabled()) {
            log.debug(" URL:{}", request.getRequestURL());
        }
        // 获取请求携带的令牌
        String token = getToken(request);
        // 没有Token直接放行，交给Spring Security处理
        if (StrUtil.isBlank(token)) {
            chain.doFilter(request, response);
            return;
        }
        LoginUserInfo userInfo = JwtToken.getUserInfo(token);
        if (Objects.isNull(userInfo)) {
            log.error("token is illegal.");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSONUtil.toJsonStr(ResultWrapper.fail(GlobalErrorCodeConstant.GLOBAL_UNAUTHORIZED)));
            return;

        }
        // 重新将用户信息封装到UsernamePasswordAuthenticationToken
        Authentication authentication = buildAuthentication(userInfo, request);
        // 将信息存入上下文对象
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 设置全局上下文
        GlobalContextHelper.setContext(userInfo);
        chain.doFilter(request, response);
    }


    /**
     * 构建UsernamePasswordAuthenticationToken
     *
     * @param userInfo 当前登录用户
     * @param request  HttpServletRequest
     */
    private static Authentication buildAuthentication(LoginUserInfo userInfo, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userInfo, null, Collections.emptyList());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return authenticationToken;
    }

    /**
     * 从请求头中获取token
     */
    private String getToken(HttpServletRequest request) {
        String authorization = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isNotBlank(authorization) && authorization.startsWith("Bearer ")) {
            return authorization.substring(7); // 提取JWT
        }
        return null;
    }
}
