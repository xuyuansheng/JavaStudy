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
@XmlRootElement(name = "paymentService")
public class PaymentService {
    /**
     * 提交的信息
     */
    @XmlElement()
    private Submit submit;
    /**
     * 商户代码
     */
    @XmlAttribute(name = "merchantCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String merchantCode;
    /**
     * 版本号
     */
    @XmlAttribute(name = "version")
    private String version;

    public Submit getSubmit() {
        return submit;
    }

    public void setSubmit(Submit submit) {
        this.submit = submit;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
