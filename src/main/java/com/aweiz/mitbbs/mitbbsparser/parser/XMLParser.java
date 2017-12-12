package com.aweiz.mitbbs.mitbbsparser.parser;

import com.aweiz.mitbbs.mitbbsparser.parser.thread.MitbbsThread;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class XMLParser {

    @Value("${mitbbs.top.url}")
    private String topUrl;

    public List<MitbbsThread> getTop() throws ParserConfigurationException, IOException, SAXException {
        List<MitbbsThread> tops = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        HttpURLConnection myURLConnection = (HttpURLConnection)new URL(topUrl).openConnection();
        myURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        Document doc = db.parse(myURLConnection.getInputStream());
        doc.getDocumentElement().normalize();
        NodeList items = doc.getElementsByTagName("item");
        for(int i = 0 ; i < items.getLength();i++) {
            if(items.item(i).getNodeType() == Node.ELEMENT_NODE) {
                MitbbsThread newThread = new MitbbsThread();
                Element element = (Element)items.item(i);
                newThread.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                newThread.setUrl(element.getElementsByTagName("link").item(0).getTextContent());
                newThread.setCreatedBy(element.getElementsByTagName("dc:creator").item(0).getTextContent());
                newThread.setTimeCreated(element.getElementsByTagName("dc:date").item(0).getTextContent());
                newThread.setIndex(i+1+"");
                tops.add(newThread);
            }
        }
        return tops;
    }

}
