package cn.hengzq.orange.security.config;


import cn.hengzq.orange.security.filter.JWTTokenAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * EnableMethodSecurity
 * prePostEnabled 默认：true 解锁 @PreAuthorize 和 @PostAuthorize 两个注解
 * <p>
 * ConditionalOnWebApplication 当Spring为web服务时，才使注解的类生效
 */
@Slf4j
@AutoConfiguration
@EnableMethodSecurity
public class SecurityAutoConfigurationAdapter {

    private final JWTTokenAuthenticationFilter jwtTokenAuthenticationFilter;


    private final AuthenticationEntryPoint authenticationEntryPoint;

    public SecurityAutoConfigurationAdapter(JWTTokenAuthenticationFilter jwtTokenAuthenticationFilter,
                                            AuthenticationEntryPoint authenticationEntryPoint) {
        this.jwtTokenAuthenticationFilter = jwtTokenAuthenticationFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
        if (log.isDebugEnabled()) {
            log.debug("init {}.", this.getClass().getSimpleName());
        }
    }

    /**
     * 配置 URL安全配置
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security
                // 禁用basic明文验证
                .httpBasic(AbstractHttpConfigurer::disable)
                // 前后端分离架构不需要csrf保护
                .csrf(AbstractHttpConfigurer::disable)
                // 禁用默认登录页
                .formLogin(AbstractHttpConfigurer::disable)
                // 禁用默认登出页
                .logout(AbstractHttpConfigurer::disable)
                // 设置异常的EntryPoint，如果不设置，默认使用:Http403ForbiddenEntryPoint
                .exceptionHandling(exceptions -> exceptions.authenticationEntryPoint(authenticationEntryPoint))
                // 前后端分离是无状态的，不需要session了，直接禁用。
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        // 允许所有OPTIONS请求
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        // 静态资源，可匿名访问
                        .requestMatchers(HttpMethod.GET, "/webjars/**", "*.html", "*.ico").permitAll()
                        // api文档接口，可匿名访问
                        .requestMatchers(HttpMethod.GET, "/v3/api-docs/*").permitAll()
                        // 允许直接访问授权登录接口
                        .requestMatchers(HttpMethod.POST, "/orange-system/v1.0/auth/login").permitAll()
                        // 允许直接访问的授权相关接口
                        .requestMatchers(HttpMethod.GET, "/orange-system/v1.0/auth/password-encrypt").permitAll()
                        // 允许 SpringMVC 的默认错误地址匿名访问
                        .requestMatchers("/error").permitAll()
                        // 允许任意请求被已登录用户访问
                        .anyRequest().authenticated())
                // 加我们自定义的过滤器，替代UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return security.build();
    }

}
