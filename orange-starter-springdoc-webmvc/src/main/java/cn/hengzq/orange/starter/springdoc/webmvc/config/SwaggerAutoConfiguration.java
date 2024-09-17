package cn.hengzq.orange.starter.springdoc.webmvc.config;

import cn.hengzq.orange.starter.springdoc.webmvc.properties.SwaggerConfigProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(SwaggerConfigProperties.class)
@ConditionalOnProperty(prefix = SwaggerConfigProperties.PREFIX, name = "enabled", havingValue = "true")
public class SwaggerAutoConfiguration {

    public SwaggerAutoConfiguration(SwaggerConfigProperties swaggerConfigProperties) {
        log.info("init {} complete.", this.getClass().getSimpleName());
        this.swaggerConfigProperties = swaggerConfigProperties;
    }

    private final SwaggerConfigProperties swaggerConfigProperties;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("接口文档")
                        .description("Orange在线接口文档")
                        .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group(swaggerConfigProperties.getName())
                .pathsToMatch("/**")
                .build();
    }
}
