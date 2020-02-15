package com.java.study.javastudy.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Xu
 * @date 2020/2/15 17:52
 */
@Configuration
@EnableApolloConfig
public class StudyApolloConfig {

    /**
     * 这个没得必要,可以在其他Controller中直接注入
     */
    @ApolloConfig()
    private Config config;

    @Bean
    CustomConfigFromApollo customConfig() {
        return new CustomConfigFromApollo();
    }

}
