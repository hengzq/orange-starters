package cn.hengzq.orange.mybatis.query;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * 增强 LambdaQueryWrapper
 *
 * @param <T> 数据类型
 * @author hengzq
 */
public class CommonLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {


    public CommonLambdaQueryWrapper<T> eqIfPresent(SFunction<T, ?> column, String val) {
        if (StrUtil.isNotBlank(val)) {
            return (CommonLambdaQueryWrapper<T>) super.eq(column, val);
        }
        return this;
    }

    public CommonLambdaQueryWrapper<T> eqIfPresent(SFunction<T, ?> column, Object val) {
        if (Objects.nonNull(val)) {
            return (CommonLambdaQueryWrapper<T>) super.eq(column, val);
        }
        return this;
    }


    public CommonLambdaQueryWrapper<T> likeIfPresent(SFunction<T, ?> column, String val) {
        if (StringUtils.hasText(val)) {
            return (CommonLambdaQueryWrapper<T>) super.like(column, val);
        }
        return this;
    }

    public CommonLambdaQueryWrapper<T> inIfPresent(SFunction<T, ?> column, List<?> vals) {
        if (CollUtil.isNotEmpty(vals)) {
            return (CommonLambdaQueryWrapper<T>) super.in(column, vals);
        }
        return this;
    }

}
