package com.example.lab9;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class MyGLRenderer implements GLSurfaceView.Renderer {
    private Triangle triangle;

    public static int loadShader(int type, String shaderCode){
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }


    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0.9f,1f,0.9f,1f);
        triangle = new Triangle();
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int w, int h) {
     GLES20.glViewport(0,0,w,h);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT|GLES20.GL_DEPTH_BUFFER_BIT);
        triangle.draw();
    }
}
