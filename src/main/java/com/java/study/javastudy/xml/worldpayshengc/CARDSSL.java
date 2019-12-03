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
 *         &lt;element ref="{}cardNumber"/>
 *         &lt;element ref="{}expiryDate"/>
 *         &lt;element ref="{}cardHolderName"/>
 *         &lt;element ref="{}cvc"/>
 *         &lt;element ref="{}cardAddress"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cardNumber",
    "expiryDate",
    "cardHolderName",
    "cvc",
    "cardAddress"
})
@XmlRootElement(name = "CARD-SSL")
public class CARDSSL {

    @XmlElement(required = true)
    protected BigInteger cardNumber;
    @XmlElement(required = true)
    protected ExpiryDate expiryDate;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String cardHolderName;
    @XmlElement(required = true)
    protected BigInteger cvc;
    @XmlElement(required = true)
    protected CardAddress cardAddress;

    /**
     * ��ȡcardNumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCardNumber() {
        return cardNumber;
    }

    /**
     * ����cardNumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCardNumber(BigInteger value) {
        this.cardNumber = value;
    }

    /**
     * ��ȡexpiryDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ExpiryDate }
     *     
     */
    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * ����expiryDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ExpiryDate }
     *     
     */
    public void setExpiryDate(ExpiryDate value) {
        this.expiryDate = value;
    }

    /**
     * ��ȡcardHolderName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * ����cardHolderName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardHolderName(String value) {
        this.cardHolderName = value;
    }

    /**
     * ��ȡcvc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCvc() {
        return cvc;
    }

    /**
     * ����cvc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCvc(BigInteger value) {
        this.cvc = value;
    }

    /**
     * ��ȡcardAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CardAddress }
     *     
     */
    public CardAddress getCardAddress() {
        return cardAddress;
    }

    /**
     * ����cardAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CardAddress }
     *     
     */
    public void setCardAddress(CardAddress value) {
        this.cardAddress = value;
    }

}
