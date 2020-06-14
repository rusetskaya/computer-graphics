package com.example.lab1;


//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.lab1.MySurfaceView mySurfaceView = new com.example.lab1.MySurfaceView(this);
        setContentView(mySurfaceView);
    }
}
