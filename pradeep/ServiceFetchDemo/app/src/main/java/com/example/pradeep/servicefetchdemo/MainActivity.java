package com.example.pradeep.servicefetchdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public Intent i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       callService1();
        callService2();
    }

    public void callService1(){
        i1 = new Intent(MainActivity.this,MyService.class);
        startService(i1);
    }

    public void callService2(){
        i2 = new Intent(MainActivity.this,MyService2.class);
        startService(i2);
    }
}
