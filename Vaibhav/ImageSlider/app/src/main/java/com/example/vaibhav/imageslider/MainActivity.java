package com.example.vaibhav.imageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button prev;
    private Button next;
    private ImageView image;
    int k=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        motion();
    }

    void motion()
    {
        final int []a=new int[10];
        a[0]=R.drawable.a;
        a[0]=R.drawable.b;
        a[1]=R.drawable.c;
        a[2]=R.drawable.d;
        a[3]=R.drawable.e;
        a[4]=R.drawable.f;
        a[5]=R.drawable.g;
        a[6]=R.drawable.h;
        a[7]=R.drawable.i;
        a[8]=R.drawable.j;

        prev=(Button)findViewById(R.id.Previous);
        next=(Button)findViewById(R.id.Next);
        image=(ImageView)findViewById(R.id.image);



        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {


                    if (k <=9) {
                        image.setImageResource(a[k]);
                        k++;
                    }
                    else {
                        Toast.makeText(MainActivity.this, "press prev", Toast.LENGTH_SHORT).show();
                        System.out.println(k);
                        k=9;
                    }
                }
                catch (Exception e) {

                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {


                    if (k >= 0) {
                        image.setImageResource(a[k]);
                        k--;
                    }
                    else {
                        Toast.makeText(MainActivity.this, "press next", Toast.LENGTH_SHORT).show();
                        System.out.println(k);
                        k=0;
                    }
                }
                catch (Exception e) {

                }
            }
        });
    }
}
