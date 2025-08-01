package cn.hengzq.orange.webmvc.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = ConfigProperties.PREFIX)
public class ConfigProperties {

    /**
     * 前缀
     */
    public static final String PREFIX = "orange";

    /**
     * 预览模式
     */
    private Boolean preview = false;

}
