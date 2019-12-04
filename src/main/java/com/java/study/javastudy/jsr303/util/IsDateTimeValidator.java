package com.java.study.javastudy.jsr303.util;

import com.java.study.javastudy.jsr303.util.IsDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 020102
 * @date 2019-08-07 14:251
 */
public class IsDateTimeValidator implements ConstraintValidator<IsDateTime, String> {

    private int dateOrTime;
    /**
     * 错误提示信息
     */
    private String message;
    /**
     * 格式化的模式
     */
    private String formatPattern;
    private boolean containDetail;

    /**
     * 初始化方法：通过该方法我们可以拿到我们的注解
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(IsDateTime constraintAnnotation) {
        //constraintAnnotation.required() 接收我们自定义的属性，是否为空
        formatPattern = constraintAnnotation.formatPattern();
        message = constraintAnnotation.message();
        dateOrTime = constraintAnnotation.dateOrTime();
        containDetail = constraintAnnotation.isContainDetail();
    }

    /**
     * 逻辑处理
     *
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.trim().length() == 0) {
            /* 值不能为空 */
            return false;
        } else {
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern(formatPattern);
                if (dateOrTime == 1) {
                    /* 表示为日期 */
                    LocalDate date = LocalDate.parse(value, format);
                } else if (dateOrTime == 2) {
                    /* 表示为时间 */
                    LocalTime time = LocalTime.parse(value, format);
                } else {
                    /* 表示为日期和时间 */
                    LocalDateTime dateTime = LocalDateTime.parse(value, format);
                }
            } catch (IllegalArgumentException e) {
                if (containDetail) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(message + " : " + e.getMessage()).addConstraintViolation();
                }
                return false;
            } catch (Exception e) {
                if (containDetail) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(message + " : " + e.getMessage()).addConstraintViolation();
                }
                return false;
            }
        }
        return true;
    }

}