package com.aweiz.mitbbs.mitbbsparser.parser.thread;

public class MitbbsPost {
    private String author;
    private String time;

    private String content;

    public String getAuthor() {
        return author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MitbbsPost{" +
                "author='" + author + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
