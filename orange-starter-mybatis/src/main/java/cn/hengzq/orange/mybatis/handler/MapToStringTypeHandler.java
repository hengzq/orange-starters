package cn.hengzq.orange.mybatis.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Map<String, Object>转 String 存储
 *
 * @author hengzq
 */
@MappedTypes({Map.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MapToStringTypeHandler extends BaseTypeHandler<Map<String, Object>> {

    /**
     * 用于把 java 对象设置到 PreparedStatement 的参数中
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<String, Object> parameter, JdbcType jdbcType) throws SQLException {
        String str = JSONUtil.toJsonStr(parameter);
        ps.setString(i, str);
    }

    /**
     * 用于从 ResultSet 中根据列名取出数据转换为 java 对象
     */
    @Override
    public Map<String, Object> getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        String s = resultSet.getString(columnName);
        return getStringObjectMap(s);
    }

    /**
     * 用于从 ResultSet 中根据索引位置取出数据转换为 java 对象
     */
    @Override
    public Map<String, Object> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String s = resultSet.getString(i);
        return getStringObjectMap(s);
    }

    /**
     * 用于从 CallableStatement 中根据存储过程取出数据转换为 java 对象
     */
    @Override
    public Map<String, Object> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String s = callableStatement.getString(i);
        return getStringObjectMap(s);
    }

    private static Map<String, Object> getStringObjectMap(String s) {
        if (StrUtil.isBlank(s)) {
            return Map.of();
        }
        JSONObject entries = JSONUtil.parseObj(s);
        Map<String, Object> result = new HashMap<>();
        for (String key : entries.keySet()) {
            result.put(key, entries.get(key));
        }
        return result;
    }

}
