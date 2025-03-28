package cn.hengzq.orange.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author hengzq
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfo implements Serializable {

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 登陆用户ID
     */
    private String userId;


    /**
     * 登陆账号
     */
    private String loginAccount;

}
