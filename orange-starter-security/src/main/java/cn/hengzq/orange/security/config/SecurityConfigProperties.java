package cn.hengzq.orange.security.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = SecurityConfigProperties.PREFIX)
public class SecurityConfigProperties {

    /**
     * 前缀
     */
    public static final String PREFIX = "orange.security";

    /**
     * 白名单URL列表
     */
    private List<String> whiteListUrl = List.of();

}
