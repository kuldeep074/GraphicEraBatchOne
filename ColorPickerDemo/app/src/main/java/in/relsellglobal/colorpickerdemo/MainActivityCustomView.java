/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.colorpickerdemo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivityCustomView extends AppCompatActivity {

    Bitmap bitmap;
    private CustomImageView selectedImage;
    LinearLayout dropper;
    TextView textView;
    Button galleryBtn;

    private Button takePictureButton;
    File fileCamera;


    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_custom);
        selectedImage = (CustomImageView) findViewById(R.id.image);
        dropper = (LinearLayout) findViewById(R.id.dropper);
        textView = (TextView) findViewById(R.id.dropperTV);
        galleryBtn = (Button) findViewById(R.id.galleryBtn);
        takePictureButton = (Button) findViewById(R.id.cameraBtn);


        root = (RelativeLayout) findViewById(R.id.activity_main);


        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);

            }
        });

        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callCamera();
            }
        });

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                final android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) MainActivityCustomView.this
                        .getSystemService(Context.CLIPBOARD_SERVICE);
                final android.content.ClipData clipData = android.content.ClipData
                        .newPlainText("text label",textView.getText());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(MainActivityCustomView.this,"Copied color code "+textView.getText(),Toast.LENGTH_LONG).show();

                return true;


            }
        });


    }


    public void callCamera() {

        String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (!hasPermissions(permissions)) {

            ActivityCompat.requestPermissions(MainActivityCustomView.this, permissions, 0);

        } else {
            takePicture();
        }
    }

    public boolean hasPermissions(String[] permissions) {

        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(MainActivityCustomView.this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Uri photoUri = Uri.fromFile(fileCamera);
                if (photoUri != null) {
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
                        selectedImage.setBitmapC(bitmap);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri photoUri = data.getData();
                if (photoUri != null) {
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
                        selectedImage.setBitmapC(bitmap);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        if (selectedImage != null) {

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
                            selectedImage.setCursorToBeDrawn(true, evX, evY);
                            int pxl = bitmap.getPixel(evX, evY);
                            int r1 = Color.red(pxl);
                            int g1 = Color.green(pxl);
                            int b1 = Color.blue(pxl);
                            int alpha1 = Color.alpha(pxl);


                            Log.v("TAG", "R G B " + r1 + " " + g1 + " " + b1);

                            final StringBuilder builder1 = new StringBuilder();
                            builder1.append("#");
                            builder1.append(r1 > 9 ? Integer.toHexString(r1) : "0" + Integer.toHexString(r1)); // Real computation here
                            builder1.append(g1 > 9 ? Integer.toHexString(g1) : "0" + Integer.toHexString(g1)); // Real computation here
                            builder1.append(b1 > 9 ? Integer.toHexString(b1) : "0" + Integer.toHexString(b1)); // Real computation here

                            Log.v("TAG", "Hex Color is " + builder1.toString());
                            //Toast.makeText(MainActivity.this,"Selected Color is "+builder.toString(),Toast.LENGTH_LONG).show();

                            try {

                                dropper.setBackgroundColor(Color.parseColor(builder1.toString()));
                                textView.setText(builder1.toString());
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            }
                            res = true;
                            break;
                        case MotionEvent.ACTION_UP:
                            selectedImage.setCursorToBeDrawn(false, evX, evY);
                            res = true;
                            break;


                    }

                    return res;
                }
            });

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == 0) {
            boolean res = false;
            int i = 0;
            for (int grantRes : grantResults) {
                if (grantRes == PackageManager.PERMISSION_DENIED) {
                    Log.v("TAG", "Permission denied " + permissions[i]);
                    res = true;
                }
                i++;
            }
            Log.v("TAG", "res " + res);
            if (!res) {
                takePicture();
            }
        }

    }

    public void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileCamera = getOutputMediaFile();
        Uri file = Uri.fromFile(fileCamera);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

        startActivityForResult(intent, 100);
    }

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");
    }


}
