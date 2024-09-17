package cn.hengzq.orange.security.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 只要依赖Starter 默认自动装配的Bean
 *
  *
 */
@Slf4j
@AutoConfiguration
public class SecurityAutoConfiguration {

    public SecurityAutoConfiguration() {
        if (log.isDebugEnabled()) {
            log.debug("init {}.", this.getClass().getSimpleName());
        }
    }

    /**
     * Spring Security 加密
     */
    @Bean
    @ConditionalOnMissingBean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(18);
    }


//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnBean(value = UserApi.class)
//    public PermissionAuthenticationService permissionAuthenticationService(UserApi userApi, PermissionApi permissionApi) {
//        return new PermissionAuthenticationMonomerServiceImpl(userApi, permissionApi);
//    }

}
