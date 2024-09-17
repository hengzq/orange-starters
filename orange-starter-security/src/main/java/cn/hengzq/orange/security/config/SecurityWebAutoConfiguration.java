package cn.hengzq.orange.security.config;


import cn.hengzq.orange.security.filter.JWTTokenAuthenticationFilter;
import cn.hengzq.orange.security.service.impl.AuthenticationEntryPointImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * 只有是Spring为Web服务的时候，才自动状态当前Bean
 * ConditionalOnWebApplication 当Spring为web服务时，才使注解的类生效
 *
  * 
 */
@Slf4j
@ConditionalOnWebApplication
@AutoConfiguration
public class SecurityWebAutoConfiguration {

    public SecurityWebAutoConfiguration() {
        if (log.isDebugEnabled()) {
            log.debug("init {}.", this.getClass().getSimpleName());
        }
    }

    /**
     * 登录时需要调用AuthenticationManager.authenticate执行一次校验
     *
     * @param config
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * 调用loadUserByUsername获得UserDetail信息，在AbstractUserDetailsAuthenticationProvider里执行用户状态检查
     */
//    @Bean
//    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        // 设置密码编辑器
//        authProvider.setPasswordEncoder(passwordEncoder);
//        return authProvider;
//    }


//    @Bean
//    @ConditionalOnMissingBean
//    public UserDetailsService userDetailsService(PermissionAuthenticationService permissionAuthenticationService) {
//        if (log.isDebugEnabled()) {
//            log.debug("init UserDetailsManagerImpl complete.");
//        }
//        return new UserDetailsManagerImpl(permissionAuthenticationService);
//    }


    /**
     * JWT Token 认证过滤器 Bean
     *
     * @return
     */
    @Bean
    public JWTTokenAuthenticationFilter jwtTokenAuthenticationFilter() {
        return new JWTTokenAuthenticationFilter();
    }

    /**
     * 认证失败处理类
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPointImpl();
    }
}
