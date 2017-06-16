package com.example.ergindoganyildiz.userlistapp.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ergindoganyildiz on 6/16/17.
 */

public class Login {

    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha265;

    public Login(JSONObject object){
        try {
            setUsername(object.getString("username"));
            setPassword(object.getString("password"));
            setSalt(object.getString("salt"));
            setMd5(object.getString("md5"));
            setSha1(object.getString("sha1"));
            setSha265(object.getString("sha265"));
        }catch (JSONException e){
            e.printStackTrace();
        }
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha265() {
        return sha265;
    }

    public void setSha265(String sha265) {
        this.sha265 = sha265;
    }

}
