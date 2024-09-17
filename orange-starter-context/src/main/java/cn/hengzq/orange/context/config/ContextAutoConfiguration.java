package cn.hengzq.orange.context.config;

import cn.hengzq.orange.context.ApplicationContextHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author hengzq
 */
@Slf4j
@AutoConfiguration
public class ContextAutoConfiguration {

    @Bean
    ApplicationContextHelper orangeApplicationContext() {
        return new ApplicationContextHelper();
    }
}