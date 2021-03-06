package com.java.study.javastudy.utils.xml.worldpayshengc;

/**
 * 校验分组
 *
 * @author Mr.Xu
 * @date 2019/12/3 15:34
 */
public interface WorldPayParamsValidateGroups {
    /**
     * https://secure-test.worldpay.com/jsp/merchant/xml/paymentService.jsp
     * 接口参数校验
     */
    interface InitPaymentValidate {
    }
    /**
     * https://secure-test.worldpay.com/jsp/merchant/xml/paymentService.jsp
     * 接口参数校验 ,走地址校验
     */
    interface InitPaymentDoAddressValidate {
    }
    /**
     * https://secure-test.worldpay.com/jsp/merchant/xml/paymentService.jsp
     * 接口参数校验 ,走3ds流程时参数
     */
    interface InitPaymentDo3dsValidate {
    }
}

