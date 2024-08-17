package com.xiaoba.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FastJsonUtilX {

    private static SerializeConfig mapping = new SerializeConfig();

    static {
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    public static String obj2json(Object obj) {
//         return JSON.toJSONString(obj, SerializerFeature.UseSingleQuotes);//使用单引号
//        return JSON.toJSONString(obj,true);//格式化数据，方便阅读
//        return JSON.toJSONString(obj, mapping, SerializerFeature.WriteMapNullValue, SerializerFeature.QuoteFieldNames, SerializerFeature.WriteClassName);
        return JSON.toJSONString(obj, mapping, SerializerFeature.WriteMapNullValue, SerializerFeature.QuoteFieldNames);
    }

    public static <T> T json2obj(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }

    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
        return JSON.parseArray(jsonArrayStr, clazz);
    }

    public static <T> Map<String, Object> json2map(String jsonStr) {
        return json2obj(jsonStr, Map.class);
    }

    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) {
        Map<String, T> map = JSON.parseObject(jsonStr,
                new TypeReference<Map<String, T>>() {
                });
        for (Entry<String, T> entry : map.entrySet()) {
            JSONObject obj = (JSONObject) entry.getValue();
            map.put(entry.getKey(), JSONObject.toJavaObject(obj, clazz));
        }
        return map;
    }

    public static String[] json2Array(String jsonStr) {
        String str[] = null;
        JSONArray jsonArr = JSON.parseArray(jsonStr);
        int count = jsonArr.size();
        str = new String[count];
        for (int k = 0; k < count; k++) {
            str[k] = (String) jsonArr.get(k);
        }
        return str;
    }
}
