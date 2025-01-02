package com.example.admin.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Subscribe")
public class SubscribeDocument {
    private String id;
    private String email;
    private Date subscribedAt;

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

    public Date getSubscribedAt () {
        return subscribedAt;
    }

    public void setSubscribedAt (Date subscribedAt) {
        this.subscribedAt = subscribedAt;
    }
}
