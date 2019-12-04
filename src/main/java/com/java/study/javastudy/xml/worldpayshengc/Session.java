package com.java.study.javastudy.xml.worldpayshengc;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * @author xuyuansheng
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "session")
public class Session {

    /**
     * 每笔交易需要一个唯一的值
     */
    @NotBlank(message = "订单详情 SessionId 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String id;
    /**
     * 客户的IP地址
     */
    @NotBlank(message = "订单详情 shopperIPAddress 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "shopperIPAddress")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    private String shopperIPAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopperIPAddress() {
        return shopperIPAddress;
    }

    public void setShopperIPAddress(String shopperIPAddress) {
        this.shopperIPAddress = shopperIPAddress;
    }
}
