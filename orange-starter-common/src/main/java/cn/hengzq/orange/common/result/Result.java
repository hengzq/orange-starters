package cn.hengzq.orange.common.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author hengzq
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Schema(description = "响应结果")
public class Result<T> extends AbstractResult {

    @Schema(description = "响应的数据")
    private T data;

}
