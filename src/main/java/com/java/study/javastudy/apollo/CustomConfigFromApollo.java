package com.java.study.javastudy.apollo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置
 *
 * @author Mr.Xu
 * @date 2020/2/15 19:27
 */
@Configuration
@ConfigurationProperties(prefix = "prefix")
@Data
public class CustomConfigFromApollo {

    private String key;

}
