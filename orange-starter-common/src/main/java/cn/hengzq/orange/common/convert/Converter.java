package cn.hengzq.orange.common.convert;


import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * 顶层转换器
 *
 * @author hengzq
 */
public interface Converter {

    /**
     * 时间戳 转为 LocalDateTime
     *
     * @param time 时间戳 毫秒
     * @return 返回 LocalDateTime
     */
    default LocalDateTime longToLocalTime(Long time) {
        if (time == null) {
            return null;
        }
        return LocalDateTimeUtil.of(time);
    }

    /**
     * LocalDateTime 转换为 时间戳 毫秒
     *
     * @param localDateTime 时间
     * @return 返回时间戳
     */
    default Long localTimeToLong(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * date 转  LocalDateTime
     *
     * @param date date
     * @return 返回 LocalDateTime
     */
    default LocalDateTime toLocalDateTime(Date date) {
        return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
