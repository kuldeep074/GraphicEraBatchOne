package com.example.pradeep.servicefetchdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by pradeep on 17/7/17.
 */

public class MyService2 extends Service implements  IServiceAsynctaskCommunicator
{
    @Nullable
    @Override
    //abstract method

    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {

        call();

        return START_NOT_STICKY;
    }


    void call() {
        HashMap<String, String> map = new HashMap<>();
        map.put("controlVar","55");
        map.put("full_name","relsell global");
        new Async(map).execute(this);


    }


    @Override
    public void sendString(String s) {

        Log.v("TAG","Called in MyService2 s is "+s);

    }
}
