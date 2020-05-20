//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.utils.xml.worldpayshengc;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigInteger;


/**
 * @author xuyuansheng
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shopperAccountRiskData")
public class ShopperAccountRiskData {

    @XmlElement()
    private ShopperAccountCreationDate shopperAccountCreationDate;
    @XmlElement()
    private ShopperAccountModificationDate shopperAccountModificationDate;
    @XmlElement()
    private ShopperAccountPasswordChangeDate shopperAccountPasswordChangeDate;
    @XmlElement()
    private ShopperAccountShippingAddressFirstUseDate shopperAccountShippingAddressFirstUseDate;
    @XmlElement()
    private ShopperAccountPaymentAccountFirstUseDate shopperAccountPaymentAccountFirstUseDate;
    @XmlAttribute(name = "addCardAttemptsLastDay")
    private BigInteger addCardAttemptsLastDay;
    @XmlAttribute(name = "previousSuspiciousActivity")
    private boolean previousSuspiciousActivity;
    @XmlAttribute(name = "purchasesCompletedLastSixMonths")
    private BigInteger purchasesCompletedLastSixMonths;
    @XmlAttribute(name = "shippingNameMatchesAccountName")
    private boolean shippingNameMatchesAccountName;
    @XmlAttribute(name = "shopperAccountAgeIndicator")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String shopperAccountAgeIndicator;
    @XmlAttribute(name = "shopperAccountChangeIndicator")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String shopperAccountChangeIndicator;
    @XmlAttribute(name = "shopperAccountPasswordChangeIndicator")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String shopperAccountPasswordChangeIndicator;
    @XmlAttribute(name = "shopperAccountPaymentAccountIndicator")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String shopperAccountPaymentAccountIndicator;
    @XmlAttribute(name = "shopperAccountShippingAddressUsageIndicator")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String shopperAccountShippingAddressUsageIndicator;
    @XmlAttribute(name = "transactionsAttemptedLastDay")
    private BigInteger transactionsAttemptedLastDay;
    @XmlAttribute(name = "transactionsAttemptedLastYear")
    private BigInteger transactionsAttemptedLastYear;

    public ShopperAccountCreationDate getShopperAccountCreationDate() {
        return shopperAccountCreationDate;
    }

    public void setShopperAccountCreationDate(ShopperAccountCreationDate shopperAccountCreationDate) {
        this.shopperAccountCreationDate = shopperAccountCreationDate;
    }

    public ShopperAccountModificationDate getShopperAccountModificationDate() {
        return shopperAccountModificationDate;
    }

    public void setShopperAccountModificationDate(ShopperAccountModificationDate shopperAccountModificationDate) {
        this.shopperAccountModificationDate = shopperAccountModificationDate;
    }

    public ShopperAccountPasswordChangeDate getShopperAccountPasswordChangeDate() {
        return shopperAccountPasswordChangeDate;
    }

    public void setShopperAccountPasswordChangeDate(ShopperAccountPasswordChangeDate shopperAccountPasswordChangeDate) {
        this.shopperAccountPasswordChangeDate = shopperAccountPasswordChangeDate;
    }

    public ShopperAccountShippingAddressFirstUseDate getShopperAccountShippingAddressFirstUseDate() {
        return shopperAccountShippingAddressFirstUseDate;
    }

    public void setShopperAccountShippingAddressFirstUseDate(ShopperAccountShippingAddressFirstUseDate shopperAccountShippingAddressFirstUseDate) {
        this.shopperAccountShippingAddressFirstUseDate = shopperAccountShippingAddressFirstUseDate;
    }

    public ShopperAccountPaymentAccountFirstUseDate getShopperAccountPaymentAccountFirstUseDate() {
        return shopperAccountPaymentAccountFirstUseDate;
    }

    public void setShopperAccountPaymentAccountFirstUseDate(ShopperAccountPaymentAccountFirstUseDate shopperAccountPaymentAccountFirstUseDate) {
        this.shopperAccountPaymentAccountFirstUseDate = shopperAccountPaymentAccountFirstUseDate;
    }

    public BigInteger getAddCardAttemptsLastDay() {
        return addCardAttemptsLastDay;
    }

    public void setAddCardAttemptsLastDay(BigInteger addCardAttemptsLastDay) {
        this.addCardAttemptsLastDay = addCardAttemptsLastDay;
    }

    public boolean isPreviousSuspiciousActivity() {
        return previousSuspiciousActivity;
    }

    public void setPreviousSuspiciousActivity(boolean previousSuspiciousActivity) {
        this.previousSuspiciousActivity = previousSuspiciousActivity;
    }

    public BigInteger getPurchasesCompletedLastSixMonths() {
        return purchasesCompletedLastSixMonths;
    }

    public void setPurchasesCompletedLastSixMonths(BigInteger purchasesCompletedLastSixMonths) {
        this.purchasesCompletedLastSixMonths = purchasesCompletedLastSixMonths;
    }

    public boolean isShippingNameMatchesAccountName() {
        return shippingNameMatchesAccountName;
    }

    public void setShippingNameMatchesAccountName(boolean shippingNameMatchesAccountName) {
        this.shippingNameMatchesAccountName = shippingNameMatchesAccountName;
    }

    public String getShopperAccountAgeIndicator() {
        return shopperAccountAgeIndicator;
    }

    public void setShopperAccountAgeIndicator(String shopperAccountAgeIndicator) {
        this.shopperAccountAgeIndicator = shopperAccountAgeIndicator;
    }

    public String getShopperAccountChangeIndicator() {
        return shopperAccountChangeIndicator;
    }

    public void setShopperAccountChangeIndicator(String shopperAccountChangeIndicator) {
        this.shopperAccountChangeIndicator = shopperAccountChangeIndicator;
    }

    public String getShopperAccountPasswordChangeIndicator() {
        return shopperAccountPasswordChangeIndicator;
    }

    public void setShopperAccountPasswordChangeIndicator(String shopperAccountPasswordChangeIndicator) {
        this.shopperAccountPasswordChangeIndicator = shopperAccountPasswordChangeIndicator;
    }

    public String getShopperAccountPaymentAccountIndicator() {
        return shopperAccountPaymentAccountIndicator;
    }

    public void setShopperAccountPaymentAccountIndicator(String shopperAccountPaymentAccountIndicator) {
        this.shopperAccountPaymentAccountIndicator = shopperAccountPaymentAccountIndicator;
    }

    public String getShopperAccountShippingAddressUsageIndicator() {
        return shopperAccountShippingAddressUsageIndicator;
    }

    public void setShopperAccountShippingAddressUsageIndicator(String shopperAccountShippingAddressUsageIndicator) {
        this.shopperAccountShippingAddressUsageIndicator = shopperAccountShippingAddressUsageIndicator;
    }

    public BigInteger getTransactionsAttemptedLastDay() {
        return transactionsAttemptedLastDay;
    }

    public void setTransactionsAttemptedLastDay(BigInteger transactionsAttemptedLastDay) {
        this.transactionsAttemptedLastDay = transactionsAttemptedLastDay;
    }

    public BigInteger getTransactionsAttemptedLastYear() {
        return transactionsAttemptedLastYear;
    }

    public void setTransactionsAttemptedLastYear(BigInteger transactionsAttemptedLastYear) {
        this.transactionsAttemptedLastYear = transactionsAttemptedLastYear;
    }
}
