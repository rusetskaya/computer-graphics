package com.example.lab2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;


public class MView extends View {

    Paint p;
    RectF rectF;
    float[] lines;
    Path path;


    public MView(Context context) {
        super(context);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        //p.setColor(Color.RED);
        //p.setStrokeWidth(10);
        //p.setStyle(Paint.Style.FILL_AND_STROKE);

        rectF = new RectF(100,400,380,600);
//        lines = new float[]{70,420,240,300,240,300,410,420};
        path = new Path();
        path.reset();
        path.moveTo(70,420);
        path.lineTo(240,300);
        path.lineTo(410,420);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(80, 102, 204, 255);

        path.reset();

        p.setColor(Color.RED);
        p.setStyle(Paint.Style.FILL);
        p.setTextSize(25);
        p.setStrokeWidth(1);
        canvas.drawText("This is my picture", 150, 250, p);

        p.setColor(Color.BLUE);
        path.moveTo(100, 100);
        path.lineTo(150, 200);
        path.lineTo(50, 200);
        canvas.drawPath(path,p);

        p.setColor(Color.YELLOW);
        path.moveTo(250, 100);
        path.lineTo(300, 200);
        path.lineTo(200, 200);
        canvas.drawPath(path,p);
        path.close();

        p.setColor(Color.GREEN);
        path.addRect(rectF, Path.Direction.CW);
        path.addCircle(450, 150, 25, Path.Direction.CW);


        canvas.drawPath(path, p);

        //path.offset(500,100);

        //p.setColor(Color.BLUE);
        //canvas.drawPath(path, p);
    }
}
