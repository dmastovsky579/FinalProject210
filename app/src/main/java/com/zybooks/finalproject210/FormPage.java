package com.zybooks.finalproject210;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;

public class FormPage extends AppCompatActivity {
    private EditText editTextName, editTextEmail, editTextImprovement, editTextMealRequest;
    private RatingBar ratingDining;
    private TextView textViewFeedbackRecorded, textViewLastRecord;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_page);

        dbHelper = new DatabaseHelper(this);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextImprovement = findViewById(R.id.editTextImprovement);
        editTextMealRequest = findViewById(R.id.editTextMealRequest);
        ratingDining = findViewById(R.id.ratingDining);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        Button buttonLastRecord = findViewById(R.id.buttonLastRecord);
        textViewFeedbackRecorded = findViewById(R.id.textViewFeedbackRecorded);
        textViewLastRecord = findViewById(R.id.textViewLastRecord);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFormData();
                textViewFeedbackRecorded.setText("Your feedback has been recorded.");
                textViewFeedbackRecorded.setVisibility(View.VISIBLE);
            }
        });

        buttonLastRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLastRecord();
            }
        });
    }

    private void saveFormData() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        int rating = (int) ratingDining.getRating();
        String improvement = editTextImprovement.getText().toString().trim();
        String mealRequest = editTextMealRequest.getText().toString().trim();
        dbHelper.addFormData(name, email, rating, improvement, mealRequest);
        Toast.makeText(this, "Data Submitted", Toast.LENGTH_SHORT).show();
    }

    private void getLastRecord() {
        Cursor cursor = dbHelper.getLastRecord();
        if (cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL));
            int rating = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_RATING));
            String improvement = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_IMPROVEMENT));
            String mealRequest = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEAL_REQUEST));

            String displayText = "Last Record:\n" +
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Rating: " + rating + "\n" +
                    "Improvement: " + improvement + "\n" +
                    "Meal Request: " + mealRequest;
            textViewLastRecord.setText(displayText);
            textViewLastRecord.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "No records found.", Toast.LENGTH_SHORT).show();
        }
        if (cursor != null) {
            cursor.close();
        }
    }

}
