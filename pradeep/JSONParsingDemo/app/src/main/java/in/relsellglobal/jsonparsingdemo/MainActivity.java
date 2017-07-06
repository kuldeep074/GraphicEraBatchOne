/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.jsonparsingdemo;

import android.support.v4.app.FragmentTransaction;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
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

public class MainActivity extends AppCompatActivity implements jasonfragFragment.OnListFragmentInteractionListener {

    ArrayList<WebPojo> webPojoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.activity_main,new jasonfragFragment());
        ft.commit();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }




}
