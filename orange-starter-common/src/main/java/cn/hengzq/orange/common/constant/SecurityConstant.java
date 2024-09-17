package cn.hengzq.orange.common.constant;

/**
 * @author hengzq
 */
public interface SecurityConstant {


    /**
     * 新用户默认密码
     */
    String DEFAULT_USER_PASSWORD = "orange-ai.cc";


    String AUTHORIZATION = "Authorization";

    /**
     * Token Key
     */
    String TOKEN = "orange-ai-token";

    /**
     * token 过期时间
     */
    long TOKEN_EXPIRE_TIME = 12 * 3600 * 1000;

    /**
     * 发行人
     */
    String ISSUER = "orange-ai";


    /**
     * 用户ID
     */
    String PAYLOAD_KEY_ID = "userId";

    /**
     * 用户信息
     */
    String PAYLOAD_KEY_USER_INFO = "userInfo";

    /**
     * 租户id
     */
    String PAYLOAD_KEY_TENANT_ID = "tenantId";

    /**
     * 用户登陆账号
     */
    String PAYLOAD_KEY_USERNAME = "username";

    /**
     * 秘钥key
     */
    String DEFAULT_SECRET_KEY = "OrangeAi2024.";

}