package com.java.study.javastudy.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate config
 *
 * @author Mr.Xu
 * @date 2020/2/27 9:37
 */
@Configuration
public class RestTemplateConfig {


    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {

        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(1000);
        factory.setReadTimeout(1000);

        return factory;
    }

}
