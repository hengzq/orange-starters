package cn.hengzq.orange.mybatis.entity;

import cn.hengzq.orange.context.GlobalContextHelper;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Setter;

import java.util.Objects;


/**
 * 包含租户的基础实体类
 *
 * @author hengzq
 */
@Setter
public class BaseTenantEntity extends BaseEntity {

    /**
     * 租户id
     */
    @TableField("tenant_id")
    private String tenantId;


    public String getTenantId() {
        return Objects.isNull(tenantId) ? GlobalContextHelper.getTenantId() : tenantId;
    }

}
