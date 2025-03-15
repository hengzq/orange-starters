package cn.hengzq.orange.storage;

import cn.hengzq.orange.storage.constant.StorageMode;
import cn.hengzq.orange.storage.dto.UploadFileResult;

import java.io.File;

/**
 * 存储服务
 *
 * @author hengzq
 */
public interface StorageService {

    /**
     * 获取存储方式
     */
    StorageMode getStorageMode();

    /**
     * 获取存储配置
     */
    StorageProperties getStorageProperties();

    /**
     * 文件上传
     */
    UploadFileResult upload(byte[] content, String relativePath);

    @Deprecated
    byte[] getObjectByRelativePath(String relativePath);

    File getFileByFileName(String fileName);

//
//    /**
//     * 获得文件的内容
//     *
//     * @param path 相对路径
//     * @return 文件的内容
//     */
//    byte[] getContent(String path);

}
