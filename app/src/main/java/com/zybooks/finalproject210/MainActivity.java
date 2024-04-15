package com.zybooks.finalproject210;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// LoginActivity.java
public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Check if the username and password match your criteria
                if (isValidCredentials(username, password)) {
                    // Authentication successful, navigate to HomeActivity
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Authentication failed, show error message or handle accordingly
                    // For example, display a Toast message indicating invalid credentials
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to validate username and password
    private boolean isValidCredentials(String username, String password) {
        // Here you can implement your own logic for authentication
        // For simplicity, let's assume there's a hardcoded username and password
        String validUsername = "example";
        String validPassword = "password";

        // Compare input username and password with valid credentials
        return username.equals(validUsername) && password.equals(validPassword);
    }
}
