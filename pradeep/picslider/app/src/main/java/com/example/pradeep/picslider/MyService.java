package com.example.pradeep.picslider;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by pradeep on 17/7/17.
 */

public class MyService extends Service
{
    @Nullable
    @Override
    //abstract method

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        System.out.println("created");
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        String s = intent.getStringExtra("RollNo");
        Log.v("TAG","Data from activity "+s);
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy()
    {
        System.out.println("Destroyed");
    }



}
