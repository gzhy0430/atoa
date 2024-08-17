package com.xiaoba.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class TimeUtilX {
//    2022-11-09 11:10:00:007
    public static String fmtpreminute(LocalDateTime localDateTime, int count){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:").format(localDateTime.minusMinutes(count)) + "00";
    }

    public static Date fromlocaldatetime(LocalDateTime localDateTime){
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
