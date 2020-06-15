package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button triangleButton = findViewById(R.id.triangle);
        triangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TriangleActivity.class);
                startActivity(intent);
            }
        });

        Button polygonButton = findViewById(R.id.rectangle);
        polygonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RectangleActivity.class);
                startActivity(intent);
            }
        });

        Button cubeButton = findViewById(R.id.cube);
        cubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CubeActivity.class);
                startActivity(intent);
            }
        });
    }
}
