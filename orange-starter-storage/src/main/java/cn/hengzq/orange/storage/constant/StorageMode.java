package cn.hengzq.orange.storage.constant;

import cn.hengzq.orange.common.enums.BaseEnum;
import lombok.Getter;

import java.util.Locale;

/**
 * 存储方式
 *
 * @author hengzq
 */
@Getter
public enum StorageMode implements BaseEnum<String> {

    /**
     * 本地
     */
    LOCAL("本地存储"),

    /**
     * 阿里云
     */
    ALIYUN("阿里云存储");


    private final String msg;

    StorageMode(String msg) {
        this.msg = msg;
    }

    public static StorageMode getByName(String name) {
        return valueOf(name.toUpperCase(Locale.ROOT));
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
