package com.example.makkhay.jsonxml;


import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This program reads json feed. The json file is stored in the web and
 * the objects are picked by the application using asncytask
 *
 *
 *
 */





public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsyncJsonFeed().execute("https://api.myjson.com/bins/m5g71");  //executes the asnyctask using the url


    }
    class AsyncJsonFeed extends AsyncTask<String, Void, String>
    {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        protected String doInBackground(String... urls){
            return new DownloadJSONFeed().readJSONFeed(urls[0]);
        }

        protected void onPostExecute(String json)
        {
            try {
                JSONObject jo = new JSONObject(json);
                JSONObject value = jo.getJSONObject("post");
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(value.getString("number") + value.getString("proverb")); // will pick these objects
            } catch (JSONException ex)
            {
                Log.d("JSONArray", ex.getLocalizedMessage());
            }
        }
    }
}
