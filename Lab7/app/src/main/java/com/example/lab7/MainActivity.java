package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean firstColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        float openGLVersion = 0;

        ActivityManager activityManager =
                (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configInfo = activityManager.getDeviceConfigurationInfo();
        if (configInfo.reqGlEsVersion != ConfigurationInfo.GL_ES_VERSION_UNDEFINED) {
            openGLVersion = configInfo.reqGlEsVersion;
        }

        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.sample_text);
        textView.setText(Float.toString(openGLVersion));


        final GLSurfaceView glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        final ChangeColor renderer = new ChangeColor();
        glSurfaceView.setRenderer(renderer);
        glSurfaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstColor = !firstColor;
                renderer.changeColor(firstColor);
            }
        });
        setContentView(glSurfaceView);
    }
}
