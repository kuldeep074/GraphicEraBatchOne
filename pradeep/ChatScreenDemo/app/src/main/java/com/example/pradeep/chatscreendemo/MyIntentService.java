package com.example.pradeep.chatscreendemo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * Created by pradeep on 26/7/17.
 */

public class MyIntentService extends IntentService {

    Handler incomingHandler;

    public MyIntentService() {
        super("MyIntent Service");

    }




    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        String str = intent.getStringExtra("str");

        Message message = new Message();
        message.obj = str;

        ItemFragment.h.sendMessage(message);



    }

    public void setHandler(Handler h) {
        this.incomingHandler = h;
    }
}



