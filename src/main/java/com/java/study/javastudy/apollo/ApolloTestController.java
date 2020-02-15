package com.java.study.javastudy.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Xu
 * @date 2020/2/15 18:19
 */

@RestController
@RequestMapping("apolloTestController")
public class ApolloTestController {
    @ApolloConfig("myName")
    public Config apolloConfig;

    @Autowired
    public CustomConfigFromApollo customConfigFromApollo;

    @RequestMapping("testClient")
    public String testClient(String key, String application) {
        return ApolloClientUtils.get(key, application);
    }
    @RequestMapping("testSpringBoot")
    public String testSpringBoot(String key) {

       return apolloConfig.getProperty(key, key)+"\n"+customConfigFromApollo.getKey();
    }
}
