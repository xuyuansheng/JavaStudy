//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.02 ʱ�� 05:29:39 PM GMT+08:00 
//


package com.java.study.javastudy.xml.worldpayshengc;

import javax.xml.bind.annotation.*;
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
 *       &lt;attribute name="dayOfMonth" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="hour" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="minute" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="month" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="second" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="year" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "date")
public class Date {

    @XmlAttribute(name = "dayOfMonth")
    protected BigInteger dayOfMonth;
    @XmlAttribute(name = "hour")
    protected BigInteger hour;
    @XmlAttribute(name = "minute")
    protected BigInteger minute;
    @XmlAttribute(name = "month", required = true)
    protected BigInteger month;
    @XmlAttribute(name = "second")
    protected BigInteger second;
    @XmlAttribute(name = "year", required = true)
    protected BigInteger year;

    /**
     * ��ȡdayOfMonth���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * ����dayOfMonth���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDayOfMonth(BigInteger value) {
        this.dayOfMonth = value;
    }

    /**
     * ��ȡhour���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHour() {
        return hour;
    }

    /**
     * ����hour���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHour(BigInteger value) {
        this.hour = value;
    }

    /**
     * ��ȡminute���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinute() {
        return minute;
    }

    /**
     * ����minute���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinute(BigInteger value) {
        this.minute = value;
    }

    /**
     * ��ȡmonth���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMonth() {
        return month;
    }

    /**
     * ����month���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMonth(BigInteger value) {
        this.month = value;
    }

    /**
     * ��ȡsecond���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSecond() {
        return second;
    }

    /**
     * ����second���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSecond(BigInteger value) {
        this.second = value;
    }

    /**
     * ��ȡyear���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYear() {
        return year;
    }

    /**
     * ����year���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYear(BigInteger value) {
        this.year = value;
    }

}
