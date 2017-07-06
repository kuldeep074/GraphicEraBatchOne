/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.jsonparsingdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import in.relsellglobal.jsonparsingdemo.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    ArrayList<WebPojo> webPojoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webPojoArrayList = new ArrayList<>();

        new JSONParsingTask().execute();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public class JSONParsingTask extends AsyncTask<Void,Void,String> {

        @Override
        protected String doInBackground(Void... params) {

            String url = "http://relsellglobal.in/DeliveryS/CRKInsightsServer/mobilecheck.php?controlVar=32";
            StringBuffer stringBuffer = new StringBuffer();

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

                int code = connection.getResponseCode();

                if(code == HttpURLConnection.HTTP_OK) {

                    InputStream inputStream = connection.getInputStream();

                    String line = "";


                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    while((line = bufferedReader.readLine()) != null) {
                        stringBuffer.append(line);
                    }

                    return stringBuffer.toString();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if(s!=null) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONObject jsonObjectList = jsonObject.getJSONObject("list");
                    JSONArray jsonArray = jsonObjectList.getJSONArray("data");

                    for(int i=0;i<jsonArray.length();i++) {
                        JSONObject obj = (JSONObject) jsonArray.get(i);
                        WebPojo webPojo = new WebPojo();
                        webPojo.setId(obj.getString("ID"));
                        webPojo.setUsername(obj.getString("USERNAME"));
                        webPojo.setFcmId(obj.getString("FCMID"));
                        webPojoArrayList.add(webPojo);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                System.out.println(webPojoArrayList);


            }


        }
    }


}
