package com.example.lab9;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;


public class Triangle {

    //Geometry
    private FloatBuffer vertexBuffer;
    private final int POSITION_COUNT = 3; //number of position coordinates
    private final int COLOR_COUNT = 3; //number of color coordinates

    private final int COORDINATES_PER_VERTEX = (POSITION_COUNT+COLOR_COUNT);

    static float triangleCoords[] = {
            0.0f,  0.622008459f, 0.0f, 1f, 0f, 0f,
            -0.5f, -0.311004243f, 0.0f, 0f, 1f, 0f,
            0.5f, -0.311004243f, 0.0f, 0f, 0f,1f
            };

    //float color[] = { 0.6f, 0.77f, 0.2f, 1.0f };

    //Rendering
    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
            "attribute vec4 vColor;" +
            "varying vec4 oColor;" +
            "void main() {" +
            "  oColor = vColor;" +
            "  gl_Position = vPosition;" +
            "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
            "varying vec4 oColor;" +
            "void main() {" +
            "  gl_FragColor = oColor;" +
            "}";
    private final int mProgram;


    //Draw
    private int mPositionHandle;
    private int mColorHandle;
    private final int vertexCount = triangleCoords.length / COORDINATES_PER_VERTEX;
    private final int vertexStride = COORDINATES_PER_VERTEX * 4; // 4 bytes per vertex




    public Triangle() {
        ByteBuffer bb = ByteBuffer.allocateDirect(triangleCoords.length*4);//4 bytes for 1 float
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(triangleCoords);
        //vertexBuffer.position(0);

        int vertexShader = MyGLRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = MyGLRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

        mProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(mProgram, vertexShader);
        GLES20.glAttachShader(mProgram, fragmentShader);
        GLES20.glLinkProgram(mProgram);
    }

    public void draw(){

        GLES20.glUseProgram(mProgram);
        mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
        mColorHandle = GLES20.glGetAttribLocation(mProgram, "vColor");

        vertexBuffer.position(0);
        GLES20.glVertexAttribPointer(mPositionHandle, POSITION_COUNT,
                GLES20.GL_FLOAT, false,vertexStride, vertexBuffer);


        vertexBuffer.position(POSITION_COUNT);
        GLES20.glVertexAttribPointer(mColorHandle,COLOR_COUNT,
                GLES20.GL_FLOAT, false,vertexStride, vertexBuffer);

        GLES20.glEnableVertexAttribArray(mPositionHandle);
        GLES20.glEnableVertexAttribArray(mColorHandle);

        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);


        GLES20.glDisableVertexAttribArray(mPositionHandle);
        GLES20.glDisableVertexAttribArray(mColorHandle);
    }
}
