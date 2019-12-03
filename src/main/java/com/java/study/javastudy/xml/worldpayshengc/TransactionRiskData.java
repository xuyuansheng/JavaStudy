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
@XmlRootElement(name = "transactionRiskData")
public class TransactionRiskData {

    @XmlElement(required = true)
    private TransactionRiskDataGiftCardAmount transactionRiskDataGiftCardAmount;
    @XmlElement(required = true)
    private TransactionRiskDataPreOrderDate transactionRiskDataPreOrderDate;
    @XmlAttribute(name = "deliveryEmailAddress", required = true)
    @XmlSchemaType(name = "anySimpleType")
    private String deliveryEmailAddress;
    @XmlAttribute(name = "deliveryTimeframe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String deliveryTimeframe;
    @XmlAttribute(name = "giftCardCount", required = true)
    private int giftCardCount;
    @XmlAttribute(name = "preOrderPurchase", required = true)
    private boolean preOrderPurchase;
    @XmlAttribute(name = "reorderingPreviousPurchases", required = true)
    private boolean reorderingPreviousPurchases;
    @XmlAttribute(name = "shippingMethod", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String shippingMethod;

    public TransactionRiskDataGiftCardAmount getTransactionRiskDataGiftCardAmount() {
        return transactionRiskDataGiftCardAmount;
    }

    public void setTransactionRiskDataGiftCardAmount(TransactionRiskDataGiftCardAmount transactionRiskDataGiftCardAmount) {
        this.transactionRiskDataGiftCardAmount = transactionRiskDataGiftCardAmount;
    }

    public TransactionRiskDataPreOrderDate getTransactionRiskDataPreOrderDate() {
        return transactionRiskDataPreOrderDate;
    }

    public void setTransactionRiskDataPreOrderDate(TransactionRiskDataPreOrderDate transactionRiskDataPreOrderDate) {
        this.transactionRiskDataPreOrderDate = transactionRiskDataPreOrderDate;
    }

    public String getDeliveryEmailAddress() {
        return deliveryEmailAddress;
    }

    public void setDeliveryEmailAddress(String deliveryEmailAddress) {
        this.deliveryEmailAddress = deliveryEmailAddress;
    }

    public String getDeliveryTimeframe() {
        return deliveryTimeframe;
    }

    public void setDeliveryTimeframe(String deliveryTimeframe) {
        this.deliveryTimeframe = deliveryTimeframe;
    }

    public int getGiftCardCount() {
        return giftCardCount;
    }

    public void setGiftCardCount(int giftCardCount) {
        this.giftCardCount = giftCardCount;
    }

    public boolean isPreOrderPurchase() {
        return preOrderPurchase;
    }

    public void setPreOrderPurchase(boolean preOrderPurchase) {
        this.preOrderPurchase = preOrderPurchase;
    }

    public boolean isReorderingPreviousPurchases() {
        return reorderingPreviousPurchases;
    }

    public void setReorderingPreviousPurchases(boolean reorderingPreviousPurchases) {
        this.reorderingPreviousPurchases = reorderingPreviousPurchases;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
