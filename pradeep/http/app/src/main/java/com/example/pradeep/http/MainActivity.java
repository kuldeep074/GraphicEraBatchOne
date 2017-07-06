package com.example.pradeep.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image =(ImageView)findViewById(R.id.image);
        HashMap<String, String> map = new HashMap<>();
        map.put("controlVar","55");
        map.put("full_name","relsell global");
        new FetchDataUserTask(map).execute();

    }
    public class FetchDataUserTask extends AsyncTask<Void, Integer, Bitmap> {

        StringBuffer responseString = new StringBuffer("");
        int mConnectionCode;
        HashMap<String, String> hmVars;

        public FetchDataUserTask(HashMap<String, String> hm) {
            this.hmVars = hm;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void doInBackground(Void... params) {
            //try {

            String server = "relsellglobal.in";
            String port = "80";
           String urlToHit = "http://" + server + ":" + port + "/DeliveryS/CRKInsightsServer/mobilecheck.php";
            String urlData = getUrlStringData(hmVars);


                if (urlData.substring(urlData.length() - 1).equalsIgnoreCase("&")) {
                    urlData = urlData.substring(0, (urlData.length() - 1));
                }
                urlToHit +="?"+urlData;

                URL url = new URL(urlToHit);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");\

                connection.setDoInput(true);

                mConnectionCode = connection.getResponseCode();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (mConnectionCode == HttpURLConnection.HTTP_OK) {

                    InputStream inputStream = null;
                    try {
                        inputStream = connection.getInputStream();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));

                    String line = "";

                    while ((line = rd.readLine()) != null) {
                        responseString.append(line);
                    }

                    return true;
                }
            } catch (IOException e) {
                Log.v("Message", e.getMessage());
                e.printStackTrace();
                return false;

            }
            return false;
        }
        }

        @Override
        protected void onPostExecute(Bitmap success) {
            image.setImageBitmap(success);
            if (success) {
                System.out.println("Response String "+responseString);


            } else if (mConnectionCode >= HttpURLConnection.HTTP_BAD_REQUEST && mConnectionCode < HttpURLConnection.HTTP_INTERNAL_ERROR) {


            } else if (mConnectionCode >= HttpURLConnection.HTTP_MULT_CHOICE && mConnectionCode < HttpURLConnection.HTTP_BAD_REQUEST) {


            }
        }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);


    }
}

    public String getUrlStringDataStr(HashMap<String, String> map) {
        String result = "";

        Set<String> myset = map.keySet();
        int setSize = myset != null ? myset.size() : 0;
        int i = 0;

        for (String key : myset) {
            String value = map.get(key);
            result += key + "=" + value;
            if (i <= setSize - 1)
                result += "&";
            i++;
        }
        return result;
    }

    public String getUrlStringData(HashMap<String, String> incomingHm) throws UnsupportedEncodingException {

        String result = "";

        Set<String> keys = incomingHm.keySet();
        HashMap<String, String> map = new HashMap<String, String>();
        for (String key : keys) {
            map.put(key, URLEncoder.encode(incomingHm.get(key), "UTF-8"));
        }
        result = getUrlStringDataStr(map);

        System.out.println(result);

        return result;
    }
}
