package com.aweiz.mitbbs.mitbbsparser;

import com.aweiz.mitbbs.mitbbsparser.parser.*;
import com.aweiz.mitbbs.mitbbsparser.parser.thread.MitbbsThreadDetail;
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
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MitbbsparserApplicationTests {
	@Autowired
	HTMLParser parser;

	@Autowired
	XMLParser xmlParser;

	@Autowired
	ChannelParser channelParser;

	@Test
	public void test() {
		for (String s : parser.getDocMap().values()) {
			System.out.println(parser.parseURLForPage(s));
		}
	}

	@Test
	public void testCharset() throws Exception {
		xmlParser.getTop().stream().forEach(System.out::println);
	}

	@Test
	public void testChannelParser(){
		List<MitbbsChannel> result = channelParser.getAllChannel();
		result.stream().forEach(i-> System.out.println(i));
	}

}
