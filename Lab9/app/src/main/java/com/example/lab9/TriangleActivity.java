package com.example.lab9;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TriangleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        final GLSurfaceView glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        MyGLRenderer renderer = new MyGLRenderer();
        glSurfaceView.setRenderer(renderer);
        setContentView(glSurfaceView);
    }
}