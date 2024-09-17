package cn.hengzq.orange.common.constant;

/**
 * 租户常量
 *
 * @author hengzq
 */
public interface TenantConstant {

    /**
     * 默认租户ID列名
     */
    String DEFAULT_TENANT_ID_COLUMN = "tenant_id";

    /**
     * 工作流租户列名
     */
    String ACT_TENANT_ID_COLUMN = "tenant_id_";

    /**
     * 默认系统用户id
     */
    Long DEFAULT_USER_ID = -100L;

    /**
     * 默认系统租户id
     */
    Long DEFAULT_TENANT_ID = -100L;

}
