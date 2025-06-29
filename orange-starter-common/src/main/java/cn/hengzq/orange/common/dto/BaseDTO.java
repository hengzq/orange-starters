package cn.hengzq.orange.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author hengzq
 */
@Data
public class BaseDTO implements Serializable {

    @Schema(description = "创建人ID")
    private String createdBy;

    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

    @Schema(description = "更新人ID")
    private String updatedBy;

    @Schema(description = "更新时间")
    private LocalDateTime updatedAt;

}
