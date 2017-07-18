package com.example.pradeep.picslider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServiceDemoActivity extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);

        System.out.println("demo class");

        i = new Intent(ServiceDemoActivity.this,MyService.class);
        i.putExtra("RollNo","42");
        startService(i);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(this.i);
        System.out.println("stopped");
    }


}
