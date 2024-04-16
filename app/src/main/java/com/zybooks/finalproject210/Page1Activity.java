package com.zybooks.finalproject210;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Page1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        // Find the button by its ID
        Button buttonToForm = findViewById(R.id.buttonFeedback);

        // Set an OnClickListener to the button
        buttonToForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start FormPage
                Intent intent = new Intent(Page1Activity.this, FormPage.class);
                startActivity(intent);
            }
        });
    }
}
