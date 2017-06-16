package com.example.ergindoganyildiz.userlistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ergindoganyildiz.userlistapp.bean.User;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by ergindoganyildiz on 6/16/17.
 */

public class UserDetailActivity extends AppCompatActivity {

    private Picasso picasso;
    private ImageView icon;
    private TextView name;
    private ImageView nat;
    private TextView email;
    private TextView idName;
    private TextView idValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail);

        picasso = Picasso.with(this);
        icon = (ImageView) findViewById(R.id.user_detail_icon);
        name = (TextView) findViewById(R.id.user_detail_name);
        nat = (ImageView) findViewById(R.id.user_nat);
        email = (TextView) findViewById(R.id.user_email);

        idName = (TextView) findViewById(R.id.id_layout_name);
        idValue = (TextView) findViewById(R.id.id_layout_value);

        User user = (new Gson()).fromJson(getIntent().getStringExtra("USER"), User.class);
        insertUserDetails(user);
    }

    private void insertUserDetails(User user){
        int placeHolder = user.getGender().equals("male") == true ? R.drawable.male_icon : R.drawable.female_icon;

        picasso.load(user.getPicture().getLarge())
                .placeholder(placeHolder)
                .error(R.drawable.error_icon)
                .into(icon);
        name.setText(user.getNameString());
        email.setText(user.getEmail());
        idName.setText(user.getId().getName());
        idValue.setText(user.getId().getValue());
        setNationalityImage(nat, user.getNat());
    }

    private void setNationalityImage(ImageView natView, String nat){
        String url = "http://flags.fmcdn.net/data/flags/w1160/" + nat.toLowerCase() + ".png";
        picasso.load(url)
                .placeholder(R.drawable.error_icon)
                .error(R.drawable.error_icon)
                .into(natView);

    }
}
