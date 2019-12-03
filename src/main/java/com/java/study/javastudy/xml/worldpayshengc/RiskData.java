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
@XmlRootElement(name = "riskData")
public class RiskData {
    /**
     * 有关购物者以及他们如何通过Worldpay进行身份验证的信息
     */
    @XmlElement()
    private AuthenticationRiskData authenticationRiskData;
    /**
     * 有关您的购物者帐户的信息
     */
    @XmlElement()
    private ShopperAccountRiskData shopperAccountRiskData;
    /**
     * 有关订单的信息。
     */
    @XmlElement()
    private TransactionRiskData transactionRiskData;

    public AuthenticationRiskData getAuthenticationRiskData() {
        return authenticationRiskData;
    }

    public void setAuthenticationRiskData(AuthenticationRiskData authenticationRiskData) {
        this.authenticationRiskData = authenticationRiskData;
    }

    public ShopperAccountRiskData getShopperAccountRiskData() {
        return shopperAccountRiskData;
    }

    public void setShopperAccountRiskData(ShopperAccountRiskData shopperAccountRiskData) {
        this.shopperAccountRiskData = shopperAccountRiskData;
    }

    public TransactionRiskData getTransactionRiskData() {
        return transactionRiskData;
    }

    public void setTransactionRiskData(TransactionRiskData transactionRiskData) {
        this.transactionRiskData = transactionRiskData;
    }
}
