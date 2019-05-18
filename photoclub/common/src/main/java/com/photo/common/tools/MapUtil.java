package com.photo.common.tools;

import java.util.Map;

public class MapUtil {



    /**
     * 校验 请求参数中 是否包含指定 参数
     *
     * @return
     */
    public static boolean containsKeys(Map<String, Object> params, String... args) {
        for (String arg : args
        ) {
            if (!params.containsKey(arg))
                return false;
        }
        return true;
    }


    /**
     * 针对 请求参数 中 String value 进行非空校验
     *
     * @param params
     * @param args
     * @return
     */
    public static boolean isNotEmptyStringValues(Map<String, Object> params, String... args) {
        for (String arg : args
        ) {
            String value = String.valueOf(params.get(arg));
            if (StringUtil.isEmpty(value))
                return false;
        }
        return true;
    }

    /**
     * 获取 Map 中的 整型 数据
     *
     * @param map
     * @param key
     * @return
     */
    public static Integer getInt(Map<String, Object> map, String key) {

        if (map == null || map.size() <= 0)
            return null;

        if (map.containsKey(key)) {
            Integer value = Integer.valueOf(String.valueOf(map.get(key)));
            return value;
        }
        return null;
    }


    /**
     * 获取 Map 中的 字符串 数据
     *
     * @param params
     * @param key
     * @return
     */
    public static String getString(Map<String, Object> params, String key) {
        String value = String.valueOf(params.get(key));
        return value;
    }
}
