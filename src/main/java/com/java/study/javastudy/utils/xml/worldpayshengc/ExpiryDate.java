package com.java.study.javastudy.utils.xml.worldpayshengc;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author xuyuansheng
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "expiryDate")
public class ExpiryDate {

    /**
     * 过期日期
     */
    @Valid
    @NotNull(message = "订单详情 ExpiryDate.Date 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlElement
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
