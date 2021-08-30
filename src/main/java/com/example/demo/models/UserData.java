package com.example.demo.models;


import javax.persistence.*;

@Entity
@Table(name="userData")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer userId;
    @Column(nullable = false)
    private String myUrl;

    public UserData() {
        this.userId = -1;
        this.myUrl = "";
    }

    public UserData(Integer userId) {
        this.userId = userId;
        this.myUrl = "";
    }

    public UserData(Integer userId, String myUrl) {
        this.userId = userId;
        this.myUrl = myUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMyUrl() {
        return myUrl;
    }

    public void setMyUrl(String myUrl) {
        this.myUrl = myUrl;
    }
}
