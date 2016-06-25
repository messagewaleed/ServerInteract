package com.iacsoftware.training.serverinteract;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView list;
    ListAdapter adapter;
    JSONObject json_data;
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        list=(ListView)findViewById(R.id.thoughtListView);
        Bundle extras;
        extras = getIntent().getExtras();
        String result = (String) extras.get("line");



        try {
            json_data = new JSONObject();
            JSONArray jsonArray = new JSONArray(result);
            Log.e("Json Array Length", " is " + jsonArray.length());

            for (int i = 0; i < jsonArray.length(); i++) {

                json_data = jsonArray.getJSONObject(i);

                list1.add(json_data.getString("Name"));
                list2.add(json_data.getString("Parentage"));
                list3.add(json_data.getString("Residance"));

            }
        }catch (JSONException e) {
            Log.e("JSON Exception", "Error parsing data " + e.getMessage().toString());
        } catch (Exception e) {
            Log.e("Exception", "Error converting result " + e.getMessage().toString());
        }

        adapter = new ListAdapter(SecondActivity.this, list1,list2,list3);
        list.setAdapter(adapter);

    }

}
