package com.example.lab1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.SurfaceHolder;


public class DrawingThread extends Thread {
private SurfaceHolder surfaceHolder;


    public DrawingThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }


    @Override
    public void run() {
        Canvas canvas = surfaceHolder.lockCanvas();
        if(canvas != null){
            RectF rectF = new RectF(100,400,380,600);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            Path path = new Path();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(10);
            canvas.drawRGB(30,30,200);
            canvas.drawRoundRect(rectF,10,10,paint);
            paint.setTextSize(30);
            canvas.drawText("This is house!", 200, 100, paint);
            paint.setColor(Color.YELLOW);
            canvas.drawCircle(200, 200, 50, paint);
            float[] f = new float[4];
            f[0] = 100.10f;
            f[1] = 10.3f;
            f[2] = 50.60f;
            f[3] = 150.50f;
            canvas.drawPoints(f, paint);
            paint.setColor(Color.BLUE);
            path.reset();
            path.moveTo(70,420);
            path.lineTo(240,300);
            path.lineTo(410,420);
            canvas.drawPath(path,paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
