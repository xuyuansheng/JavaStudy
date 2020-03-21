package com.java.study.javastudy.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * @author Mr.Xu
 * @date 2020/3/14 22:36
 */
@Configuration
public class HttpInvokeConfig {

    @Bean("/httpInvokeTest")
    public HttpInvokerServiceExporter rpcService(HttpInvokeServer xxxService) {

        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();

        httpInvokerServiceExporter.setService(xxxService);
        httpInvokerServiceExporter.setServiceInterface(HttpInvokeServer.class);

        return httpInvokerServiceExporter;

    }
}
