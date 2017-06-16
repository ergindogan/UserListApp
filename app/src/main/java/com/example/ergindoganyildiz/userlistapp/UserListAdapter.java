package com.example.ergindoganyildiz.userlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ergindoganyildiz.userlistapp.bean.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ergindoganyildiz on 6/15/17.
 */

public class UserListAdapter extends BaseAdapter {

    private List<User> userList;
    private Context context;
    private Picasso picasso;

    public UserListAdapter(Context context, List<User> userList){
        this.userList = userList;
        this.context = context;
        picasso = Picasso.with(context);
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        User user = (User) getItem(i);

        View vi = view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (vi == null) {
            vi = inflater.inflate(R.layout.user_row, null);
        }

        TextView tv = vi.findViewById(R.id.user_name);
        tv.setText(user.getNameString());

        ImageView iv = vi.findViewById(R.id.icon);
        int placeHolder = user.getGender().equals("male") == true ? R.drawable.male_icon : R.drawable.female_icon;

        picasso.load(user.getPicture().getLarge())
                .placeholder(placeHolder)
                .error(R.drawable.error_icon)
                .into(iv);

        return vi;
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
    }
}
