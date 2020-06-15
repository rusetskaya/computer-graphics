package com.example.lab9;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RectangleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        final GLSurfaceView glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        MyGLRendererPolygon renderer = new MyGLRendererPolygon();
        glSurfaceView.setRenderer(renderer);
        setContentView(glSurfaceView);
    }
}