package com.example.pradeep.picslider;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

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

    public void onCreate()
    {
        System.out.println("created");
    }

    public void onDestroy()
    {
        System.out.println("Destroyed");
    }


}
