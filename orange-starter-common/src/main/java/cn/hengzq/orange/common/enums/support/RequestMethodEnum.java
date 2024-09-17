package cn.hengzq.orange.common.enums.support;


import cn.hengzq.orange.common.enums.BaseEnum;

/**
 * 请求方式
 *
 * @author hengzq
 */
public enum RequestMethodEnum implements BaseEnum<String> {

    /**
     * GET
     */
    GET,

    /**
     * POST
     */
    POST,

    /**
     * PUT
     */
    PUT,

    /**
     * PATCH
     */
    PATCH,

    /**
     * DELETE
     */
    DELETE;

    @Override
    public String getCode() {
        return this.name();
    }

}
