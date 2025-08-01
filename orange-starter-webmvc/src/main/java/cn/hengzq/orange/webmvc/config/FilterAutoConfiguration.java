package cn.hengzq.orange.webmvc.config;

import cn.hengzq.orange.webmvc.constant.FilterOrderConstant;
import cn.hengzq.orange.webmvc.filter.PreviewFilter;
import cn.hengzq.orange.webmvc.filter.RequestIdFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(ConfigProperties.class)
public class FilterAutoConfiguration {

    /**
     * 注册 RequestId 过滤器
     */
    @Bean
    public FilterRegistrationBean<RequestIdFilter> registrationRequestIdFilter() {
        FilterRegistrationBean<RequestIdFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new RequestIdFilter());
        filterRegistrationBean.setName("requestIdFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(FilterOrderConstant.REQUEST_ID_FILTER);
        if (log.isDebugEnabled()) {
            log.debug("init RequestIdFilter complete.");
        }
        return filterRegistrationBean;
    }

    @Bean
    @ConditionalOnProperty(prefix = ConfigProperties.PREFIX, name = "preview", havingValue = "true")
    public FilterRegistrationBean<PreviewFilter> previewFilterRegistration() {
        FilterRegistrationBean<PreviewFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new PreviewFilter());
        registration.setName("previewFilter");
        registration.addUrlPatterns("/*");
        registration.setOrder(FilterOrderConstant.PREVIEW_FILTER);
        if (log.isDebugEnabled()) {
            log.debug("init previewFilter complete.");
        }
        return registration;
    }
}