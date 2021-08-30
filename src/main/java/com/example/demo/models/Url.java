package com.example.demo.models;

public class Url {
    public String getMyUrl() {
        return myUrl;
    }

    public void setMyUrl(String myUrl) {
        this.myUrl = myUrl;
    }

    private String myUrl;

    public Url() {
        this.myUrl = "";
    }

    public Url( String str) {
        this.myUrl = str;
    }


}
