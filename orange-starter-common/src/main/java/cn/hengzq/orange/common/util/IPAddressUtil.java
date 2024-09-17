package cn.hengzq.orange.common.util;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

@Slf4j
public class IPAddressUtil {

    private static final Cache<String, String> LRU_CACHE = CacheUtil.newLRUCache(100);

    /**
     * 文档：<a href="https://api.vore.top/doc/IPdata.html">https://api.vore.top/doc/IPdata.html</a>
     * <p>
     * IP地址查询
     */
    public static final String IP_URL = "https://api.vore.top/api/IPdata";

    public static String getAddressByIP(String ip) {
        if (StrUtil.isBlank(ip)) {
            return null;
        }
        if ("127.0.0.1".equals(ip)) {
            return "本地IP";
        }
        String msg = HttpUtil.get(IP_URL, Map.of("ip", ip));
        JSONObject obj = JSONUtil.parseObj(msg);
        if (!obj.containsKey("code") || obj.getInt("code") != 200) {
            log.error("查询IP地址异常：{}", msg);
            return null;
        }
        if (obj.containsKey("ipdata") && Objects.nonNull(obj.getJSONObject("ipdata"))) {
            JSONObject data = obj.getJSONObject("ipdata");
            String info2 = data.getStr("info2");
            if (StrUtil.isNotBlank(info2)) {
                return String.format("%s %s", data.getStr("info1"), data.getStr("info2"));
            } else {
                return String.format("%s %s", data.getStr("info1"), data.getStr("info3"));
            }
        }
        return null;
    }

    public static String getCacheAddressByIP(String ip) {
        if (StrUtil.isBlank(ip)) {
            return null;
        }
        String address = LRU_CACHE.get(ip);
        if (StrUtil.isNotBlank(address)) {
            return address;
        }
        address = getAddressByIP(ip);
        if (StrUtil.isBlank(address)) {
            return null;
        }
        LRU_CACHE.put(ip, address);
        return address;
    }


    public static void main(String[] args) {
        System.out.println(getCacheAddressByIP("8.130.27.84"));
    }
}
