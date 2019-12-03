//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.xml.worldpayshengc;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


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
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}amount"/>
 *         &lt;element ref="{}orderContent"/>
 *         &lt;element ref="{}paymentDetails"/>
 *         &lt;element ref="{}shopper"/>
 *         &lt;element ref="{}riskData"/>
 *         &lt;element ref="{}additional3DSData"/>
 *       &lt;/sequence>
 *       &lt;attribute name="orderCode" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "amount",
    "orderContent",
    "paymentDetails",
    "shopper",
    "riskData",
    "additional3DSData"
})
@XmlRootElement(name = "order")
public class Order {

    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected Amount amount;
    @XmlElement(required = true)
    protected OrderContent orderContent;
    @XmlElement(required = true)
    protected PaymentDetails paymentDetails;
    @XmlElement(required = true)
    protected Shopper shopper;
    @XmlElement(required = true)
    protected RiskData riskData;
    @XmlElement(required = true)
    protected Additional3DSData additional3DSData;
    @XmlAttribute(name = "orderCode", required = true)
    protected BigInteger orderCode;

    /**
     * ��ȡdescription���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * ����description���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * ��ȡamount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Amount }
     *     
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * ����amount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Amount }
     *     
     */
    public void setAmount(Amount value) {
        this.amount = value;
    }

    /**
     * ��ȡorderContent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OrderContent }
     *     
     */
    public OrderContent getOrderContent() {
        return orderContent;
    }

    /**
     * ����orderContent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OrderContent }
     *     
     */
    public void setOrderContent(OrderContent value) {
        this.orderContent = value;
    }

    /**
     * ��ȡpaymentDetails���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PaymentDetails }
     *     
     */
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * ����paymentDetails���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDetails }
     *     
     */
    public void setPaymentDetails(PaymentDetails value) {
        this.paymentDetails = value;
    }

    /**
     * ��ȡshopper���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Shopper }
     *     
     */
    public Shopper getShopper() {
        return shopper;
    }

    /**
     * ����shopper���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Shopper }
     *     
     */
    public void setShopper(Shopper value) {
        this.shopper = value;
    }

    /**
     * ��ȡriskData���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RiskData }
     *     
     */
    public RiskData getRiskData() {
        return riskData;
    }

    /**
     * ����riskData���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RiskData }
     *     
     */
    public void setRiskData(RiskData value) {
        this.riskData = value;
    }

    /**
     * ��ȡadditional3DSData���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Additional3DSData }
     *     
     */
    public Additional3DSData getAdditional3DSData() {
        return additional3DSData;
    }

    /**
     * ����additional3DSData���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Additional3DSData }
     *     
     */
    public void setAdditional3DSData(Additional3DSData value) {
        this.additional3DSData = value;
    }

    /**
     * ��ȡorderCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderCode() {
        return orderCode;
    }

    /**
     * ����orderCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderCode(BigInteger value) {
        this.orderCode = value;
    }

}
