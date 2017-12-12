package com.aweiz.mitbbs.mitbbsparser.controller;

import com.aweiz.mitbbs.mitbbsparser.parser.*;
import com.aweiz.mitbbs.mitbbsparser.parser.thread.MitbbsThread;
import com.aweiz.mitbbs.mitbbsparser.parser.thread.MitbbsThreadDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mitbbs")
public class MitbbsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MitbbsController.class);

    @Autowired
    HTMLParser parser;

    @Autowired
    XMLParser xmlParser;

    @Autowired
    ChannelParser channelParser;


    @GetMapping("/channel")
    public List<MitbbsChannel> getChannelRank(){
        return channelParser.getAllChannel();
    }

    @GetMapping("/channel/{name}")
    public MitbbsPage getPage(@PathVariable String name) {
        return parser.parseNameForPage(name);
    }

    @GetMapping("/channel/url")
    public MitbbsPage getPageByUrl(@RequestParam String addr) {
        return parser.parseURLForPage(addr);
    }

    @GetMapping("/channel/refresh")
    public Map<String,String> refreshChannelRank(){
        Map<String, String> result = new HashMap<>();
        parser.init();
        return parser.getDocMap();
    }

    @GetMapping("/top")
    public List<MitbbsThread> getTopThread() throws IOException, SAXException, ParserConfigurationException {
        return xmlParser.getTop();
    }

    @GetMapping("/thread")
    public MitbbsThreadDetail getThreadByUrl(@RequestParam String addr) {
        return parser.getThreadDetail(addr);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> exceptionHandling(Exception e){
        Map<String, String> faultMap = new HashMap<>();
        faultMap.put("msg","Server Error");
        faultMap.put("exception",e.getMessage());
        LOGGER.error("error",e);
        return faultMap;
    }
}
