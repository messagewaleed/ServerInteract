package com.iacsoftware.training.serverinteract;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();

    }

    public void sendValue(View view)
    {
        EditText input = (EditText) findViewById(R.id.editText);

       

        new SearchSimple().execute(input.getText().toString());
        Log.e("hello", "welcome");

    }


    class SearchSimple extends AsyncTask<String, String, String>
    {


        StringBuilder line = new StringBuilder();
        String url_search = "http://www.iacsoftware.com/admin_and_panel.php";
        BufferedReader rd;
        //  Building Parameters
        List<NameValuePair> param = new ArrayList<NameValuePair>();
        @Override
        protected String doInBackground(String... params) {
            Log.e("hello1","welcome2");

            param.add(new BasicNameValuePair("name", params[0]));
//            param.add(new BasicNameValuePair("email", params[1]));
//            param.add(new BasicNameValuePair("age", params[2]));
            try {
//                URL url = new URL(url_search);
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();



                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(url_search);
                httppost.setEntity(new UrlEncodedFormEntity(param));

                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                //Log.e("hello3","welcome");


                rd = new BufferedReader(new InputStreamReader(entity.getContent()));
String str = "";
                while((str = rd.readLine()) != null)
                {
                   line.append(str);
                }







            } catch (Exception e) {
                Log.e("Exception", "Error converting result " + e.getMessage().toString());
            }
            Log.e("test:", line.toString());
            //System.out.println("Line : " + line.toString());



            return line.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
