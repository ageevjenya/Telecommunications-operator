package com.netcracker.app.domain.messages;

public class MessageTextAndRequestId {
    private Long id;
    private String text;

    public MessageTextAndRequestId(){}
    public MessageTextAndRequestId(Long id, String text){
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
