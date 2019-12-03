//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.xml.worldpayshengc;

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
    @XmlAttribute(name = "currencyCode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String currencyCode;
    /**
     *
     */
    @XmlAttribute(name = "debitCreditIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String debitCreditIndicator;
    /**
     * 详细说明应在该值自右起放置小数点或逗号
     */
    @XmlAttribute(name = "exponent", required = true)
    private int exponent;
    /**
     * 详细说明买家有望支付的总金额。 最大值 2147483647
     */
    @XmlAttribute(name = "value", required = true)
    private int value;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDebitCreditIndicator() {
        return debitCreditIndicator;
    }

    public void setDebitCreditIndicator(String debitCreditIndicator) {
        this.debitCreditIndicator = debitCreditIndicator;
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
