package in.relsellglobal.colorpickerdemo;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Bitmap bitmap;
    private ImageView selectedImage;
    LinearLayout dropper;
    TextView textView;
    Button galleryBtn;

    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedImage = (ImageView) findViewById(R.id.image);
        dropper = (LinearLayout)findViewById(R.id.dropper);
        textView = (TextView)findViewById(R.id.dropperTV);
        galleryBtn = (Button)findViewById(R.id.galleryBtn);


        root =  (RelativeLayout) findViewById(R.id.activity_main);


        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);

            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri photoUri = data.getData();
            if (photoUri != null) {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);


                    selectedImage.setDrawingCacheEnabled(true);

                    selectedImage.buildDrawingCache();

                    selectedImage.setImageBitmap(bitmap);

                    bitmap = selectedImage.getDrawingCache();



                    selectedImage.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent ev) {
                            final int action = ev.getAction();

                            final int evX = (int) ev.getX();
                            final int evY = (int) ev.getY();

                            boolean res = false;

                            switch (action) {
                                case MotionEvent.ACTION_DOWN:
                                case MotionEvent.ACTION_MOVE:
                                    int pxl = bitmap.getPixel(evX, evY);
                                    int r1 = Color.red(pxl);
                                    int g1 = Color.green(pxl);
                                    int b1 = Color.blue(pxl);
                                    int alpha1 = Color.alpha(pxl);


                                    Log.v("TAG", "R G B " + r1 + " " + g1 + " " + b1);

                                    final StringBuilder builder1 = new StringBuilder();
                                    builder1.append("#");
                                    builder1.append(r1 > 9 ? Integer.toHexString(r1) : "0"+Integer.toHexString(r1) ); // Real computation here
                                    builder1.append(g1 > 9 ? Integer.toHexString(g1) : "0"+Integer.toHexString(g1)); // Real computation here
                                    builder1.append(b1 > 9 ? Integer.toHexString(b1) : "0"+Integer.toHexString(b1)); // Real computation here

                                    Log.v("TAG", "Hex Color is " + builder1.toString());
                                    //Toast.makeText(MainActivity.this,"Selected Color is "+builder.toString(),Toast.LENGTH_LONG).show();

                                    try {

                                        dropper.setBackgroundColor(Color.parseColor(builder1.toString()));
                                        textView.setText(builder1.toString());
                                    }catch(IllegalArgumentException e) {
                                        e.printStackTrace();
                                    }
                                    res = true;
                                    break;



                            }

                            return res;
                        }
                    });




                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



        }
    }




}
