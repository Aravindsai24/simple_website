package com.example.demo.models;

public class Url {
    private String myUrl;

    public Url() {
        this.myUrl = "";
    }

    public Url( String str) {
        this.myUrl = str;
    }

    public String getMyUrl() {
        return myUrl;
    }

    public void setMyUrl(String myUrl) {
        this.myUrl = myUrl;
    }
}
