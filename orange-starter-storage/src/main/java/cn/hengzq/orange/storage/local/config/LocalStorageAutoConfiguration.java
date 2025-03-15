package cn.hengzq.orange.storage.local.config;

import cn.hengzq.orange.storage.StorageService;
import cn.hengzq.orange.storage.local.service.LocalStorageServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(value = LocalStorageProperties.class)
@ConditionalOnProperty(prefix = LocalStorageProperties.PREFIX, name = "enabled", havingValue = "true")
public class LocalStorageAutoConfiguration {

    @Bean
    public StorageService localStorageStorageService(LocalStorageProperties localStorageProperties) {
        return new LocalStorageServiceImpl(localStorageProperties);
    }
}
