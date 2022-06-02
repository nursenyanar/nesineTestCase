package com.nesine;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {
    String FILE_NAME = "C:\\Users\\nurse\\OneDrive\\Masaüstü\\nesine\\pom.xml";

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public XMLParser() {
        getProperty();
    }

    private void getProperty() {
        File pomXml = new File(FILE_NAME);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(pomXml);
            doc.getDocumentElement().normalize();

            Element properties = (Element) doc.getElementsByTagName("properties").item(0);

            Element usernameElement = (Element) properties.getElementsByTagName("username").item(0);
            username = usernameElement.getTextContent();

            Element passwordElement = (Element) properties.getElementsByTagName("password").item(0);
            password = passwordElement.getTextContent();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
