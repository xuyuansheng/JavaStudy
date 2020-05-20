package com.java.study.javastudy.utils.xml.worldpayshengc;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * @author xuyuansheng
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "amount")
public class Amount {

    /**
     * 详细说明相关国家的货币 (ISO 4217) 代码。 必须大写
     */
    @NotBlank(message = "货币代码 currencyCode 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "currencyCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String currencyCode;

    /**
     * 详细说明应在该值自右起放置小数点或逗号
     */
    @XmlAttribute(name = "exponent")
    private int exponent;
    /**
     * 详细说明买家有望支付的总金额。 最大值 2147483647
     */
    @DecimalMax(value = "2147483647",message = "支付的总金额不能超过范围", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @DecimalMin(value = "0",message = "支付的总金额不能超过范围", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "value")
    private int value;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
