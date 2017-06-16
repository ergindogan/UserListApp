package com.example.ergindoganyildiz.userlistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.ergindoganyildiz.userlistapp.bean.User;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ListView lv = (ListView) findViewById(R.id.user_list);
        ProgressBar pb = (ProgressBar) findViewById(R.id.pr_br);

        UserListAdapter adapter = new UserListAdapter(this, new ArrayList<User>());
        lv.setAdapter(adapter);
        lv.setOnScrollListener(new MyScrollListener(adapter, pb));
        lv.setOnItemClickListener(new UserListOnItemClickListener());

        UserListTask task = new UserListTask(adapter, pb);
        task.execute(50);
    }

}
