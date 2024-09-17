package cn.hengzq.orange.webmvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hengzq
 */
@Slf4j
@AutoConfiguration
public class WebMvcAutoConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("initialize addInterceptors.");
        //  添加拦截器 顺序不可调整

    }

}