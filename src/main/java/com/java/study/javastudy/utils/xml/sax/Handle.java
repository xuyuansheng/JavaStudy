package com.java.study.javastudy.utils.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Mr.Xu
 * @date 2020/12/29 15:17
 */
public class Handle extends DefaultHandler2 {
    /*  EntityResolver, DTDHandler, ContentHandler, ErrorHandler */
    /*  LexicalHandler, DeclHandler, EntityResolver2 */
    public static void main(String[] args) throws Exception {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        Handle handle = new Handle();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setErrorHandler(handle);
        xmlReader.setContentHandler(handle);
        xmlReader.setDTDHandler(handle);
        xmlReader.setEntityResolver(handle);
        Path path = Paths.get("D:\\JavaWorkSpace\\JavaStudy\\src\\main\\java\\com\\java\\study\\javastudy\\utils\\xml\\sax\\servers.xml");
        InputSource inputSource = new InputSource(path.toUri().toURL().toString());
//        xmlReader.parse(inputSource);
        saxParser.parse(inputSource, new Handle());
        System.out.println("end ");

    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String s = "";
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            s = s.concat(name + " = ").concat(attributes.getValue(i)).concat(" ");
        }
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        super.characters(ch, start, length);
    }
}