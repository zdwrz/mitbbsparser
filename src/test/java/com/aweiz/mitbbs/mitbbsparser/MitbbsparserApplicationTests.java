package com.aweiz.mitbbs.mitbbsparser;

import com.aweiz.mitbbs.mitbbsparser.parser.HTMLParser;
import com.aweiz.mitbbs.mitbbsparser.parser.MitbbsPage;
import com.aweiz.mitbbs.mitbbsparser.parser.MitbbsThread;
import com.aweiz.mitbbs.mitbbsparser.parser.XMLParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MitbbsparserApplicationTests {
	@Autowired
	HTMLParser parser;

	@Autowired
	XMLParser xmlParser;

	@Test
	public void test() {
		for (String s : HTMLParser.docMap.values()) {
			System.out.println(parser.parseURLForPage(s));
		}
	}

	@Test
	public void testCharset() throws Exception {
		xmlParser.getTop().stream().forEach(System.out::println);
	}
}
