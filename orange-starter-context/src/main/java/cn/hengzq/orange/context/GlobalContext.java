package cn.hengzq.orange.context;

import cn.hengzq.orange.common.dto.LoginUserInfo;
import cn.hutool.core.util.StrUtil;
import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.Data;

/**
 * @author hengzq
 */
@Data
public class GlobalContext {

    private static final TransmittableThreadLocal<GlobalContext> LOCAL = new TransmittableThreadLocal<>() {
        @Override
        protected GlobalContext initialValue() {
            return new GlobalContext();
        }
    };

    /**
     * 日志追踪ID
     */
    private String requestId;

    private String token;

    /**
     * 当前上下文中的用户
     */
    private LoginUserInfo userInfo;

    public static GlobalContext getContext() {
        return LOCAL.get();
    }

    public static void removeContext() {
        LOCAL.remove();
    }

    public static void setContext(GlobalContext context) {
        LOCAL.set(context);
    }

    public GlobalContext withRequestId(String requestId) {
        this.requestId = requestId;
        if (StrUtil.isNotBlank(requestId)) {
            Thread.currentThread().setName(requestId);
        }
        return this;
    }

    public GlobalContext withUserInfo(LoginUserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public GlobalContext withToken(String token) {
        this.token = token;
        return this;
    }
}