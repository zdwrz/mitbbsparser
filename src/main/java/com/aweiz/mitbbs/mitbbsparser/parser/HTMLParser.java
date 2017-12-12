package com.aweiz.mitbbs.mitbbsparser.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HTMLParser {
    @Value("${mitbbs.base.url}")
    private String BASE_URL;

    @Autowired
    private ChannelParser channelParser;

    public static Map<String, String> docMap = new HashMap<>();

    @PostConstruct
    public void init(){
        List<MitbbsChannel> channels = channelParser.getAllChannel();
        for (MitbbsChannel channel : channels) {
            docMap.put(channel.getName(), channel.getUrl());
        }
    }

    public MitbbsPage parseURLForPage(String url) {
        MitbbsPage page = new MitbbsPage();
        List<MitbbsThread> threads = new ArrayList<>(100);
        page.setThreadList(threads);
        page.setUrl(url);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        page.setTitle(doc.title());

        if(doc.getElementsMatchingOwnText("上页").first()!=null){
            if(!doc.getElementsMatchingOwnText("上页").first().attr("href").isEmpty()) {
                page.setPrevUrl(BASE_URL + doc.getElementsMatchingOwnText("上页").first().attr("href"));
            }
        }

        if(doc.getElementsMatchingOwnText("下页").first()!=null){
            page.setNextUrl(BASE_URL+doc.getElementsMatchingOwnText("下页").first().attr("href"));
        }

        Elements e = doc.getElementsByClass("top-bg");    //The Header of the table

        Elements next = e.nextAll("tr");   //All thread TR
        for (Element n : next) {
            Element linkA = n.select("a[class='news1']").first();//Get the first a tag which is the link
            MitbbsThread newThread = new MitbbsThread();
            newThread.setTitle(linkA.text());
            newThread.setUrl(BASE_URL + linkA.attr("href"));
            threads.add(newThread);

            Elements linkAs = n.select("a[class='news']");      //Get rest of the a tag which are author and updater
            if(linkAs.size() > 0) {
                Element auth = linkAs.get(0);
                newThread.setCreatedBy(auth.text());
                newThread.setTimeCreated(auth.parent().getElementsByTag("span").first().text()); // time created span
                if (linkAs.size() == 2) {//have updater
                    Element updater = linkAs.get(1);
                    newThread.setUpdatedBy(updater.text());
                    newThread.setTimeUpdated(updater.parent().getElementsByTag("span").first().text()); // time updated span
                }
            }
            Elements fcs = n.getElementsContainingOwnText("/");
            if(fcs.size() > 1){
                newThread.setFc(fcs.get(1).text());
            }else if(fcs.size() > 0 && fcs.first() != null){
                newThread.setFc(fcs.get(0).text());
            }
            newThread.setIndex(n.getElementsByTag("td").first().text());
        }
        return page;
    }

    public MitbbsPage parseNameForPage(String name) {
        String url = docMap.get(name);
        if (url == null) {
            throw new RuntimeException("The name cannot be mapped to url");
        }
        return this.parseURLForPage(url);
    }
}