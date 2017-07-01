/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.colorpickerdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by anilkukreti on 01/07/17.
 */

public class CustomImageView extends ImageView {

    Bitmap bitmap;
    int cursorX = 50;
    int cursorY = 50;
    boolean cursorToBeDrawn;


    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),p);
        if(bitmap != null) {
            bitmap = Bitmap.createScaledBitmap(bitmap,canvas.getWidth(), canvas.getHeight(), true);
            canvas.drawBitmap(bitmap, 0, 0, p);
            if(cursorToBeDrawn) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.right_img);
                bmp = Bitmap.createScaledBitmap(bmp,100,100, true);
                canvas.drawBitmap(bmp,cursorX,cursorY,p);
            }


        }

    }

    public void setBitmapC(Bitmap bm) {
        bitmap = bm;
        invalidate();
    }

    public void setCursorToBeDrawn(boolean val,int cursorX, int cursorY) {
        cursorToBeDrawn = val;
        this.cursorX = cursorX;
        this.cursorY = cursorY;
        invalidate();
    }









}
