package com.java.study.javastudy.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.BeansException;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Xu
 * @date 2020/2/15 17:52
 */
@Configuration
@EnableApolloConfig
public class StudyApolloConfig implements ApplicationContextAware {

    /**
     * 这个没得必要,可以在其他Controller中直接注入
     */
    @ApolloConfig()
    private Config config;

    @Bean
    CustomConfigFromApollo customConfig() {
        return new CustomConfigFromApollo();
    }


    @ApolloConfigChangeListener
    private void apolloConfigChangeListener(ConfigChangeEvent changeEvent) {
        for (String key : changeEvent.changedKeys()) {
            ConfigChange change = changeEvent.getChange(key);
            System.out.println(key + " 的值 从 " + change.getNewValue() + " 变为 :" + change.getNewValue());
        }
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
