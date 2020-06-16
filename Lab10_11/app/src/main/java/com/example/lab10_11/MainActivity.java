package com.example.lab10_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public GLSurfaceView mGLSurfaceView;
    float mPreviousX,mPreviousY;
    MyGLRender mRenderer;
    RelativeLayout cubelayout;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cubelayout=(RelativeLayout)findViewById(R.id.cube_layout);
        mGLSurfaceView = new GLSurfaceView(this);
        mRenderer = new MyGLRender(this);

        mGLSurfaceView.setZOrderOnTop(true);
        mGLSurfaceView.setEGLConfigChooser( 8, 8, 8, 8, 16, 0 );
        mGLSurfaceView.getHolder().setFormat(PixelFormat.RGBA_8888);
        mGLSurfaceView.setRenderer(mRenderer);
        mGLSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        Button zoomInButton = findViewById(R.id.zoomIn);
        zoomInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = v.getX();
                float y = v.getY();
                float dx = x;// - mPreviousX;
                float dy = y;// - mPreviousY;
                mRenderer.zoomInX += 10;
                mRenderer.zoomInY += 10;
                mGLSurfaceView.requestRender();
            }
        });
        cubelayout.addView(mGLSurfaceView);
    }

    @Override public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        float dx;
        float dy;

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                dx = x - mPreviousX;
                dy = y - mPreviousY;
                mRenderer.mAngleX += dx;
                mRenderer.mAngleY += dy;
                mGLSurfaceView.requestRender();
                break;
        }
        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
