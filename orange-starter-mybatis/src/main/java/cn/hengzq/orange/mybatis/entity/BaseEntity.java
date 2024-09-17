package cn.hengzq.orange.mybatis.entity;

import cn.hengzq.orange.context.GlobalContextHelper;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 基础实体类
 *
 * @author hengzq
 */
@EqualsAndHashCode(callSuper = true)
@Setter
public class BaseEntity extends IDEntity {

    /**
     * 创建者账号
     */
    @TableField("created_by")
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新者账号
     */
    @TableField("updated_by")
    private Long updatedBy;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;

    public Long getCreatedBy() {
        return Objects.isNull(createdBy) ? GlobalContextHelper.getUserId() : createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return Objects.isNull(createdAt) ? LocalDateTime.now() : createdAt;
    }

    public Long getUpdatedBy() {
        return Objects.isNull(updatedBy) ? GlobalContextHelper.getUserId() : updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return Objects.isNull(updatedAt) ? LocalDateTime.now() : updatedAt;
    }
}
