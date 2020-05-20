package com.java.study.javastudy.utils.xml;

import com.java.study.javastudy.utils.xml.worldpayshengc.PaymentService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @program: java-study
 * @description: xml
 * @author: Mr.Xu
 * @create: 2019/12/2 11:10
 */
public class XmlUtils {

    /**
     * https://beta.developer.worldpay.com/docs/wpg/directintegration/3ds/
     * http://developer-zh.worldpay.com/support/kb/gg/corporate-gateway-guide/content/directintegration/paymentrequests.htm
     */

    public static void main(String[] args) throws JAXBException, IOException {

        String path = "C:\\Users\\xuyuansheng\\Desktop\\worldpay\\initerror.xml";
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        PaymentService paymentService = xmlStringToObject(new String(bytes), PaymentService.class);
        System.out.println(paymentService);
        System.out.println(objectToXmlString(paymentService));

    }

    public static String objectToXmlString(PaymentService paymentService) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PaymentService.class);
        StringWriter writer = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(paymentService, writer);
        String xmlStr = writer.toString();
        return xmlStr;
    }

    public static <T> T xmlStringToObject(String xmlString, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new StringReader(xmlString));
        return (T) object;

    }


}
