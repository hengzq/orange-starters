package cn.hengzq.orange.storage;

public abstract class AbstractStorageService implements StorageService {

//    @Override
//    public UploadResult upload(File file) {
//        String newFileName = StorageUtil.getRelativePath() + File.separator + StorageUtil.getNewFileName(file.getName());
//        UploadResult result = this.upload(FileUtil.readBytes(file), newFileName);
//        result.setOriginalName(file.getName());
//        return result;
//    }
}
