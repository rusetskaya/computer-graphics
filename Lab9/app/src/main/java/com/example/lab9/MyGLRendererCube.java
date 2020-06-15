package com.example.lab9;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class MyGLRendererCube implements GLSurfaceView.Renderer {
    private Cube cube;

    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private final float[] mModelMatrix = new float[16];

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(1f,0f,0f,1f);
        cube = new Cube(mMVPMatrix);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0,0,width,height);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);

        float ratio = width > height?(float)width/height:(float)height/width;

        Matrix.setIdentityM(mModelMatrix,0);

        Matrix.setLookAtM(mViewMatrix,0,
                0.0f,1.5f,3f,
                0f,0f,0f,
                0f,1f,0f);

        Matrix.perspectiveM(mProjectionMatrix,0,45f,ratio,0.1f,10f);

        Matrix.multiplyMM(mMVPMatrix,0,mViewMatrix,0,mModelMatrix,0);
        Matrix.multiplyMM(mMVPMatrix,0,mProjectionMatrix,0,mMVPMatrix,0);

    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT|GLES20.GL_DEPTH_BUFFER_BIT);
        cube.draw(mMVPMatrix);
    }
}
