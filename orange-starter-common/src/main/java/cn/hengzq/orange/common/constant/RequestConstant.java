package cn.hengzq.orange.common.constant;

/**
 * 请求常量
 *
 * @author hengzq
 */
public interface RequestConstant {

    /**
     * 内部请求头Key
     */
    interface InnerHeader {
        /**
         * 请求头 租户ID Key
         */
        String ORANGE_INNER_TENANT_ID = "orange-ai-inner-tenant-id";

        /**
         * 请求头 用户ID
         */
        String ORANGE_INNER_USER_ID = "orange-ai-inner-user-id";

        /**
         * 请求头 requestId
         */
        String ORANGE_INNER_REQUEST_ID = "orange-ai-inner-request-id";

    }

    /**
     * 响应请求头
     */
    interface ResponseHeader {
        /**
         * 请求头 requestId
         */
        String ORANGE_REQUEST_ID = "orange-ai-request-id";

    }
}
