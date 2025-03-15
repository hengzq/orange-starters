package cn.hengzq.orange.storage.aliyun.config;

import cn.hengzq.orange.storage.StorageProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * aliyun 配置参数
 */
@Data
@ConfigurationProperties(AliyunStorageProperties.PREFIX)
public class AliyunStorageProperties implements StorageProperties {

    /**
     * 前缀
     */
    public static final String PREFIX = "orange.system.storage.aliyun";

    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * Endpoint（地域节点）
     * eg:oss-cn-beijing.aliyuncs.com
     */
    private String endPoint;

    /**
     * Bucket 名称
     */
    private String bucketName;

    /**
     * 查看AccessKey https://ram.console.aliyun.com/manage/ak
     */
    private String accessKeyId;

    private String accessKeySecret;

    /**
     * 项目服务路径地址
     */
    private String servicePath = "http://tiny.hengzq.cn/rest-api";


    @Override
    public String getServicePath() {
        return this.servicePath;
    }
}
