package com.aweiz.mitbbs.mitbbsparser.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ChannelParser {

    @Value("${mitbbs.channel.list.url}")
    private String allChannelUrl;

    @Value("${mitbbs.base.url}")
    private String BASE_URL;

    public List<MitbbsChannel> getAllChannel(){
        List<MitbbsChannel> channelList = new ArrayList<>();

        Document doc = null;
        try {
            doc = Jsoup.connect(allChannelUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        doc.select("span[class='black4']").stream().forEach(e-> channelList.add(new MitbbsChannel(
                e.parent().nextElementSibling().nextElementSibling().text(),
                e.text(),
                BASE_URL + e.getElementsByTag("a").first().attr("href"))));
        return channelList;
    }
}
