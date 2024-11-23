package cn.hengzq.orange.context;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class ApplicationContextHelper implements ApplicationContextAware {

    @Getter
    private static ApplicationContext applicationContext;

    /**
     * Spring容器会在创建该Bean之后，自动调用该Bean的setApplicationContext方法
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (ApplicationContextHelper.applicationContext == null) {
            ApplicationContextHelper.applicationContext = applicationContext;
        }
    }


    /**
     * 通过name获取 Bean
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 通过class获取所有的Bean
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return getApplicationContext().getBeansOfType(clazz);
    }


}