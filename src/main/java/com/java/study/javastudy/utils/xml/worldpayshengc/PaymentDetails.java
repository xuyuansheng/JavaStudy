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
@XmlRootElement(name = "paymentDetails")
public class PaymentDetails {
    /**
     * 信用卡号、借记卡号、用于支付的卡号、银行账户号码或任何其他适用的银行识别码。以 “4459510002561039” 作为示例
     */
    @Valid
    @NotNull(message = "订单详情 CardSsl 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlElement(name = "CARD-SSL" )
    private CardSsl cardssl;
    /**
     * 用户ip 和 id  (Session id must be unique)
     */
    @Valid
    @NotNull(message = "订单详情 Session 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlElement()
    private Session session;

    public CardSsl getCardssl() {
        return cardssl;
    }

    public void setCardssl(CardSsl cardssl) {
        this.cardssl = cardssl;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
