package com.example.kuldeep.imageswipe;

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
    int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slide();
    }

    void slide() {
        final int[] a = new int[10];
        a[0] = R.mipmap.pic1;
        a[1] = R.mipmap.pic2;
        a[2] = R.mipmap.pic3;
        a[3] = R.mipmap.pic4;
        a[4] = R.mipmap.pic5;
        a[5] = R.mipmap.pic6;
        a[6] = R.mipmap.pic7;
        a[7] = R.mipmap.pic8;
        a[8] = R.mipmap.pic9;
        a[9] = R.mipmap.pic10;


        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);
        image = (ImageView) findViewById(R.id.image);


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