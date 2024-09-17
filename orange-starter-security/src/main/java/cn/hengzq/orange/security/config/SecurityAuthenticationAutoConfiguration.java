package cn.hengzq.orange.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
 * 安全认证自动装配
 */
@Slf4j
@AutoConfiguration
public class SecurityAuthenticationAutoConfiguration {

    public SecurityAuthenticationAutoConfiguration() {
        if (log.isDebugEnabled()) {
            log.debug("init {}.", this.getClass().getSimpleName());
        }
    }

//    @Bean("ss")
//    public SecurityAuthenticationService securityAuthenticationService(PermissionAuthenticationService permissionAuthenticationService) {
//        if (log.isDebugEnabled()) {
//            log.debug("init SecurityAuthenticationServiceImpl complete.");
//        }
//        return new SecurityAuthenticationServiceImpl(permissionAuthenticationService);
//    }

}
