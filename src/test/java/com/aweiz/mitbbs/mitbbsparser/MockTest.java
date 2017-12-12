package com.aweiz.mitbbs.mitbbsparser;

import com.aweiz.mitbbs.mitbbsparser.parser.HTMLParser;
import com.aweiz.mitbbs.mitbbsparser.parser.thread.MitbbsThreadDetail;
import org.junit.Test;

public class MockTest {


    @Test
    public void testThreadParser1() {
        HTMLParser parser = new HTMLParser();
        MitbbsThreadDetail d = parser.getThreadDetail("http://www.mitbbs.com/article_t/Stock/37130681.html");
        System.out.println(d);

    }

    @Test
    public void testThreadParser10() {
        HTMLParser parser = new HTMLParser();
        MitbbsThreadDetail d = parser.getThreadDetail("http://www.mitbbs.com/article_t/Stock/37086811.html");
        System.out.println(d);

    }

}
