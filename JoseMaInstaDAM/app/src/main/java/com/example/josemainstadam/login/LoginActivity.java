package com.example.josemainstadam.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.josemainstadam.MainActivity;
import com.example.josemainstadam.R;
import com.example.josemainstadam.db.DbHelper;

public class LoginActivity extends AppCompatActivity {


    Button loginButton;
    EditText userText;
    EditText pwText;

    DbHelper dbHelper;


    public LoginActivity() {
        // required empty constructor!
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView notRegisteredTextView = findViewById(R.id.notRegistered);
        loginButton = findViewById(R.id.loginButton);
        userText = findViewById(R.id.userText);
        pwText = findViewById(R.id.passwordText);

        // method to comunicate with mainActivity and switch the activity.
        // in case we want to register before login.
        notRegisteredTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerActivity);

            }
        });

        // method to handle the login button. Validations will be applied.
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userText.getText().toString();
                String password = pwText.getText().toString();

                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    dbHelper = new DbHelper(LoginActivity.this);
                    if (!dbHelper.checkUser(email)) {
                        userText.setError("The email is not registered.");
                        return;
                    }

                    Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(mainActivity);
                } else {
                    userText.setError("The address is not valid.");
                }

            }
        });


    }


}