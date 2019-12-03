//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.xml.worldpayshengc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import java.math.BigInteger;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.common package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AcceptHeader_QNAME = new QName("", "acceptHeader");
    private final static QName _Address3_QNAME = new QName("", "address3");
    private final static QName _Address2_QNAME = new QName("", "address2");
    private final static QName _City_QNAME = new QName("", "city");
    private final static QName _CardHolderName_QNAME = new QName("", "cardHolderName");
    private final static QName _Address1_QNAME = new QName("", "address1");
    private final static QName _UserAgentHeader_QNAME = new QName("", "userAgentHeader");
    private final static QName _PostalCode_QNAME = new QName("", "postalCode");
    private final static QName _Description_QNAME = new QName("", "description");
    private final static QName _ShopperEmailAddress_QNAME = new QName("", "shopperEmailAddress");
    private final static QName _Dddd_QNAME = new QName("", "dddd");
    private final static QName _Cvc_QNAME = new QName("", "cvc");
    private final static QName _CountryCode_QNAME = new QName("", "countryCode");
    private final static QName _CardNumber_QNAME = new QName("", "cardNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CardAddress }
     * 
     */
    public CardAddress createCardAddress() {
        return new CardAddress();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link AuthenticationTimestamp }
     * 
     */
    public AuthenticationTimestamp createAuthenticationTimestamp() {
        return new AuthenticationTimestamp();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link TransactionRiskData }
     * 
     */
    public TransactionRiskData createTransactionRiskData() {
        return new TransactionRiskData();
    }

    /**
     * Create an instance of {@link TransactionRiskDataGiftCardAmount }
     * 
     */
    public TransactionRiskDataGiftCardAmount createTransactionRiskDataGiftCardAmount() {
        return new TransactionRiskDataGiftCardAmount();
    }

    /**
     * Create an instance of {@link Amount }
     * 
     */
    public Amount createAmount() {
        return new Amount();
    }

    /**
     * Create an instance of {@link TransactionRiskDataPreOrderDate }
     * 
     */
    public TransactionRiskDataPreOrderDate createTransactionRiskDataPreOrderDate() {
        return new TransactionRiskDataPreOrderDate();
    }

    /**
     * Create an instance of {@link ShopperAccountShippingAddressFirstUseDate }
     * 
     */
    public ShopperAccountShippingAddressFirstUseDate createShopperAccountShippingAddressFirstUseDate() {
        return new ShopperAccountShippingAddressFirstUseDate();
    }

    /**
     * Create an instance of {@link Submit }
     * 
     */
    public Submit createSubmit() {
        return new Submit();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link OrderContent }
     * 
     */
    public OrderContent createOrderContent() {
        return new OrderContent();
    }

    /**
     * Create an instance of {@link PaymentDetails }
     * 
     */
    public PaymentDetails createPaymentDetails() {
        return new PaymentDetails();
    }

    /**
     * Create an instance of {@link CARDSSL }
     * 
     */
    public CARDSSL createCARDSSL() {
        return new CARDSSL();
    }

    /**
     * Create an instance of {@link ExpiryDate }
     * 
     */
    public ExpiryDate createExpiryDate() {
        return new ExpiryDate();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link Shopper }
     * 
     */
    public Shopper createShopper() {
        return new Shopper();
    }

    /**
     * Create an instance of {@link Browser }
     * 
     */
    public Browser createBrowser() {
        return new Browser();
    }

    /**
     * Create an instance of {@link RiskData }
     * 
     */
    public RiskData createRiskData() {
        return new RiskData();
    }

    /**
     * Create an instance of {@link AuthenticationRiskData }
     * 
     */
    public AuthenticationRiskData createAuthenticationRiskData() {
        return new AuthenticationRiskData();
    }

    /**
     * Create an instance of {@link ShopperAccountRiskData }
     * 
     */
    public ShopperAccountRiskData createShopperAccountRiskData() {
        return new ShopperAccountRiskData();
    }

    /**
     * Create an instance of {@link ShopperAccountCreationDate }
     * 
     */
    public ShopperAccountCreationDate createShopperAccountCreationDate() {
        return new ShopperAccountCreationDate();
    }

    /**
     * Create an instance of {@link ShopperAccountModificationDate }
     * 
     */
    public ShopperAccountModificationDate createShopperAccountModificationDate() {
        return new ShopperAccountModificationDate();
    }

    /**
     * Create an instance of {@link ShopperAccountPasswordChangeDate }
     * 
     */
    public ShopperAccountPasswordChangeDate createShopperAccountPasswordChangeDate() {
        return new ShopperAccountPasswordChangeDate();
    }

    /**
     * Create an instance of {@link ShopperAccountPaymentAccountFirstUseDate }
     * 
     */
    public ShopperAccountPaymentAccountFirstUseDate createShopperAccountPaymentAccountFirstUseDate() {
        return new ShopperAccountPaymentAccountFirstUseDate();
    }

    /**
     * Create an instance of {@link Additional3DSData }
     * 
     */
    public Additional3DSData createAdditional3DSData() {
        return new Additional3DSData();
    }

    /**
     * Create an instance of {@link PaymentService }
     * 
     */
    public PaymentService createPaymentService() {
        return new PaymentService();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "acceptHeader")
    public JAXBElement<String> createAcceptHeader(String value) {
        return new JAXBElement<String>(_AcceptHeader_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "address3")
    public JAXBElement<String> createAddress3(String value) {
        return new JAXBElement<String>(_Address3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "address2")
    public JAXBElement<String> createAddress2(String value) {
        return new JAXBElement<String>(_Address2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "city")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCity(String value) {
        return new JAXBElement<String>(_City_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cardHolderName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCardHolderName(String value) {
        return new JAXBElement<String>(_CardHolderName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "address1")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createAddress1(String value) {
        return new JAXBElement<String>(_Address1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "userAgentHeader")
    public JAXBElement<String> createUserAgentHeader(String value) {
        return new JAXBElement<String>(_UserAgentHeader_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "postalCode")
    public JAXBElement<String> createPostalCode(String value) {
        return new JAXBElement<String>(_PostalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "shopperEmailAddress")
    public JAXBElement<String> createShopperEmailAddress(String value) {
        return new JAXBElement<String>(_ShopperEmailAddress_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "dddd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createDddd(String value) {
        return new JAXBElement<String>(_Dddd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cvc")
    public JAXBElement<BigInteger> createCvc(BigInteger value) {
        return new JAXBElement<BigInteger>(_Cvc_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "countryCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCountryCode(String value) {
        return new JAXBElement<String>(_CountryCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cardNumber")
    public JAXBElement<BigInteger> createCardNumber(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardNumber_QNAME, BigInteger.class, null, value);
    }

}
