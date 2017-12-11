package com.aweiz.mitbbs.mitbbsparser.controller;

import com.aweiz.mitbbs.mitbbsparser.parser.HTMLParser;
import com.aweiz.mitbbs.mitbbsparser.parser.MitbbsPage;
import com.aweiz.mitbbs.mitbbsparser.parser.MitbbsThread;
import com.aweiz.mitbbs.mitbbsparser.parser.XMLParser;
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
    @Autowired
    HTMLParser parser;

    @Autowired
    XMLParser xmlParser;

    @GetMapping("/page/{name}")
    public MitbbsPage getPage(@PathVariable String name) {
        return parser.parseNameForPage(name);
    }

    @GetMapping("/page")
    public Map<String, String> getPage() {
        return HTMLParser.docMap;
    }

    @GetMapping("/url")
    public MitbbsPage getPageByUrl(@RequestParam String addr) {
        return parser.parseURLForPage(addr);
    }

    @GetMapping("/top")
    public List<MitbbsThread> getTop() throws IOException, SAXException, ParserConfigurationException {
        return xmlParser.getTop();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> exceptionHandling(Exception e){
        Map<String, String> faultMap = new HashMap<>();
        faultMap.put("msg","Server Error");
        faultMap.put("exception",e.getLocalizedMessage());
        return faultMap;
    }
}
