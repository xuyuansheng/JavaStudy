package com.java.study.javastudy.jsr303.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义日期时间校验器1
 *
 * @author 020102
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IsDateTimeValidator.class})
public @interface IsDateTime {
    /**
     * 1:表示为日期格式(不包含时间) 如:yyyy-MM-dd ,
     * 2:表示为时间格式(不包含日期) 如:HH:mm:ss,HH:mm:ss:SSS ,
     * 其余都为日期和时间格式(包括日期和时间) 如:yyyy-MM-dd HH:mm:ss,yyyy-MM-dd HH:mm:ss:SSS
     */
    int dateOrTime() default 3;

    /**
     * 如果校验不通过返回的提示信息
     */
    String message() default "不是指定的日期格式";

    /**
     * 时间的格式化类型
     */
    String formatPattern() default "yyyy-MM-dd HH:mm:ss";

    /**
     * 返回的提示信息是否包含详细的错误信息
     */
    boolean isContainDetail() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}