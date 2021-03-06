package com.example.httptestj;

import androidx.databinding.BaseObservable;

public class User extends BaseObservable {

    private String id;
    private String name;
    private String blog;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
