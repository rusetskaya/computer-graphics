package com.example.lab10_11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Cube {
    public FloatBuffer vertexBuffer;
    private FloatBuffer texBuffer;
    private int[] imageFileId = { R.drawable.cat1 };
    private int[] textureIds = new int[1];
    private Bitmap bitmap;
    private float cubeHalfSize = 1.0f;
    public float zoomInX = 0, zoomInY = 0;
    public float[] vertices = new float[4];


    public Cube(Context context) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(12 * 4 );
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();

        bitmap = BitmapFactory.decodeStream(
                context.getResources().openRawResource(imageFileId[0]));
        int imgWidth = bitmap.getWidth();
        int imgHeight = bitmap.getHeight();
        float faceWidth = 2.0f;
        float faceHeight = 2.0f;


        float[] vertices = getScales(imgWidth, imgHeight, faceHeight, faceWidth);
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        float[] texCoords = {
                0.0f, 1.0f,
                1.0f, 1.0f,
                0.0f, 0.0f,
                1.0f, 0.0f
        };
        ByteBuffer tbb = ByteBuffer.allocateDirect(texCoords.length * 4);
        tbb.order(ByteOrder.nativeOrder());
        texBuffer = tbb.asFloatBuffer();
        texBuffer.put(texCoords);
        texBuffer.position(0);

    }

    public float[] getScales(int imgWidth, int imgHeight, float faceHeight, float faceWidth) {
        if (imgWidth > imgHeight) {
            faceHeight = (faceHeight + zoomInY) * imgHeight / imgWidth;
        } else {
            faceWidth = (faceWidth + zoomInX) * imgWidth / imgHeight;
        }
        float faceLeft = -faceWidth / 2;
        float faceRight = -faceLeft;
        float faceTop = faceHeight / 2;
        float faceBottom = -faceTop;

        float[] vertices = {
                faceLeft, faceBottom, 0.0f,
                faceRight, faceBottom, 0.0f,
                faceLeft, faceTop, 0.0f,
                faceRight, faceTop, 0.0f,
        };
        return vertices;
    }


    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CCW);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texBuffer);

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, cubeHalfSize);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIds[0]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glPopMatrix();

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    }

    public void loadTexture(GL10 gl) {
        gl.glGenTextures(1, textureIds, 0);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIds[0]);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();
    }
}