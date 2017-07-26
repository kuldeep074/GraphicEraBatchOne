package com.example.pradeep.audioplayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by pradeep on 24/7/17.
 */

public class MainActivity2 extends Activity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int songId = getIntent().getIntExtra("songId",-1);

        mediaPlayer=MediaPlayer.create(MainActivity2.this, songId);

        mediaPlayer.start();

    }
}
