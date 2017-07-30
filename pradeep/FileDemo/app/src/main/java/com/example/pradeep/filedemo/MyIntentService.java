package com.example.pradeep.filedemo;

import android.Manifest;
import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by pradeep on 26/7/17.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntent Service");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        writeToFile("pradeep chauhan");


}
    public void writeToFile(String data) {
        // Get the directory for the user's public pictures directory.
        final File path = new File(Environment.getExternalStorageDirectory(), "FILES_DEMO");

        // Make sure the path directory exists.
        if (!path.exists()) {
            // Make it, if it doesn't exit
            path.mkdirs();
        }

        final File file = new File(path, "config.txt");

        // Save your stream, don't forget to flush() it before closing it.

        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(data);

            myOutWriter.close();

            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}
