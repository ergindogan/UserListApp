package com.example.ergindoganyildiz.userlistapp;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ergindoganyildiz.userlistapp.bean.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ergindoganyildiz on 6/15/17.
 */

public class UserListTask extends AsyncTask<Integer, Integer, List<User>> {

    private UserListAdapter adapter;
    private ProgressBar progressBar;

    public UserListTask(UserListAdapter adapter, ProgressBar pb){
        this.adapter = adapter;
        this.progressBar = pb;
    }

    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected List<User> doInBackground(Integer... usersToLoad) {

        List<User> list = new ArrayList<User>();

        try {
            URL url = new URL("https://randomuser.me/api/?results=" + usersToLoad[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            writeToOutputStream(input, baos);
            JSONObject object = new JSONObject(baos.toString());
            list = populateObjects(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException jsonExcetion){
            jsonExcetion.printStackTrace();
        }
        return list;
    }

    protected void onPostExecute(List<User> response) {
        progressBar.setVisibility(View.INVISIBLE);
        adapter.setUserList(response);
        adapter.notifyDataSetChanged();
    }


    private void writeToOutputStream(InputStream input, ByteArrayOutputStream baos) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1)
        {
            baos.write(buffer, 0, bytesRead);
        }
    }

    private List<User> populateObjects(JSONObject object){
        List<User> result = new ArrayList<User>();
        try {
            JSONArray array = object.getJSONArray("results");
            for(int i = 0; i < array.length(); i++){
                JSONObject obj = (JSONObject) array.get(i);
                User user = new User(obj);
                result.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
