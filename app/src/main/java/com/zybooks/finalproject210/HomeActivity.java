package com.zybooks.finalproject210;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize and set click listeners for each button
        // Each button when clicked will start a different activity

        Button buttonPage1 = findViewById(R.id.buttonPage1);
        buttonPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Page1Activity when buttonPage1 is clicked
                startActivity(new Intent(HomeActivity.this, Page1Activity.class));
            }
        });

        Button buttonPage2 = findViewById(R.id.buttonPage2);
        buttonPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Page2Activity when buttonPage2 is clicked
                startActivity(new Intent(HomeActivity.this, Page2Activity.class));
            }
        });

        Button buttonPage3 = findViewById(R.id.buttonPage3);
        buttonPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Page3Activity when buttonPage3 is clicked
                startActivity(new Intent(HomeActivity.this, Page3Activity.class));
            }
        });

        Button buttonPage4 = findViewById(R.id.buttonPage4);
        buttonPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Page4Activity when buttonPage4 is clicked
                startActivity(new Intent(HomeActivity.this, Page4Activity.class));
            }
        });
    }
}
