package com.zybooks.finalproject210;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// HomeActivity.java
public class HomeActivity extends AppCompatActivity {

    private Button buttonPage1, buttonPage2, buttonPage3, buttonPage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonPage1 = findViewById(R.id.buttonPage1);
        buttonPage2 = findViewById(R.id.buttonPage2);
        buttonPage3 = findViewById(R.id.buttonPage3);
        buttonPage4 = findViewById(R.id.buttonPage4);

        buttonPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Page 1 activity
                startActivity(new Intent(HomeActivity.this, Page1Activity.class));
            }
        });

        buttonPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Page 2 activity
                startActivity(new Intent(HomeActivity.this, Page2Activity.class));
            }
        });

        buttonPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Page 3 activity
                startActivity(new Intent(HomeActivity.this, Page3Activity.class));
            }
        });

        buttonPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Page 4 activity
                startActivity(new Intent(HomeActivity.this, Page4Activity.class));
            }
        });
    }
}
