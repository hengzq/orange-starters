package cn.hengzq.orange.common.util;

import cn.hutool.core.collection.CollUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 集合工具类
 *
 * @author hengzq
 */
public class CollUtils {

    private CollUtils() {
    }

    public static <T, U> List<U> convertList(Collection<T> collection, Function<T, U> func) {
        if (CollUtil.isEmpty(collection)) {
            return List.of();
        }
        return collection.stream().map(func).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static <T, U> Set<U> convertSet(Collection<T> collection, Function<T, U> func) {
        if (CollUtil.isEmpty(collection)) {
            return Set.of();
        }
        return collection.stream().map(func).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public static <T, K> Map<K, T> convertMap(Collection<T> collection, Function<T, K> key) {
        return convertMap(collection, key, Function.identity());
    }

    public static <T, K, V> Map<K, V> convertMap(Collection<T> collection, Function<T, K> key, Function<T, V> value) {
        if (CollUtil.isEmpty(collection)) {
            return Map.of();
        }
        return collection.stream().filter(Objects::nonNull).collect(Collectors.toMap(key, value, (v1, v2) -> v1));
    }

}