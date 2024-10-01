package cn.hengzq.orange.mybatis.mapper;


import cn.hengzq.orange.context.GlobalContextHelper;
import cn.hengzq.orange.mybatis.entity.BaseEntity;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hengzq.orange.common.constant.PageConstant;
import cn.hengzq.orange.common.dto.PageDTO;
import cn.hengzq.orange.common.dto.param.PageParam;
import cn.hengzq.orange.mybatis.entity.AbstractEntity;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 基础Mapper
 *
 * @author hengzq
 */
public interface CommonMapper<T extends AbstractEntity> extends BaseMapper<T> {

    /**
     * 插入一条数据
     */
    default Long insertOne(T entity) {
        this.insert(entity);
        return Convert.toLong(entity.getId());
    }

    default Boolean deleteOneById(Serializable id) {
        T entity = selectById(id);
        if (Objects.isNull(entity)) {
            return true;
        }
        return deleteById(id) > 0;
    }

    default Boolean updateOneById(T entity) {
        if (Objects.isNull(entity) || Objects.isNull(entity.getId())) {
            return false;
        }
        if (entity instanceof BaseEntity e) {
            e.setUpdatedAt(LocalDateTime.now());
            e.setUpdatedBy(GlobalContextHelper.getUserId());
        }
        return this.updateById(entity) > 0;
    }


    default PageDTO<T> selectPage(PageParam param, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper) {
        return this.selectPage(param.getPageNo(), param.getPageSize(), queryWrapper);
    }

    default PageDTO<T> selectPage(Integer pageNo, Integer pageSize, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper) {
        pageNo = Objects.isNull(pageNo) ? PageConstant.PAGE_NO : pageNo;
        pageSize = Objects.isNull(pageSize) ? PageConstant.PAGE_SIZE : pageSize;
        Page<T> page = this.selectPage(new Page<T>(pageNo, pageSize), queryWrapper);
        return PageDTO.<T>of(pageNo, pageSize, (int) page.getTotal(), page.getRecords());
    }

}
