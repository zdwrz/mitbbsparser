package com.aweiz.mitbbs.mitbbsparser.parser;

import com.aweiz.mitbbs.mitbbsparser.parser.thread.MitbbsThread;

import java.util.List;

public class MitbbsPage {
    private String title;
    private String url;
    private String prevUrl;
    private String nextUrl;
    private List<MitbbsThread> threadList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrevUrl() {
        return prevUrl;
    }

    public void setPrevUrl(String prevUrl) {
        this.prevUrl = prevUrl;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public List<MitbbsThread> getThreadList() {
        return threadList;
    }

    public void setThreadList(List<MitbbsThread> threadList) {
        this.threadList = threadList;
    }

    @Override
    public String toString() {
        return "MitbbsPage{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", prevUrl='" + prevUrl + '\'' +
                ", nextUrl='" + nextUrl + '\'' +
                ", threadList=" + threadList +
                '}';
    }
}
