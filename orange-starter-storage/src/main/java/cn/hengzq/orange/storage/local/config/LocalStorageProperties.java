package cn.hengzq.orange.storage.local.config;

import cn.hengzq.orange.storage.StorageProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ 日志配置
 */
@Data
@ConfigurationProperties(LocalStorageProperties.PREFIX)
public class LocalStorageProperties implements StorageProperties {

    /**
     * 前缀
     */
    public static final String PREFIX = "orange.system.storage.local";

    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * 本地存储根路径
     */
    private String basePath = "D://temp";


    /**
     * 项目服务路径地址
     */
    private String servicePath = "http://tiny.hengzq.cn/rest-api";


    @Override
    public String getServicePath() {
        return this.servicePath;
    }
}
