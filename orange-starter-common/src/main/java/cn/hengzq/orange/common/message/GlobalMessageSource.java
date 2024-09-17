package cn.hengzq.orange.common.message;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;


public class GlobalMessageSource extends ResourceBundleMessageSource {

    private static final GlobalMessageSource INSTANCE = new GlobalMessageSource();

    public static GlobalMessageSource getInstance() {
        return INSTANCE;
    }

    public GlobalMessageSource() {
        setDefaultEncoding("UTF-8");
        setCacheSeconds(3600); // 缓存1小时
        setBasename("i18n.global.messages");
    }

    public static MessageSourceAccessor getAccessor() {
        return new MessageSourceAccessor(getInstance());
    }

}
