package com.example.ergindoganyildiz.userlistapp;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

/**
 * Created by ergindoganyildiz on 6/15/17.
 */

public class MyScrollListener implements AbsListView.OnScrollListener {

    private UserListAdapter adapter;
    private ProgressBar pb;

    public MyScrollListener(UserListAdapter adapter, ProgressBar pb){
        this.adapter = adapter;
        this.pb = pb;
    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if(pb.getVisibility() == View.INVISIBLE && (firstVisibleItem + visibleItemCount >= totalItemCount)){
            //need to fetch more
            UserListTask task = new UserListTask(adapter, pb);
            if(totalItemCount + 50 > 5000){
                task.execute(5000);
            }else{
                task.execute(totalItemCount + 50);
            }
        }


    }
}
