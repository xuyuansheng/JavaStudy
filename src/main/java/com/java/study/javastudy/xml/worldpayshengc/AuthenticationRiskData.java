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
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}authenticationTimestamp"/>
 *       &lt;/sequence>
 *       &lt;attribute name="authenticationMethod" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authenticationTimestamp"
})
@XmlRootElement(name = "authenticationRiskData")
public class AuthenticationRiskData {

    @XmlElement(required = true)
    protected AuthenticationTimestamp authenticationTimestamp;
    @XmlAttribute(name = "authenticationMethod", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String authenticationMethod;

    /**
     * ��ȡauthenticationTimestamp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationTimestamp }
     *     
     */
    public AuthenticationTimestamp getAuthenticationTimestamp() {
        return authenticationTimestamp;
    }

    /**
     * ����authenticationTimestamp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationTimestamp }
     *     
     */
    public void setAuthenticationTimestamp(AuthenticationTimestamp value) {
        this.authenticationTimestamp = value;
    }

    /**
     * ��ȡauthenticationMethod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    /**
     * ����authenticationMethod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticationMethod(String value) {
        this.authenticationMethod = value;
    }

}
