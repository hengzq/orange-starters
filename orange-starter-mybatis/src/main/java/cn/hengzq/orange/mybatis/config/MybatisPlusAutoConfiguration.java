package cn.hengzq.orange.mybatis.config;

import cn.hengzq.orange.context.GlobalContextHelper;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import cn.hengzq.orange.common.constant.TenantConstant;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author hengzq
 */
@Slf4j
@AutoConfiguration
@MapperScan("cn.hengzq.orange.**.mapper")
public class MybatisPlusAutoConfiguration {

    public MybatisPlusAutoConfiguration() {
        if (log.isDebugEnabled()) {
            log.debug("init {} complete.", this.getClass().getSimpleName());
        }
    }

    private static final List<String> IGNORE_TABLES = List.of("sys_tenant", "sys_tenant_package", "sys_area");

    /**
     * 参考：https://baomidou.com/pages/aef2f2/#%E5%B1%9E%E6%80%A7%E4%BB%8B%E7%BB%8D
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        //如果用了分页插件注意先 add TenantLineInnerInterceptor 再 add PaginationInnerInterceptor
        //用了分页插件必须设置 MybatisConfiguration#useDeprecatedExecutor = false
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {
            // 获取当前租户id
            @Override
            public Expression getTenantId() {
                if (log.isDebugEnabled()) {
                    log.debug("mybatis get tenant. tenantId: [{}]", GlobalContextHelper.getTenantId());
                }
                // @TODO 处理租户ID
                return new LongValue(GlobalContextHelper.getTenantId() == null ? TenantConstant.DEFAULT_TENANT_ID : GlobalContextHelper.getTenantId());
            }

            @Override
            public String getTenantIdColumn() {
                return TenantConstant.DEFAULT_TENANT_ID_COLUMN;
            }

            // 这是 default 方法,默认返回 false 表示所有表需要拼租户条件
            @Override
            public boolean ignoreTable(String tableName) {
                return IGNORE_TABLES.contains(tableName);
            }
        }));
        //  添加分页组件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
