package com.java.study.javastudy.utils.xml.worldpayshengc;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author xuyuansheng
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "date")
public class Date {

    @XmlAttribute(name = "dayOfMonth")
    private Integer dayOfMonth;

    @XmlAttribute(name = "hour")
    private Integer hour;

    @XmlAttribute(name = "minute")
    private Integer minute;

    @NotNull(message = "订单详情 ExpiryDate.month 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "month", required = true)
    private Integer month;

    @XmlAttribute(name = "second")
    private Integer second;

    @NotNull(message = "订单详情 ExpiryDate.year 不能为 null", groups = {WorldPayParamsValidateGroups.InitPaymentValidate.class})
    @XmlAttribute(name = "year", required = true)
    private Integer year;

    public Date(Integer year, Integer month, Integer hour, Integer minute, Integer second, Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.minute = minute;
        this.month = month;
        this.second = second;
        this.year = year;
    }

    public Date() {
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
