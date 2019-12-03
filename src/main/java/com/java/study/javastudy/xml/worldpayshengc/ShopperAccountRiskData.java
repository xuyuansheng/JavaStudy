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
 *         &lt;element ref="{}shopperAccountCreationDate"/>
 *         &lt;element ref="{}shopperAccountModificationDate"/>
 *         &lt;element ref="{}shopperAccountPasswordChangeDate"/>
 *         &lt;element ref="{}shopperAccountShippingAddressFirstUseDate"/>
 *         &lt;element ref="{}shopperAccountPaymentAccountFirstUseDate"/>
 *       &lt;/sequence>
 *       &lt;attribute name="addCardAttemptsLastDay" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="previousSuspiciousActivity" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="purchasesCompletedLastSixMonths" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="shippingNameMatchesAccountName" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="shopperAccountAgeIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="shopperAccountChangeIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="shopperAccountPasswordChangeIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="shopperAccountPaymentAccountIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="shopperAccountShippingAddressUsageIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="transactionsAttemptedLastDay" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="transactionsAttemptedLastYear" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "shopperAccountCreationDate",
    "shopperAccountModificationDate",
    "shopperAccountPasswordChangeDate",
    "shopperAccountShippingAddressFirstUseDate",
    "shopperAccountPaymentAccountFirstUseDate"
})
@XmlRootElement(name = "shopperAccountRiskData")
public class ShopperAccountRiskData {

    @XmlElement(required = true)
    protected ShopperAccountCreationDate shopperAccountCreationDate;
    @XmlElement(required = true)
    protected ShopperAccountModificationDate shopperAccountModificationDate;
    @XmlElement(required = true)
    protected ShopperAccountPasswordChangeDate shopperAccountPasswordChangeDate;
    @XmlElement(required = true)
    protected ShopperAccountShippingAddressFirstUseDate shopperAccountShippingAddressFirstUseDate;
    @XmlElement(required = true)
    protected ShopperAccountPaymentAccountFirstUseDate shopperAccountPaymentAccountFirstUseDate;
    @XmlAttribute(name = "addCardAttemptsLastDay", required = true)
    protected BigInteger addCardAttemptsLastDay;
    @XmlAttribute(name = "previousSuspiciousActivity", required = true)
    protected boolean previousSuspiciousActivity;
    @XmlAttribute(name = "purchasesCompletedLastSixMonths", required = true)
    protected BigInteger purchasesCompletedLastSixMonths;
    @XmlAttribute(name = "shippingNameMatchesAccountName", required = true)
    protected boolean shippingNameMatchesAccountName;
    @XmlAttribute(name = "shopperAccountAgeIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shopperAccountAgeIndicator;
    @XmlAttribute(name = "shopperAccountChangeIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shopperAccountChangeIndicator;
    @XmlAttribute(name = "shopperAccountPasswordChangeIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shopperAccountPasswordChangeIndicator;
    @XmlAttribute(name = "shopperAccountPaymentAccountIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shopperAccountPaymentAccountIndicator;
    @XmlAttribute(name = "shopperAccountShippingAddressUsageIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shopperAccountShippingAddressUsageIndicator;
    @XmlAttribute(name = "transactionsAttemptedLastDay", required = true)
    protected BigInteger transactionsAttemptedLastDay;
    @XmlAttribute(name = "transactionsAttemptedLastYear", required = true)
    protected BigInteger transactionsAttemptedLastYear;

    /**
     * ��ȡshopperAccountCreationDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ShopperAccountCreationDate }
     *     
     */
    public ShopperAccountCreationDate getShopperAccountCreationDate() {
        return shopperAccountCreationDate;
    }

    /**
     * ����shopperAccountCreationDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ShopperAccountCreationDate }
     *     
     */
    public void setShopperAccountCreationDate(ShopperAccountCreationDate value) {
        this.shopperAccountCreationDate = value;
    }

    /**
     * ��ȡshopperAccountModificationDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ShopperAccountModificationDate }
     *     
     */
    public ShopperAccountModificationDate getShopperAccountModificationDate() {
        return shopperAccountModificationDate;
    }

    /**
     * ����shopperAccountModificationDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ShopperAccountModificationDate }
     *     
     */
    public void setShopperAccountModificationDate(ShopperAccountModificationDate value) {
        this.shopperAccountModificationDate = value;
    }

    /**
     * ��ȡshopperAccountPasswordChangeDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ShopperAccountPasswordChangeDate }
     *     
     */
    public ShopperAccountPasswordChangeDate getShopperAccountPasswordChangeDate() {
        return shopperAccountPasswordChangeDate;
    }

    /**
     * ����shopperAccountPasswordChangeDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ShopperAccountPasswordChangeDate }
     *     
     */
    public void setShopperAccountPasswordChangeDate(ShopperAccountPasswordChangeDate value) {
        this.shopperAccountPasswordChangeDate = value;
    }

    /**
     * ��ȡshopperAccountShippingAddressFirstUseDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ShopperAccountShippingAddressFirstUseDate }
     *     
     */
    public ShopperAccountShippingAddressFirstUseDate getShopperAccountShippingAddressFirstUseDate() {
        return shopperAccountShippingAddressFirstUseDate;
    }

    /**
     * ����shopperAccountShippingAddressFirstUseDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ShopperAccountShippingAddressFirstUseDate }
     *     
     */
    public void setShopperAccountShippingAddressFirstUseDate(ShopperAccountShippingAddressFirstUseDate value) {
        this.shopperAccountShippingAddressFirstUseDate = value;
    }

    /**
     * ��ȡshopperAccountPaymentAccountFirstUseDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ShopperAccountPaymentAccountFirstUseDate }
     *     
     */
    public ShopperAccountPaymentAccountFirstUseDate getShopperAccountPaymentAccountFirstUseDate() {
        return shopperAccountPaymentAccountFirstUseDate;
    }

    /**
     * ����shopperAccountPaymentAccountFirstUseDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ShopperAccountPaymentAccountFirstUseDate }
     *     
     */
    public void setShopperAccountPaymentAccountFirstUseDate(ShopperAccountPaymentAccountFirstUseDate value) {
        this.shopperAccountPaymentAccountFirstUseDate = value;
    }

    /**
     * ��ȡaddCardAttemptsLastDay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddCardAttemptsLastDay() {
        return addCardAttemptsLastDay;
    }

    /**
     * ����addCardAttemptsLastDay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddCardAttemptsLastDay(BigInteger value) {
        this.addCardAttemptsLastDay = value;
    }

    /**
     * ��ȡpreviousSuspiciousActivity���Ե�ֵ��
     * 
     */
    public boolean isPreviousSuspiciousActivity() {
        return previousSuspiciousActivity;
    }

    /**
     * ����previousSuspiciousActivity���Ե�ֵ��
     * 
     */
    public void setPreviousSuspiciousActivity(boolean value) {
        this.previousSuspiciousActivity = value;
    }

    /**
     * ��ȡpurchasesCompletedLastSixMonths���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPurchasesCompletedLastSixMonths() {
        return purchasesCompletedLastSixMonths;
    }

    /**
     * ����purchasesCompletedLastSixMonths���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPurchasesCompletedLastSixMonths(BigInteger value) {
        this.purchasesCompletedLastSixMonths = value;
    }

    /**
     * ��ȡshippingNameMatchesAccountName���Ե�ֵ��
     * 
     */
    public boolean isShippingNameMatchesAccountName() {
        return shippingNameMatchesAccountName;
    }

    /**
     * ����shippingNameMatchesAccountName���Ե�ֵ��
     * 
     */
    public void setShippingNameMatchesAccountName(boolean value) {
        this.shippingNameMatchesAccountName = value;
    }

    /**
     * ��ȡshopperAccountAgeIndicator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopperAccountAgeIndicator() {
        return shopperAccountAgeIndicator;
    }

    /**
     * ����shopperAccountAgeIndicator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopperAccountAgeIndicator(String value) {
        this.shopperAccountAgeIndicator = value;
    }

    /**
     * ��ȡshopperAccountChangeIndicator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopperAccountChangeIndicator() {
        return shopperAccountChangeIndicator;
    }

    /**
     * ����shopperAccountChangeIndicator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopperAccountChangeIndicator(String value) {
        this.shopperAccountChangeIndicator = value;
    }

    /**
     * ��ȡshopperAccountPasswordChangeIndicator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopperAccountPasswordChangeIndicator() {
        return shopperAccountPasswordChangeIndicator;
    }

    /**
     * ����shopperAccountPasswordChangeIndicator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopperAccountPasswordChangeIndicator(String value) {
        this.shopperAccountPasswordChangeIndicator = value;
    }

    /**
     * ��ȡshopperAccountPaymentAccountIndicator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopperAccountPaymentAccountIndicator() {
        return shopperAccountPaymentAccountIndicator;
    }

    /**
     * ����shopperAccountPaymentAccountIndicator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopperAccountPaymentAccountIndicator(String value) {
        this.shopperAccountPaymentAccountIndicator = value;
    }

    /**
     * ��ȡshopperAccountShippingAddressUsageIndicator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopperAccountShippingAddressUsageIndicator() {
        return shopperAccountShippingAddressUsageIndicator;
    }

    /**
     * ����shopperAccountShippingAddressUsageIndicator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopperAccountShippingAddressUsageIndicator(String value) {
        this.shopperAccountShippingAddressUsageIndicator = value;
    }

    /**
     * ��ȡtransactionsAttemptedLastDay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTransactionsAttemptedLastDay() {
        return transactionsAttemptedLastDay;
    }

    /**
     * ����transactionsAttemptedLastDay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTransactionsAttemptedLastDay(BigInteger value) {
        this.transactionsAttemptedLastDay = value;
    }

    /**
     * ��ȡtransactionsAttemptedLastYear���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTransactionsAttemptedLastYear() {
        return transactionsAttemptedLastYear;
    }

    /**
     * ����transactionsAttemptedLastYear���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTransactionsAttemptedLastYear(BigInteger value) {
        this.transactionsAttemptedLastYear = value;
    }

}
