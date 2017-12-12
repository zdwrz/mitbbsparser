package com.aweiz.mitbbs.mitbbsparser.parser.thread;

import java.util.ArrayList;
import java.util.List;

public class MitbbsThreadDetail {

    private String title;
    private String info;
    private List<MitbbsPost> postList = new ArrayList<>();
    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public List<MitbbsPost> getPostList() {
        return postList;
    }

    public void setPostList(List<MitbbsPost> postList) {
        this.postList = postList;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MitbbsThreadDetail{" +
                "title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", postList=" + postList +
                '}';
    }

    public void addPost(MitbbsPost newPost) {
        postList.add(newPost);
    }
}
