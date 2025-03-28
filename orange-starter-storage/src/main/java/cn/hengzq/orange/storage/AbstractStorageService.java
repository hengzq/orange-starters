package cn.hengzq.orange.storage;

import cn.hengzq.orange.storage.dto.UploadFileResult;
import cn.hengzq.orange.storage.util.StorageUtil;

import java.io.File;

public abstract class AbstractStorageService implements StorageService {


    protected abstract UploadFileResult upload(byte[] content, String fileName, String filePath);

    @Override
    public UploadFileResult upload(byte[] content, String fileName) {
        String newFileName = StorageUtil.getNewFileName(fileName);
        String filePath = StorageUtil.getRelativePath() + File.separator + newFileName;
        return this.upload(content, fileName, filePath);
    }


//    @Override
//    public UploadResult upload(File file) {
//        String newFileName = StorageUtil.getRelativePath() + File.separator + StorageUtil.getNewFileName(file.getName());
//        UploadResult result = this.upload(FileUtil.readBytes(file), newFileName);
//        result.setOriginalName(file.getName());
//        return result;
//    }
}
