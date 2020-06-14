package com.example.lab4;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button zoomInAnimation, zoomOutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void androidZoomInAnimation(View view) {
        Intent intent1 = new Intent(this, AndroidZoomInAnimationActivity.class);
        startActivity(intent1);
    }

    public void androidZoomOutAnimation(View view) {
        Intent intent2 = new Intent(this, AndroidZoomOutAnimationActivity.class);
        startActivity(intent2);
    }
}
