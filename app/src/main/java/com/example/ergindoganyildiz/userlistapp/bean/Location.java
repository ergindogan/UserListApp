package com.example.ergindoganyildiz.userlistapp.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ergindoganyildiz on 6/16/17.
 */

public class Location{

    private String street;
    private String city;
    private String state;
    private int postcode;

    public Location(JSONObject object){
        try {
            setStreet(object.getString("street"));
            setCity(object.getString("city"));
            setState(object.getString("state"));
            setPostcode(object.getInt("postcode"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

}
