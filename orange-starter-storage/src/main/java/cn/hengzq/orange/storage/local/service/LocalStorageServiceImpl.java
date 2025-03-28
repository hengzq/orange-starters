package cn.hengzq.orange.storage.local.service;

import cn.hengzq.orange.common.constant.GlobalErrorCodeConstant;
import cn.hengzq.orange.common.exception.ServiceException;
import cn.hengzq.orange.storage.AbstractStorageService;
import cn.hengzq.orange.storage.StorageProperties;
import cn.hengzq.orange.storage.constant.StorageMode;
import cn.hengzq.orange.storage.dto.UploadFileResult;
import cn.hengzq.orange.storage.local.config.LocalStorageProperties;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LocalStorageServiceImpl extends AbstractStorageService {

    private final LocalStorageProperties properties;

    public LocalStorageServiceImpl(LocalStorageProperties localStorageProperties) {
        this.properties = localStorageProperties;
    }

    @Override
    public StorageMode getStorageMode() {
        return StorageMode.LOCAL;
    }

    @Override
    public StorageProperties getStorageProperties() {
        return this.properties;
    }

    @Override
    public UploadFileResult upload(byte[] content, String fileName, String filePath) {
        try {
            String absolutePath = FileUtil.normalize(properties.getBasePath() + File.separator + filePath);
            FileUtil.writeBytes(content, absolutePath);
            return UploadFileResult.builder()
                    .fileName(fileName)
                    .fileSize((long) content.length)
                    .fileType(FileUtil.extName(filePath))
                    .filePath(FileUtil.normalize(filePath))
                    .build();
        } catch (Exception e) {
            throw new ServiceException(GlobalErrorCodeConstant.GLOBAL_DATA_NOT_EXIST);
        }
    }


    @Override
    public byte[] getObjectByRelativePath(String relativePath) {
        String absolutePath = FileUtil.normalize(properties.getBasePath() + File.separator + relativePath);
        try {
            return Files.readAllBytes(Paths.get(absolutePath));
        } catch (Exception e) {
            throw new ServiceException(GlobalErrorCodeConstant.GLOBAL_DATA_NOT_EXIST);
        }
    }

    @Override
    public File getFileByFileName(String fileName) {
        String absolutePath = FileUtil.normalize(properties.getBasePath() + File.separator + fileName);
        try {
            return new File(absolutePath);
        } catch (Exception e) {
            throw new ServiceException(GlobalErrorCodeConstant.GLOBAL_DATA_NOT_EXIST);
        }
    }
}
