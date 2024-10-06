package com.example.CS2340FAC_Team41.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.CS2340FAC_Team41.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        etUsername = findViewById(R.id.edit_username);
        etPassword = findViewById(R.id.edit_password);
        errorMessage = findViewById(R.id.txt_error_message);
        Button loginButton = findViewById(R.id.btn_login);

        // Login button - takes user to HomeActivity after successful login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input from the EditText fields
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Validate input
                if (isValidInput(username, password)) {
                    // If input is valid, proceed with login
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Close LoginActivity
                } else {
                    // If input is invalid, show error message
                    errorMessage.setVisibility(View.VISIBLE);
                }
            }
        });

        // Create Account button - takes user to SignupActivity
        findViewById(R.id.btn_create_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    // Helper function to validate input
    private boolean isValidInput(String username, String password) {
        // Check if username or password is empty or contains only whitespace
        if (username.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true; // Input is valid
    }
}