package com.waterzend.springbootmysql.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.waterzend.springbootmysql.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {


    private static final long serialVersionUID = 2720910710211538832L;
    private Integer id;
    private String name;
    private String password;
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date GMTCreate;
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date GMTUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getGMTCreate() {
        return GMTCreate;
    }

    public void setGMTCreate(Date GMTCreate) {
        this.GMTCreate = GMTCreate;
    }

    public Date getGMTUpdate() {
        return GMTUpdate;
    }

    public void setGMTUpdate(Date GMTUpdate) {
        this.GMTUpdate = GMTUpdate;
    }
}
