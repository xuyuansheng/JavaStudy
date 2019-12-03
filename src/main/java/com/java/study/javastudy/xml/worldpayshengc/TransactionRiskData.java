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
 *         &lt;element ref="{}transactionRiskDataGiftCardAmount"/>
 *         &lt;element ref="{}transactionRiskDataPreOrderDate"/>
 *       &lt;/sequence>
 *       &lt;attribute name="deliveryEmailAddress" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="deliveryTimeframe" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="giftCardCount" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="preOrderPurchase" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="reorderingPreviousPurchases" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="shippingMethod" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transactionRiskDataGiftCardAmount",
    "transactionRiskDataPreOrderDate"
})
@XmlRootElement(name = "transactionRiskData")
public class TransactionRiskData {

    @XmlElement(required = true)
    protected TransactionRiskDataGiftCardAmount transactionRiskDataGiftCardAmount;
    @XmlElement(required = true)
    protected TransactionRiskDataPreOrderDate transactionRiskDataPreOrderDate;
    @XmlAttribute(name = "deliveryEmailAddress", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String deliveryEmailAddress;
    @XmlAttribute(name = "deliveryTimeframe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String deliveryTimeframe;
    @XmlAttribute(name = "giftCardCount", required = true)
    protected BigInteger giftCardCount;
    @XmlAttribute(name = "preOrderPurchase", required = true)
    protected boolean preOrderPurchase;
    @XmlAttribute(name = "reorderingPreviousPurchases", required = true)
    protected boolean reorderingPreviousPurchases;
    @XmlAttribute(name = "shippingMethod", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shippingMethod;

    /**
     * ��ȡtransactionRiskDataGiftCardAmount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionRiskDataGiftCardAmount }
     *     
     */
    public TransactionRiskDataGiftCardAmount getTransactionRiskDataGiftCardAmount() {
        return transactionRiskDataGiftCardAmount;
    }

    /**
     * ����transactionRiskDataGiftCardAmount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionRiskDataGiftCardAmount }
     *     
     */
    public void setTransactionRiskDataGiftCardAmount(TransactionRiskDataGiftCardAmount value) {
        this.transactionRiskDataGiftCardAmount = value;
    }

    /**
     * ��ȡtransactionRiskDataPreOrderDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionRiskDataPreOrderDate }
     *     
     */
    public TransactionRiskDataPreOrderDate getTransactionRiskDataPreOrderDate() {
        return transactionRiskDataPreOrderDate;
    }

    /**
     * ����transactionRiskDataPreOrderDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionRiskDataPreOrderDate }
     *     
     */
    public void setTransactionRiskDataPreOrderDate(TransactionRiskDataPreOrderDate value) {
        this.transactionRiskDataPreOrderDate = value;
    }

    /**
     * ��ȡdeliveryEmailAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryEmailAddress() {
        return deliveryEmailAddress;
    }

    /**
     * ����deliveryEmailAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryEmailAddress(String value) {
        this.deliveryEmailAddress = value;
    }

    /**
     * ��ȡdeliveryTimeframe���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryTimeframe() {
        return deliveryTimeframe;
    }

    /**
     * ����deliveryTimeframe���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryTimeframe(String value) {
        this.deliveryTimeframe = value;
    }

    /**
     * ��ȡgiftCardCount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGiftCardCount() {
        return giftCardCount;
    }

    /**
     * ����giftCardCount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGiftCardCount(BigInteger value) {
        this.giftCardCount = value;
    }

    /**
     * ��ȡpreOrderPurchase���Ե�ֵ��
     * 
     */
    public boolean isPreOrderPurchase() {
        return preOrderPurchase;
    }

    /**
     * ����preOrderPurchase���Ե�ֵ��
     * 
     */
    public void setPreOrderPurchase(boolean value) {
        this.preOrderPurchase = value;
    }

    /**
     * ��ȡreorderingPreviousPurchases���Ե�ֵ��
     * 
     */
    public boolean isReorderingPreviousPurchases() {
        return reorderingPreviousPurchases;
    }

    /**
     * ����reorderingPreviousPurchases���Ե�ֵ��
     * 
     */
    public void setReorderingPreviousPurchases(boolean value) {
        this.reorderingPreviousPurchases = value;
    }

    /**
     * ��ȡshippingMethod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingMethod() {
        return shippingMethod;
    }

    /**
     * ����shippingMethod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingMethod(String value) {
        this.shippingMethod = value;
    }

}
