package cn.hengzq.orange.security.service;

public interface SecurityAuthenticationService {


    /**
     * 判断是否有权限
     *
     * @param permission 权限编码
     * @return true:存在 false: 不存在
     */
    boolean hasPermission(String permission);

}
