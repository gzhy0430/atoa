package com.xiaoba.test;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HttpTest {
//    curl -H "Content-Type: application/json" -H "X-SYS-ID: xxx" -X POST -d '{"sysCode": "xxx", "metaData": {"dbName": "NewDataBase","dbType": "mysql","tableChineseName": "门表","tableLevel": "1","tableName": "door","tableTypeCode": "A.1-1-2-2-1", "data": ["{\"da\":\"abcval\"}"], "fieldList": [{"fieldChineseName": "da","fieldElement": "da","fieldLevel": "4","fieldName": "da","fieldTypeCode": "A.1-1-2-2-11"}]}}' "http://xxx"
    public static void main(String[] args) {
        String url = "url";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-SYS-ID", "xxx");

        String body = "{}";
        HttpResponse response = HttpRequest.post(url).addHeaders(headers).timeout(5*60*1000).body(body).execute();
        log.info(response.toString());
    }
}
