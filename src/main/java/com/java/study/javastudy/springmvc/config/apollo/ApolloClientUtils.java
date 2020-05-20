package com.java.study.javastudy.springmvc.config.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Apollo客户端工具类
 *
 * @author Mr.Xu
 * @date 2020/2/15 17:40
 */
public class ApolloClientUtils {

    static Config appConfig = ConfigService.getAppConfig();
    static Map<String, Config> configMap = new HashMap<>();

    public static String get(String key, String application) {
        if (StringUtils.isBlank(application)) {
            return appConfig.getProperty(key, key);
        } else {
            Config config = configMap.get(application);
            config = Optional.ofNullable(config).orElse(
                 ConfigService.getConfig(application)
            );
            return config.getProperty(key, key);
        }
    }

    public static void main(String[] args) {
        String property = ApolloClientUtils.appConfig.getProperty("abc", "a");
        System.out.println(property);
    }


}
