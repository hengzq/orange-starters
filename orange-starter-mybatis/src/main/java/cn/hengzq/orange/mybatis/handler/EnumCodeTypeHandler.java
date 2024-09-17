package cn.hengzq.orange.mybatis.handler;


import cn.hengzq.orange.common.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 枚举类型转换 存储枚举编码（code）
 *
 * @author hengzq
 */
@MappedTypes({BaseEnum.class})
public class EnumCodeTypeHandler<T extends Serializable, E extends BaseEnum<T>> extends BaseTypeHandler<E> {

    /**
     * 第一个code
     */
    private T firstKey;
    private final Map<Object, E> map = new HashMap<>();

    public EnumCodeTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        E[] enums = type.getEnumConstants();
        if (enums == null) {
            return;
        }
        for (E e : enums) {
            firstKey = Objects.isNull(firstKey) ? e.getCode() : firstKey;
            map.put(e.getCode(), e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i, e.getCode());
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if (firstKey instanceof Integer) {
            return map.get(resultSet.getInt(s));
        }
        if (firstKey instanceof String) {
            return map.get(resultSet.getString(s));
        }
        return map.get(resultSet.getObject(s));
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if (firstKey instanceof Integer) {
            return map.get(resultSet.getInt(i));
        }
        if (firstKey instanceof String) {
            return map.get(resultSet.getString(i));
        }
        return map.get(resultSet.getObject(i));
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        if (firstKey instanceof Integer) {
            return map.get(callableStatement.getInt(i));
        }
        if (firstKey instanceof String) {
            return map.get(callableStatement.getString(i));
        }
        return map.get(callableStatement.getObject(i));
    }

}
