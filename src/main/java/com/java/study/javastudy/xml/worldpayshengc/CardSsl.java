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
@XmlRootElement(name = "CARD-SSL")
public class CardSsl {
    /**
     * 信用卡号、借记卡号、用于支付的卡号、银行账户号码或任何其他适用的银行识别码。以 “4459510002561039” 作为示例
     */
    @XmlElement()
    private String cardNumber;
    /**
     * 这将返回卡的到期日期；但是，仅对于AUTHORIZED状态，并且仅当XML响应（和此元素）中的paymentMethodDetail启用时。与我们联系以启用这些功能
     */
    @XmlElement()
    private ExpiryDate expiryDate;
    /**
     * 卡或帐户上的帐户持有人姓名。 例如“ John Smith”
     */
    @XmlElement()
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    private String cardHolderName;
    /**
     * CVC是打印在信用卡后的额外代码
     * 备注: (worldPay技术微信上回复的解释)
     */
    @XmlElement()
    private String cvc;
    /**
     * 持卡人地址
     */
    @XmlElement()
    private CardAddress cardAddress;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(ExpiryDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public CardAddress getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(CardAddress cardAddress) {
        this.cardAddress = cardAddress;
    }
}
