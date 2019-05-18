package com.photo.dao.domain;

public class admin {
    private Integer ad_id;
    private String ad_account;
    private String ad_password;
    private String ad_avatar;

    public admin(Integer ad_id, String ad_account, String ad_password, String ad_avatar) {
        this.ad_id = ad_id;
        this.ad_account = ad_account;
        this.ad_password = ad_password;
        this.ad_avatar = ad_avatar;
    }

    public admin() {
    }

    public Integer getAd_id() {
        return ad_id;
    }

    public void setAd_id(Integer ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_account() {
        return ad_account;
    }

    public void setAd_account(String ad_account) {
        this.ad_account = ad_account;
    }

    public String getAd_password() {
        return ad_password;
    }

    public void setAd_password(String ad_password) {
        this.ad_password = ad_password;
    }

    public String getAd_avatar() {
        return ad_avatar;
    }

    public void setAd_avatar(String ad_avatar) {
        this.ad_avatar = ad_avatar;
    }
}
