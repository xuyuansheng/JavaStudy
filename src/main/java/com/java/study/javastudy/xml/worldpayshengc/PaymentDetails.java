//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.xml.worldpayshengc;

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
    @XmlElement(name = "CARD-SSL", required = true)
    private CardSsl cardssl;
    /**
     * 用户ip 和 id  (Session id must be unique)
     */
    @XmlElement(required = true)
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
