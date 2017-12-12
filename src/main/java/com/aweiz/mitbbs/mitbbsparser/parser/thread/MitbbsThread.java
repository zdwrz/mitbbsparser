package com.aweiz.mitbbs.mitbbsparser.parser.thread;

public class MitbbsThread {
    private String title;
    private String url;
    private String timeCreated;
    private String timeUpdated;
    private String createdBy;
    private String updatedBy;
    private String fc;
    private String status = "normal";
    private String index;
    public String getUrl() {
        return url;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MitbbsThread{ " + index +
                " title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", timeCreated='" + timeCreated + '\'' +
                ", timeUpdated='" + timeUpdated + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", fc='" + fc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
