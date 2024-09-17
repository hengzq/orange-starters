package cn.hengzq.orange.common.dto.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "ID请求")
public class IdParam implements Serializable {

    @NotNull
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Serializable id;
}
