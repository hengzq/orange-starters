package cn.hengzq.orange.context;

import cn.hengzq.orange.common.dto.LoginUserInfo;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author hengzq
 */
@Slf4j
public class GlobalContextHelper {

    public static GlobalContext getGlobalContext() {
        return GlobalContext.getContext();
    }

    public static void removeContext() {
        GlobalContext.removeContext();
    }

    public static void setContext(String traceId) {
        getGlobalContext().withRequestId(StrUtil.isBlank(traceId) ? IdUtil.getSnowflakeNextIdStr() : traceId);
    }

    public static void setContext(LoginUserInfo userInfo) {
        if (Objects.isNull(userInfo)) {
            log.warn("set context failed. userInfo is null.");
            return;
        }
        getGlobalContext().withUserInfo(userInfo);
    }

    public static String getTenantId() {
        LoginUserInfo userInfo = getUserInfo();
        return Objects.isNull(userInfo) ? null : userInfo.getTenantId();
    }

    public static String getUserId() {
        LoginUserInfo userInfo = getUserInfo();
        return Objects.isNull(userInfo) ? null : userInfo.getUserId();
    }

    public static String getRequestId() {
        return getGlobalContext().getRequestId();
    }

    public static String getToken() {
        return getGlobalContext().getToken();
    }

    public static LoginUserInfo getUserInfo() {
        LoginUserInfo userInfo = getGlobalContext().getUserInfo();
        if (userInfo == null) {
            log.warn("getUserInfo failed. userInfo is null.");
            return null;
        }
        return userInfo;
    }
}
