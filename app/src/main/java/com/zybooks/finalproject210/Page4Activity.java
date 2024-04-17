package com.zybooks.finalproject210;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Page4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
    }

    public void onImageViewClick(View view) {
        // Determine which ImageView was clicked
        int viewId = view.getId();

        // Handle the click based on the ImageView's ID
        if (viewId == R.id.signOutImageView) {
            // Redirect to the log in activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (viewId == R.id.homeImageView) {
            // Redirect to the home activity
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
