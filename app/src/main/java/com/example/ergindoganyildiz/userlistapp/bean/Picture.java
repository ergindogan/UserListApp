package com.example.ergindoganyildiz.userlistapp.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ergindoganyildiz on 6/16/17.
 */

public class Picture {

    private String large;
    private String medium;
    private String thumbnail;

    public Picture(JSONObject object){
        try {
            setLarge(object.getString("large"));
            setMedium(object.getString("medium"));
            setThumbnail(object.getString("thumbnail"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
