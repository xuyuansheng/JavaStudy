package com.java.study.javastudy.rmi.httpinvoke;

import org.springframework.stereotype.Service;

/**
 * @author Mr.Xu
 * @date 2020/3/14 22:39
 */
@Service
public class HttpInvokeServerImpl implements HttpInvokeServer {
    @Override
    public String get() {
        return "get";
    }
}
