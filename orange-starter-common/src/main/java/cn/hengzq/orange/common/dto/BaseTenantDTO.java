package cn.hengzq.orange.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hengzq
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseTenantDTO extends BaseDTO {

    @Schema(description = "租户id")
    private String tenantId;

}
