package com.studyjwt.domain;

public interface Role {
    public Integer getId();

    public String getUsername();

    public String getPassword();

    public void setId(Integer id);

    public void setUsername(String username);

    public void setPassword(String password);
}
