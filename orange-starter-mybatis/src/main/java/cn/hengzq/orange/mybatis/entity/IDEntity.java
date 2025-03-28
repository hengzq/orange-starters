package cn.hengzq.orange.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author hengzq
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IDEntity extends AbstractEntity {

    /**
     * 主键
     */
    @TableField("id")
    private String id;


}
