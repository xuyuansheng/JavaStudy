package com.java.study.javastudy.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Xu
 * @date 2019/12/8 9:47
 */
@Mapper
@Component
public  interface MyThirdMapper {

    @Select("select * from t_book limit 1 ")
    List<Map> select();

}
