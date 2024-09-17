package cn.hengzq.orange.common.enums.support;


import cn.hengzq.orange.common.enums.BaseEnum;

/**
 * sys_common_data_preset_flag
 * 预设标记 自定义数据或预置数据
 *
 * @author hengzq
 */
public enum DataPresetStatusEnum implements BaseEnum<Integer> {

    /**
     * 预置数据
     */
    PRESET(1, "预置数据"),

    /**
     * 自定义数据
     */
    CUSTOM(0, "自定义数据");

    private final Integer code;
    private final String msg;

    DataPresetStatusEnum(Integer code, String msg) {
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
