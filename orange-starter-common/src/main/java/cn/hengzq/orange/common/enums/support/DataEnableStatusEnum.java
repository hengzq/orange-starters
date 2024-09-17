package cn.hengzq.orange.common.enums.support;


import cn.hengzq.orange.common.enums.BaseEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 数据启用状态
 *
 * @author hengzq
 */
@Schema(description = "数据启用类型")
public enum DataEnableStatusEnum implements BaseEnum<Integer> {

    /**
     * 启用
     */
    ENABLE(1, "启用"),

    /**
     * 禁用
     */
    DISABLE(0, "禁用");

    private final Integer code;
    private final String msg;

    DataEnableStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return msg;
    }
}
