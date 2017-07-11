package com.example.pradeep.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.pradeep.login.R.layout.activity_main2;

/**
 * Created by pradeep on 29/6/17.
 */

public class MainActivity2 extends AppCompatActivity {
    private TextView already;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Reached MAinActivity2");
        setContentView(activity_main2);
        hello();
    }

    public void onDestroy()
    {
        super.onDestroy();
        System.out.println("Destroy Mainactivity2");
    }


    public void hello() {
        already=(TextView)findViewById(R.id.already);
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);

                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//move the task on the top os take the activity which is already there without creating new
                startActivity(i);

            }
        });
    }

}
