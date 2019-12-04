package com.java.study.javastudy.xml.worldpayshengc;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * @author xuyuansheng
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "paymentService")
public class PaymentService {
    /**
     * 提交的信息
     */
    @Valid
    @NotNull(message = "提交的信息 Submit 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlElement()
    private Submit submit;
    /**
     * 商户代码
     */
    @NotBlank(message = "商户代码不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "merchantCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    private String merchantCode;
    /**
     * 版本号,默认为1.4
     */
    @NotBlank(message = "版本号 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "version")
    private String version = "1.4";

    public Submit getSubmit() {
        return submit;
    }

    public void setSubmit(Submit submit) {
        this.submit = submit;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
