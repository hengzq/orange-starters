package cn.hengzq.orange.starter.springdoc.webmvc.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = SwaggerConfigProperties.PREFIX)
public class SwaggerConfigProperties {

    /**
     * 前缀
     */
    public static final String PREFIX = "orange.swagger";

    /**
     * 是否开启
     */
    private boolean enabled;

    /**
     * 项目名称
     */
    private String name;

}
