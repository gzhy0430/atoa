package com.xiaoba.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("test")
public class TestAction {
    /**
     * http://localhost:8080/app/test/hello?cache=guozy
     */
    @ResponseBody
    @RequestMapping("hello")
    public Object hello(String cache){
        log.info("hello:::" + cache);
        return ">>>>>>" + cache;
    }
}
