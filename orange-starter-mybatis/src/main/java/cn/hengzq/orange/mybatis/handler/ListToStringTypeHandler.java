package cn.hengzq.orange.mybatis.handler;

import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * List 转 String 存储 以","分隔
 *
 * @author hengzq
 */
@MappedTypes({List.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ListToStringTypeHandler extends BaseTypeHandler<List<String>> {

    /**
     * 用于把 java 对象设置到 PreparedStatement 的参数中
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.join(",", parameter));
    }

    /**
     * 用于从 ResultSet 中根据列名取出数据转换为 java 对象
     */
    @Override
    public List<String> getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        String s = resultSet.getString(columnName);
        return StrUtil.isBlank(s) ? List.of() : Arrays.asList(s.split(","));
    }

    /**
     * 用于从 ResultSet 中根据索引位置取出数据转换为 java 对象
     */
    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String s = resultSet.getString(i);
        return StrUtil.isBlank(s) ? List.of() : Arrays.asList(s.split(","));
    }

    /**
     * 用于从 CallableStatement 中根据存储过程取出数据转换为 java 对象
     */
    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String s = callableStatement.getString(i);
        return StrUtil.isBlank(s) ? List.of() : Arrays.asList(s.split(","));
    }
}
