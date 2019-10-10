package com.studyjwt.domain;



public class User implements Role{

    private int id;

    private String username;

    private String password;


    @Override
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void setId(Integer id) {

    }

    public void setPassword(String password) {
        this.password = password;
    }
}
