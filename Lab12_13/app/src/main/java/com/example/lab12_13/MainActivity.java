package com.example.lab12_13;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    MyGLSurfaceView sw;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

         sw = new MyGLSurfaceView(this);
         setContentView(sw);
     }

}


