package com.java.study.javastudy.utils.xml.worldpay;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 参数对象
 *
 * @author Mr.Xu
 * @date 2019/12/3 13:03
 */
@Data
public class ParamsObject {

    /**
     * 商户代码
     */
    @NotBlank
    private String merchantCode = "SPAUSD";
    /**
     * 版本号
     */
    @NotBlank
    private String version = "1.4";

    /**
     * 您所指定的订单描述
     */
    @NotBlank
    private String description;

    /**
     * 订单内容 内容要用 <![CDATA[]]>包裹
     * 可以null
     */
    private String orderContent;

    /**
     * 订单号, 您所指定的订单代码。 理想情况下，后续流程不会超过 20 个
     */
    @NotBlank
    private String orderCode;


    /**
     * 账单联系人电子邮件地址
     */
    private String shopperEmailAddress;
    /**
     * 必须包含与购物者的用户代理发送给您的HTTP用户头完全相同的内容
     */
    private String acceptHeader;
    /**
     * 必须包含与购物者的用户代理发送给您的HTTP用户代理头完全相同的内容
     */
    private String userAgentHeader;

    /**
     * 详细说明相关国家的货币 (ISO 4217) 代码。 必须大写
     */
    private String currencyCode;

    /**
     * 详细说明应在该值自右起放置小数点或逗号
     */
    private Integer exponent;
    /**
     * 详细说明买家有望支付的总金额。 最大值 2147483647
     */
    private Integer value;

    /**
     * 挑战策略
     * Possible Values:(可能的值)
     * noPreference (default) - You have no preference whether a challenge should be performed.(您没有偏好是否应执行挑战)
     * noChallengeRequested - You prefer that no challenge should be performed.(您希望不要执行任何挑战)
     * challengeRequested - You prefer that a challenge should be performed.(您希望应该执行挑战)
     * challengeMandated - There are local or regional mandates that mean that a challenge must be performed.(有地方或区域性授权要求必须执行挑战)
     */
    private String challengePreference;
    /**
     * 发起3ds2挑战的窗口大小
     * Challenge Window size the issuer should use to display the challenge.(发行人用来显示挑战的挑战窗口大小。可能的值：)
     * Possible Values:(可能的值)
     * fullPage
     * 250x400
     * 390x400 (default)
     * 500x600
     * 600x400
     */
    private String challengeWindowSize;
    /**
     * DDC完成后，在JavaScript postMessage中返回的SessionId
     * 即: https://secure-test.worldpay.com/shopper/3ds/ddc.html 接口返回的sessionId
     */
    private String dfReferenceId;
    /**
     * 客户的IP地址
     */
    private String shopperIPAddress;
    /**
     * 信用卡号、借记卡号、用于支付的卡号、银行账户号码或任何其他适用的银行识别码。以 “4459510002561039” 作为示例
     */
    private String cardNumber;

    /**
     * 卡或帐户上的帐户持有人姓名。 例如“ John Smith”
     */

    private String cardHolderName;
    /**
     * CVC是打印在信用卡后的额外代码
     * 备注: (worldPay技术微信上回复的解释)
     */
    private String cvc;
    /**
     * 帐单联系人地址行1。 除非提供<city>，否则为可选。
     */
    private String address1;
    /**
     * 帐单联系人地址行2 可选
     */
    private String address2;
    /**
     * 帐单联系人地址行2 可选
     */
    private String address3;
    /**
     * 帐单联系人邮政编码/邮政编码。 例如“ CB4 0WE”
     */
    private String postalCode;
    /**
     * 联系人城市。 除非提供了<address1>，否则为可选。
     */

    private String city;
    /**
     * 帐单联系ISO国家/地区代码。必须是大写 有关详细信息，请参见ISO国家/地区代码
     */
    private String countryCode;

    private Integer dayOfMonth;
    private Integer hour;
    private Integer minute;
    private Integer month;
    private Integer second;
    private Integer year;
}
