package com.github.tinawhite909.todolistspring.users.bean;

public class Message {
    private String title;
    private String content;
    private String entraInfo;

    public Message(String title, String content, String entraInfo) {
        this.title = title;
        this.content = content;
        this.entraInfo = entraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEntraInfo() {
        return entraInfo;
    }

    public void setEntraInfo(String entraInfo) {
        this.entraInfo = entraInfo;
    }
}
