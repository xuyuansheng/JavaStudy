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


/**
 * @author xuyuansheng
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "additional3DSData")
public class AdditionalThreeDsData {

    /**
     * 挑战策略
     * Possible Values:(可能的值)
     * noPreference (default) - You have no preference whether a challenge should be performed.(您没有偏好是否应执行挑战)
     * noChallengeRequested - You prefer that no challenge should be performed.(您希望不要执行任何挑战)
     * challengeRequested - You prefer that a challenge should be performed.(您希望应该执行挑战)
     * challengeMandated - There are local or regional mandates that mean that a challenge must be performed.(有地方或区域性授权要求必须执行挑战)
     */
    @XmlAttribute(name = "challengePreference")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
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
    @XmlAttribute(name = "challengeWindowSize")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    private String challengeWindowSize;
    /**
     * DDC完成后，在JavaScript postMessage中返回的SessionId
     * 即: https://secure-test.worldpay.com/shopper/3ds/ddc.html 接口返回的sessionId
     */
    @XmlAttribute(name = "dfReferenceId")
    @XmlSchemaType(name = "anySimpleType")
    private String dfReferenceId;

    public String getChallengePreference() {
        return challengePreference;
    }

    public void setChallengePreference(String challengePreference) {
        this.challengePreference = challengePreference;
    }

    public String getChallengeWindowSize() {
        return challengeWindowSize;
    }

    public void setChallengeWindowSize(String challengeWindowSize) {
        this.challengeWindowSize = challengeWindowSize;
    }

    public String getDfReferenceId() {
        return dfReferenceId;
    }

    public void setDfReferenceId(String dfReferenceId) {
        this.dfReferenceId = dfReferenceId;
    }
}
