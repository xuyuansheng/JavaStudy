package com.java.study.javastudy.utils.xml.worldpayshengc;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author 020102
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "submit")
public class Submit {
    /**
     * 订单信息
     */
    @Valid
    @NotNull(message = "订单信息 Order 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlElement
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
