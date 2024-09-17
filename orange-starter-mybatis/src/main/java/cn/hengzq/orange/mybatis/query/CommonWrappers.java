package cn.hengzq.orange.mybatis.query;

/**
 * @author hengzq
 */
public final class CommonWrappers {

    private CommonWrappers() {
    }

    /**
     * 获取 OrangeLambdaQueryWrapper
     *
     * @param <T> 实体类泛型
     * @return OrangeLambdaQueryWrapper
     */
    public static <T> CommonLambdaQueryWrapper<T> lambdaQuery() {
        return new CommonLambdaQueryWrapper<>();
    }

}
