package com.java.study.javastudy.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyuansheng
 */
@RestController
@RequestMapping("SimpleController")
@Slf4j
public class SimpleController {

    @RequestMapping("testLog")
    public String testLog() {
        log.warn("warn");
        log.debug("debug");
        log.info("info");
        log.error("error");
        log.trace("trace");
        return "success";
    }


}
