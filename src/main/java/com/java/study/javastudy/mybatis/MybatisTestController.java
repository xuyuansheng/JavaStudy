package com.java.study.javastudy.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库测试Controller
 *
 * @author Mr.Xu
 * @date 2019/12/8 10:04
 */
@RestController
@RequestMapping("mybatis")
public class MybatisTestController {


    @Autowired
    private MyBatisService myBatisService;

    @Autowired
    private MyFirstMapper myFirstMapper;

    @Autowired
    private MySecondMapper mySecondMapper;

    @Autowired
    private MyThirdMapper myThirdMapper;

    @RequestMapping("getMaster")
    public Object getMaster() {
        Object select = myFirstMapper.select();
        return select;
    }


    @RequestMapping("getSlave")
    public Object getSlave() {

        Object select = mySecondMapper.select();
        return select;
    }

    @RequestMapping("get")
    public Object get() {

        Object select = myThirdMapper.select();
        return select;
    }

    @RequestMapping("getWithTransactional")
    @Transactional
    public Object getWithTransactional() {
        Object select = myFirstMapper.select();
        return select;
    }

    @RequestMapping("getService")
    public Object getService() {
        Object select = myBatisService.get();
        return select;
    }


}
