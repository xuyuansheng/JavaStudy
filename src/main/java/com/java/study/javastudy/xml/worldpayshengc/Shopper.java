//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.xml.worldpayshengc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author xuyuansheng
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shopper")
public class Shopper {

    /**
     * 账单联系人电子邮件地址
     */
    @XmlElement(required = true)
    private String shopperEmailAddress;
    /**
     * 浏览器信息
     */
    @XmlElement()
    private Browser browser;

    public String getShopperEmailAddress() {
        return shopperEmailAddress;
    }

    public void setShopperEmailAddress(String shopperEmailAddress) {
        this.shopperEmailAddress = shopperEmailAddress;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }
}
