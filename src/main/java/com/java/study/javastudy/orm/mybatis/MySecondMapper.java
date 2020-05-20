package com.java.study.javastudy.orm.mybatis;

import com.github.xuyuansheng.xbdynamicdatasource.dynamic.annotation.DynamicDS;
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
@DynamicDS("slave")
public interface MySecondMapper {
    @Select("select * from t_book limit 1 ")
    List<Map> select();

}
