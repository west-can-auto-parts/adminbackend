package com.example.admin.dto;

import java.util.Date;

public class SubscribeResponse {
    private String id;
    private String email;
    private String subscribedAt;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getSubscribedAt () {
        return subscribedAt;
    }

    public void setSubscribedAt (String subscribedAt) {
        this.subscribedAt = subscribedAt;
    }
}
