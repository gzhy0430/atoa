package com.xiaoba.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.UUID;

@Slf4j
public class Test {
    public static void main(String[] args) {
//        for(int i = 0; i < 10; i++){
//            log.info(UUID.randomUUID().toString());//.replaceAll("-", "")
//        }
        String now = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
        log.info(UUID.randomUUID().toString().replaceAll("-", "").substring(19) + now);
//        log.info(DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS"));
    }
}
