package cn.hengzq.orange.webmvc.config;

import cn.hengzq.orange.webmvc.constant.FilterOrderConstant;
import cn.hengzq.orange.webmvc.filter.RequestIdFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@Slf4j
@AutoConfiguration
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

}