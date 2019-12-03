//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.xml.worldpayshengc;

import javax.xml.bind.annotation.*;


/**
 * @author 020102
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "order")
public class Order {
    /**
     * 您所指定的订单描述
     */
    @XmlElement(required = true)
    private String description;
    /**
     * 订单金额的信息
     */
    @XmlElement(required = true)
    private Amount amount;
    /**
     * 订单内容 内容要用 <![CDATA[]]>包裹
     */
    @XmlElement()
    private String orderContent;
    /**
     * 订单详情
     */
    @XmlElement(required = true)
    private PaymentDetails paymentDetails;
    /**
     * 购买者信息
     */
    @XmlElement(required = true)
    private Shopper shopper;
    /**
     * 风险数据,用来提升授权通过概率或3ds2验证时挑战成功率
     */
    @XmlElement()
    private RiskData riskData;
    /**
     * 3ds2的额外数据
     */
    @XmlElement()
    private AdditionalThreeDsData additional3DSData;
    /**
     * 订单号, 您所指定的订单代码。 理想情况下，后续流程不会超过 20 个
     */
    @XmlAttribute(name = "orderCode", required = true)
    private String orderCode;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    public RiskData getRiskData() {
        return riskData;
    }

    public void setRiskData(RiskData riskData) {
        this.riskData = riskData;
    }

    public AdditionalThreeDsData getAdditional3DSData() {
        return additional3DSData;
    }

    public void setAdditional3DSData(AdditionalThreeDsData additional3DSData) {
        this.additional3DSData = additional3DSData;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
