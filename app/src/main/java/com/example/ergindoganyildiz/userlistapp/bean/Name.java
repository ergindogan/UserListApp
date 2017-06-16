package com.example.ergindoganyildiz.userlistapp.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ergindoganyildiz on 6/16/17.
 */

public class Name {
    private String title;
    private String first;
    private String last;

    public Name(JSONObject object){
        try {
            setTitle(object.getString("title"));
            setFirst(object.getString("first"));
            setLast(object.getString("last"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return title + " " + first + " " + last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

}
