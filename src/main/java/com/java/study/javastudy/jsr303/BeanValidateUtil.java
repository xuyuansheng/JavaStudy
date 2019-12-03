package com.java.study.javastudy.jsr303;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 实体校验工具类
 *
 * @param <T>
 * @author 020102
 */
public final class BeanValidateUtil<T> {
    /**
     * @param defaultValueBean 参数默认值,如果不需要默认值时,请使用另一个构造(T defaultValueBean, boolean ifDefaultValueEnabled)
     */
    public BeanValidateUtil(T defaultValueBean) {
        if (Objects.isNull(defaultValueBean)) {
            throw new IllegalArgumentException("需要校验的类型不能为 null");
        }
        this.defaultValueBean = defaultValueBean;
    }

    /**
     * @param defaultValueBean      参数默认值,如果不需要默认值时,ifDefaultValueEnabled=false即可
     * @param ifDefaultValueEnabled true: 启用默认值 ,false: 不启用默认值对象
     */
    public BeanValidateUtil(T defaultValueBean, boolean ifDefaultValueEnabled) {
        if (Objects.isNull(defaultValueBean)) {
            throw new IllegalArgumentException("需要校验的类型不能为 null , 如果不需要默认值,请设置 ifDefaultValueEnabled = false");
        }
        this.defaultValueBean = defaultValueBean;
        this.ifDefaultValueEnabled = ifDefaultValueEnabled;
    }

    private T defaultValueBean;
    /**
     * 第一次校验失败时,是否使用defaultValueBean中的字段重新给校验不通过的字段重新赋值,然后重新校验
     */
    private boolean ifDefaultValueEnabled = true;

    /**
     * 校验
     *
     * @param bean   需要校验的bean
     * @param groups 分组
     * @return 校验不通过, 则返回不符合条件的字段, 通过则返回null
     */
    public String validate(T bean, Class<?>... groups) {
        // 校验null
        if (Objects.isNull(bean)) {
            return getNullValidateResultList();
        }

        // 获取验证器工厂
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // 获取验证器
        Validator validator = validatorFactory.getValidator();
        // 执行验证
        Set<ConstraintViolation<T>> validateSet = validator.validate(bean, groups);

        if (validateSet.size() == 0 || !ifDefaultValueEnabled) {
            return getValidateResultList(validateSet);
        }

        List<String> allFields = getAllFields(bean.getClass()).stream().map(Field::getName).collect(Collectors.toList());
        allFields.removeAll(validateSet.stream().map(cn -> cn.getPropertyPath().toString()).collect(Collectors.toList()));
        String[] ignore = allFields.toArray(new String[0]);
        BeanUtils.copyProperties(defaultValueBean, bean, ignore);
        return getValidateResultList(validator.validate(bean, groups));
    }

    /**
     * 获取所有的字段.包括public,private,protected,和父类的
     *
     * @param clazz 目标类的class
     * @return 返回所有的字段
     */
    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = Stream.of(clazz.getDeclaredFields()).collect(Collectors.toList());
        if (clazz.getSuperclass() != null) {
            List<Field> superFields = getAllFields(clazz.getSuperclass());
            fields.addAll(superFields);
        }
        return fields;
    }

    /**
     * 获取结果
     *
     * @param validateSet 不符合的字段
     * @return 为null表示验证通过, 否则返回未通过的字段结果
     */
    private String getValidateResultList(Set<ConstraintViolation<T>> validateSet) {
        if (CollectionUtils.isNotEmpty(validateSet)) {
            List<BeanValidateResult> validateResult = validateSet.stream().map(BeanValidateUtil::convertToBeanValidateResult).collect(Collectors.toList());
            return JSON.toJSONString(validateResult);
        }
        return null;
    }

    /**
     * 转换类型
     *
     * @param validate 校验的结果
     * @return 转换后的结果
     */
    private static BeanValidateResult convertToBeanValidateResult(ConstraintViolation validate) {
        BeanValidateResult validateResult = new BeanValidateResult();
        validateResult.setFieldName(validate.getPropertyPath().toString());
        validateResult.setMessage(validate.getMessage());
        return validateResult;
    }

    /**
     * 获取bean为null时的校验结果
     *
     * @return
     */
    private String getNullValidateResultList() {
        List<BeanValidateResult> validateResultList = new ArrayList<>();
        BeanValidateResult validateResult = new BeanValidateResult();
        validateResult.setFieldName("validateBean");
        validateResult.setMessage("bean is null");
        validateResultList.add(validateResult);
        return JSON.toJSONString(validateResultList);
    }

    /**
     * 内部类,用来存储结果
     */
    @Data
    static class BeanValidateResult {

        private String fieldName;

        private String message;

    }

}


