package com.example.lab7;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES10.glViewport;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;

public class ChangeColor implements GLSurfaceView.Renderer {
    float r=0.0f,g=0.0f,b=0.0f;

    @Override
    public void onDrawFrame(GL10 arg0) {
        glClearColor(r, g, b, 1);
        glClear(GLES20.GL_COLOR_BUFFER_BIT| GLES20.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    public void onSurfaceChanged(GL10 arg0, int width, int height) {
        glViewport(0, 0, width, height);
    }

    @Override
    public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
        changeColor(false);
    }

    public void changeColor(boolean firstColor){
        if(firstColor){
            r = 0f;
            b = 0f;
            g = 0f;
        }
        else {
            r = r + 0.1f;
            b = b + 0.8f;
            g = g + 0.9f;
        }
    }
}
