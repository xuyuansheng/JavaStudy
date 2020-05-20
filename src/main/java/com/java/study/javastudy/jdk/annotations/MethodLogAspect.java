package com.java.study.javastudy.jdk.annotations;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
@Aspect
public class MethodLogAspect {
//com.java.study.javastudy.jdk.annotations.MethodLogAspect

    private final ObjectMapper mapper;

    @Autowired
    public MethodLogAspect(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Pointcut(value = "execution(public * com.*.*(..))")
    public void recordLog() {
    }

    @Pointcut("@annotation(com.java.study.javastudy.jdk.annotations.MyMethodLog)")
    private void cut() {
    }

    /**
     * 定制一个环绕通知
     *
     * @param joinPoint
     */
    @Around("cut()")
    public Object advice(ProceedingJoinPoint joinPoint) {
        try {
            StringBuffer param = new StringBuffer();
            for (Object object : joinPoint.getArgs()) {
                if (
                        object instanceof MultipartFile
                                || object instanceof HttpServletRequest
                                || object instanceof HttpServletResponse) {
                    continue;
                }
                param.append(mapper.writeValueAsString(object))
                        .append(",");
            }
            System.out.println(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()
                    + ":【parameter】: " + param.toString() );
//            log.info(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()
//                    + ":【parameter】: " + param.toString() );
            final Object proceed = joinPoint.proceed();
//            log.info("【RETURN】"+proceed);
            System.out.println("【RETURN】"+proceed);
            return proceed;
        } catch (Throwable e) {
            return new RuntimeException("日志打印出错");
        }
    }

    @Before("cut()")
    public void before() {
//        log.info("已经记录下操作日志@Before 方法执行前");
        System.out.println("已经记录下操作日志@Before 方法执行前");
    }



    @After(value = "recordLog()")
    public void after() {
//        log.info("已经记录下操作日志@After 方法执行后");
        System.out.println("已经记录下操作日志@After 方法执行后");
    }

}
