package cn.hengzq.orange.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础的用户信息
 *
 * @author hengzq
 */
@Data
public class BaseUserDTO implements Serializable {

    @Schema(description = "用户ID")
    private String id;

    @Schema(description = "用户名称")
    private String name;
}
