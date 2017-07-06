package com.example.kuldeep.sort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    EditText e1,e2,e3,e4,e5;
    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sort();

    }
    public void sort()
    {
        submit=(Button) findViewById(R.id.submit);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        al.add(e1.getText().toString());
                al.add(e2.getText().toString());
                al.add(e3.getText().toString());
                al.add(e4.getText().toString());
                al.add(e5.getText().toString());
                for(String a:al)
                {
                    System.out.println(a);
                }
                Collections.sort(al);

            }
        });
    }

}
