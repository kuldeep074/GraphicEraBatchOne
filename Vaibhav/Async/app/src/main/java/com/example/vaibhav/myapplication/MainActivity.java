package com.example.vaibhav.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FetchDataUserTask((ImageView) findViewById(R.id.img)).execute();
    }

    public class FetchDataUserTask extends AsyncTask<Void, Void, Bitmap> {


        ImageView img;


        public FetchDataUserTask(ImageView img) {
            this.img = img;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            String server = "s-media-cache-ak0.pinimg.com";
            String port = "443";
            String urlToHit = "https://" + server + ":" + port + "/736x/ca/ea/57/caea57268e1dee696f3c20a5a0f895f2--nice-wallpaper-iphone-nice-wallpapers.jpg";
            Bitmap mIcon11 = null;
            try {

                InputStream in = new URL(urlToHit).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);

            }catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;

        }

        @Override
        protected void onPostExecute(Bitmap result) {


                img.setImageBitmap(result);
        }


    }
}

