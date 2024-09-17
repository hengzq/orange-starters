package cn.hengzq.orange.common.enums;

import java.io.Serializable;

/**
 * 基础枚举
 *
 * @author hengzq
 */
public interface BaseEnum<T extends Serializable> {

    /**
     * 获取code编码
     *
     * @return 返回code编码
     */
    T getCode();

}
