/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.asynctaskdemo;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String majorString = "The only way to do great work is to love what you do";
    TextView textView;
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what == 1) {

                String s = (String) msg.obj;

                textView.setText(textView.getText().toString()+" "+s);


            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);

        String[] strArray = majorString.split(" ");

        new TextAnimatorTask(strArray).execute();





    }

    public class TextAnimatorTask extends AsyncTask<String[],Void,String> {

        String []strArray = null;

        public TextAnimatorTask(String []strArray) {
            this.strArray = strArray;
        }


        @Override
        protected String doInBackground(String[]... params) {

            for(int i=0;i<strArray.length;i++) {

                String s = strArray[i];

                Message message = new Message();
                message.obj = s;
                message.what = 1;
                handler.sendMessage(message);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }




            return null;
        }


    }


}
