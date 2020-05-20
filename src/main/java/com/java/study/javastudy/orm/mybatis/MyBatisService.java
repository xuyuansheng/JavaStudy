package com.java.study.javastudy.orm.mybatis;

import com.github.xuyuansheng.xbdynamicdatasource.dynamic.annotation.DynamicDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Xu
 * @date 2019/12/22 9:12
 */
@Service
public class MyBatisService {

    @Autowired
    private MyFirstMapper myFirstMapper;

    @Autowired
    private MySecondMapper mySecondMapper;

    @Transactional
    @DynamicDS("slave")
    public Object get() {
        List<Map> second = mySecondMapper.select();

//        List<Map> first = myFirstMapper.select();
//
//        boolean all = second.addAll(first);

        return second;
    }

}
