package cn.hengzq.orange.common.enums.support;


import cn.hengzq.orange.common.enums.BaseEnum;

/**
 * 通用数据操作状态
 *
 * @author hengzq
 */

public enum OperationStatusEnum implements BaseEnum<Integer> {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 失败
     */
    FAIL(1, "失败");

    private final Integer code;
    private final String msg;

    OperationStatusEnum(Integer code, String msg) {
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
