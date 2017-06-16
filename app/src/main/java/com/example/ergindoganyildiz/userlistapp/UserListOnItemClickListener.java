package com.example.ergindoganyildiz.userlistapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.ergindoganyildiz.userlistapp.bean.User;
import com.google.gson.Gson;

/**
 * Created by ergindoganyildiz on 6/16/17.
 */

public class UserListOnItemClickListener implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        User user = (User) adapterView.getItemAtPosition(i);

        Intent intent = new Intent(adapterView.getContext(), UserDetailActivity.class);
        intent.putExtra("USER", (new Gson().toJson(user)));

        adapterView.getContext().startActivity(intent);

    }
}
