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
    private String traceId;

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

    public GlobalContext withTraceId(String traceId) {
        this.traceId = traceId;
        if (StrUtil.isNotBlank(traceId)) {
            Thread.currentThread().setName(traceId);
        }
        return this;
    }

    public GlobalContext withUserInfo(LoginUserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }
}