package com.example.pradeep.countmax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button count;
    private TextView display;
    private Icheck icheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icheck=new Check();
        compare();
    }

    private void compare() {
        count=(Button)findViewById(R.id.count);
        display=(TextView) findViewById(R.id.display);
        final ArrayList<String> list=new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        list.add("Drack");
        list.add("Pradeep");
        list.add("Lina");
        list.add("Rehman");
        list.add("Meena");
        list.add("Mehar");
        list.add("Seeta");
        list.add("Kuldeep");
        list.add("Ankit");
        list.add("Neeta");
        list.add("Rohan");
        list.add("Priyanka");
        list.add("Reeta");
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String output =  icheck.verify(list);
               display.setText(output);

            }
        });
    }


}
