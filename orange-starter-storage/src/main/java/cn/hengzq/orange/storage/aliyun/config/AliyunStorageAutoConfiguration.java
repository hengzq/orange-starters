package cn.hengzq.orange.storage.aliyun.config;

import cn.hengzq.orange.storage.StorageService;
import cn.hengzq.orange.storage.aliyun.service.AliyunStorageServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(AliyunStorageProperties.class)
@ConditionalOnProperty(prefix = AliyunStorageProperties.PREFIX, name = "enabled", havingValue = "true")
public class AliyunStorageAutoConfiguration {


    /**
     * 阿里云存储服务
     */
    @Bean
    public StorageService aliyunStorageStorageService(AliyunStorageProperties properties) {
        return new AliyunStorageServiceImpl(properties);
    }
}
