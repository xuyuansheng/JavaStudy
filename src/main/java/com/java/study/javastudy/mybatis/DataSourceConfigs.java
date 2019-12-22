package com.java.study.javastudy.mybatis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 数据库配置类
 *
 * @author Mr.Xu
 * @date 2019/12/8 10:44
 */
@Configuration
public class DataSourceConfigs {


    @Bean(name = "master")
    @ConfigurationProperties(prefix = "master.spring.datasource")
    public DataSource getDataSource1() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        return builder.build();
    }

    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "slave.spring.datasource")
    public DataSource getDataSource2() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        return builder.build();
    }
}
