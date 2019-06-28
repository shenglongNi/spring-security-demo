package com.nsl.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User implements Serializable {
    private BigDecimal id;

    private String username;

    private String password;

    private Boolean enabled;

    private Boolean locked;

    private Date accountExpire;

    private Date credentialExpire;

    private Date createdTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Date getAccountExpire() {
        return accountExpire;
    }

    public void setAccountExpire(Date accountExpire) {
        this.accountExpire = accountExpire;
    }

    public Date getCredentialExpire() {
        return credentialExpire;
    }

    public void setCredentialExpire(Date credentialExpire) {
        this.credentialExpire = credentialExpire;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}