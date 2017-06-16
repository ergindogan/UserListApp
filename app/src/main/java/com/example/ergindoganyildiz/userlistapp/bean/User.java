package com.example.ergindoganyildiz.userlistapp.bean;

import com.example.ergindoganyildiz.userlistapp.DateUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by ergindoganyildiz on 6/15/17.
 */

public class User{

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private Date dob;
    private Date registered;
    private String phone;
    private String cell;
    private ID id;
    private Picture picture;
    private String nat;


    public User(JSONObject object){
        try {
            setGender(object.getString("gender"));
            setName(new Name(object.getJSONObject("name")));
            setLocation(new Location(object.getJSONObject("location")));
            setEmail(object.getString("email"));
            setLogin(new Login(object.getJSONObject("login")));
            setDob(DateUtil.formatDate(object.getString("dob")));
            setRegistered(DateUtil.formatDate(object.getString("registered")));
            setPhone(object.getString("phone"));
            setCell(object.getString("cell"));
            setId(new ID(object.getJSONObject("id")));
            setPicture(new Picture(object.getJSONObject("picture")));
            setNat(object.getString("nat"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public String getNameString(){
        return getName().toString();
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public ID getId() {

    return id;
    }

    public void setId(ID id) {
       this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

}