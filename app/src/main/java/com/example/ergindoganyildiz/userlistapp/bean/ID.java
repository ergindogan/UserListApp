package com.example.ergindoganyildiz.userlistapp.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ergindoganyildiz on 6/16/17.
 */

public class ID{
    private String name;
    private String value;

    public ID(JSONObject object){
        try {
            setName(object.getString("name"));
            setValue(object.getString("value"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
