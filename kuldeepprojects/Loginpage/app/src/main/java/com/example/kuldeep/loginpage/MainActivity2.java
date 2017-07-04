package com.example.kuldeep.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    private TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("reached Main activity");
        setContentView(R.layout.activity_main2);
        sign();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("destroy main activity");
    }
    public void sign()

    {
        signin = (TextView) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);

            }
        });
    }



    }


