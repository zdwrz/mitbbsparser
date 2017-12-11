package com.aweiz.mitbbs.mitbbsparser.parser;

public class MitbbsChannel {
    private String displayName;
    private String name;
    private String url;

    public MitbbsChannel(String displayName, String name, String url) {
        this.displayName = displayName;
        this.name = name;
        this.url = url;
    }

    public MitbbsChannel() {
    }

    @Override
    public String toString() {
        return "MitbbsChannel{" +
                "displayName='" + displayName + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
