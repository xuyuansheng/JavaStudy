package com.java.study.javastudy.xml.worldpayshengc;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @XmlElement()
    @NotBlank(message = "订单描述 Description 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    private String description;
    /**
     * 订单金额的信息
     */
    @Valid
    @NotNull(message = "订单金额的信息 Amount 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlElement()
    private Amount amount;
    /**
     * 订单内容 内容要用 <![CDATA[]]>包裹
     * 可选
     */
    @XmlElement()
    private String orderContent;
    /**
     * 订单详情
     */
    @Valid
    @NotNull(message = "订单详情 PaymentDetails 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlElement()
    private PaymentDetails paymentDetails;
    /**
     * 购买者信息
     * 可选
     */
    @XmlElement()
    private Shopper shopper;
    /**
     * 风险数据,用来提升授权通过概率或3ds2验证时挑战成功率
     */
    @XmlElement()
    private RiskData riskData;
    /**
     * 3ds2的额外数据
     */
    @Valid
    @NotNull(message = "3ds2的数据 AdditionalThreeDsData 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentDo3dsValidate.class})
    @XmlElement()
    private AdditionalThreeDsData additional3DSData;
    /**
     * 订单号, 您所指定的订单代码。 理想情况下，后续流程不会超过 20 个
     */
    @NotBlank(message = "订单号 orderCode 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "orderCode" )
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
