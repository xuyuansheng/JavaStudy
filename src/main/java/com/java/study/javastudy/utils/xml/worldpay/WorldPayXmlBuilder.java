package com.java.study.javastudy.utils.xml.worldpay;

import com.java.study.javastudy.utils.xml.worldpayshengc.*;

import java.util.UUID;

/**
 * @program: java-study
 * @description:
 * @author: Mr.Xu
 * @create: 2019/12/2 14:01
 */
public class WorldPayXmlBuilder {

    public PaymentService buildPaymentService(ParamsObject paramsObject) {
        PaymentService paymentService = new PaymentService();
        paymentService.setMerchantCode(paramsObject.getMerchantCode());
        paymentService.setVersion(paramsObject.getVersion());
        paymentService.setSubmit(buildSubmit(paramsObject));
        return paymentService;
    }

    private Submit buildSubmit(ParamsObject paramsObject) {
        Submit submit = new Submit();
        submit.setOrder(buildOrder(paramsObject));
        return submit;
    }

    private Order buildOrder(ParamsObject paramsObject) {
        Order order = new Order();
        order.setAmount(buildAmount(paramsObject));
        order.setPaymentDetails(buildPaymentDetails(paramsObject));
        order.setAdditional3DSData(buildAdditional3DSData(paramsObject));
        order.setShopper(buildShopper(paramsObject));
        order.setRiskData(buildRiskData(paramsObject));
        /*  ----------------------------------------------------- */
        order.setOrderCode(paramsObject.getOrderCode());
        order.setDescription(paramsObject.getDescription());
        order.setOrderContent(paramsObject.getOrderContent());
        return order;
    }

    private Shopper buildShopper(ParamsObject paramsObject) {
        Shopper shopper = new Shopper();
        Browser browser = new Browser();
        browser.setAcceptHeader(paramsObject.getAcceptHeader());
        browser.setUserAgentHeader(paramsObject.getUserAgentHeader());
        shopper.setBrowser(browser);
        shopper.setShopperEmailAddress(paramsObject.getShopperEmailAddress());
        return shopper;
    }

    private AdditionalThreeDsData buildAdditional3DSData(ParamsObject paramsObject) {
        AdditionalThreeDsData additionalThreeDsData = new AdditionalThreeDsData();
        additionalThreeDsData.setChallengePreference(paramsObject.getChallengePreference());
        additionalThreeDsData.setChallengeWindowSize(paramsObject.getChallengeWindowSize());
        additionalThreeDsData.setDfReferenceId(paramsObject.getDfReferenceId());
        return additionalThreeDsData;
    }

    /**
     * 未完成
     *
     * @param paramsObject
     * @return
     */
    private RiskData buildRiskData(ParamsObject paramsObject) {
        RiskData riskData = new RiskData();
        riskData.setAuthenticationRiskData(new AuthenticationRiskData());
        riskData.setShopperAccountRiskData(new ShopperAccountRiskData());
        riskData.setTransactionRiskData(new TransactionRiskData());
        return riskData;
    }

    private PaymentDetails buildPaymentDetails(ParamsObject paramsObject) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setSession(buildSession(paramsObject));
        paymentDetails.setCardssl(buildCardssl(paramsObject));
        return paymentDetails;
    }

    private CardSsl buildCardssl(ParamsObject paramsObject) {
        CardSsl cardSsl = new CardSsl();
        cardSsl.setCardAddress(buildCardAddress(paramsObject));
        cardSsl.setCardHolderName(paramsObject.getCardHolderName());
        cardSsl.setCardNumber(paramsObject.getCardNumber());
        cardSsl.setCvc(paramsObject.getCvc());
        cardSsl.setExpiryDate(buildExpiryDate(paramsObject));
        return cardSsl;
    }

    private ExpiryDate buildExpiryDate(ParamsObject paramsObject) {
        ExpiryDate expiryDate = new ExpiryDate();
        expiryDate.setDate(buildDate(paramsObject));
        return expiryDate;
    }

    private Date buildDate(ParamsObject paramsObject) {
        return new Date(paramsObject.getYear(), paramsObject.getMonth(), paramsObject.getHour(), paramsObject.getMinute(), paramsObject.getSecond(), paramsObject.getDayOfMonth());
    }

    private CardAddress buildCardAddress(ParamsObject paramsObject) {
        CardAddress cardAddress = new CardAddress();
        Address address = new Address();
        address.setAddress1(paramsObject.getAddress1());
        address.setAddress2(paramsObject.getAddress2());
        address.setAddress3(paramsObject.getAddress3());
        address.setCity(paramsObject.getCity());
        address.setCountryCode(paramsObject.getCountryCode());
        address.setPostalCode(paramsObject.getPostalCode());
        cardAddress.setAddress(address);
        return cardAddress;
    }

    private Session buildSession(ParamsObject paramsObject) {
        Session session = new Session();
        session.setId(UUID.randomUUID().toString());
        session.setShopperIPAddress(paramsObject.getShopperIPAddress());
        return session;
    }

    private Amount buildAmount(ParamsObject paramsObject) {
        Amount amount = new Amount();
        amount.setCurrencyCode(paramsObject.getCurrencyCode());
        amount.setExponent(paramsObject.getExponent());
        amount.setValue(paramsObject.getValue());
        return amount;
    }


}
