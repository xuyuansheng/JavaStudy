//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.xml.worldpayshengc;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}authenticationRiskData"/>
 *         &lt;element ref="{}shopperAccountRiskData"/>
 *         &lt;element ref="{}transactionRiskData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authenticationRiskData",
    "shopperAccountRiskData",
    "transactionRiskData"
})
@XmlRootElement(name = "riskData")
public class RiskData {

    @XmlElement(required = true)
    protected AuthenticationRiskData authenticationRiskData;
    @XmlElement(required = true)
    protected ShopperAccountRiskData shopperAccountRiskData;
    @XmlElement(required = true)
    protected TransactionRiskData transactionRiskData;

    /**
     * ��ȡauthenticationRiskData���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationRiskData }
     *     
     */
    public AuthenticationRiskData getAuthenticationRiskData() {
        return authenticationRiskData;
    }

    /**
     * ����authenticationRiskData���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationRiskData }
     *     
     */
    public void setAuthenticationRiskData(AuthenticationRiskData value) {
        this.authenticationRiskData = value;
    }

    /**
     * ��ȡshopperAccountRiskData���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ShopperAccountRiskData }
     *     
     */
    public ShopperAccountRiskData getShopperAccountRiskData() {
        return shopperAccountRiskData;
    }

    /**
     * ����shopperAccountRiskData���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ShopperAccountRiskData }
     *     
     */
    public void setShopperAccountRiskData(ShopperAccountRiskData value) {
        this.shopperAccountRiskData = value;
    }

    /**
     * ��ȡtransactionRiskData���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionRiskData }
     *     
     */
    public TransactionRiskData getTransactionRiskData() {
        return transactionRiskData;
    }

    /**
     * ����transactionRiskData���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionRiskData }
     *     
     */
    public void setTransactionRiskData(TransactionRiskData value) {
        this.transactionRiskData = value;
    }

}
