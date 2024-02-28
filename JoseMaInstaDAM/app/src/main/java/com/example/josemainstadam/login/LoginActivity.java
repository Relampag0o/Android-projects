package com.example.josemainstadam.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.josemainstadam.MainActivity;
import com.example.josemainstadam.R;
import com.example.josemainstadam.db.DbHelper;

public class LoginActivity extends AppCompatActivity {


    Button loginButton;
    EditText userText;
    EditText pwText;

    DbHelper dbHelper;

    CheckBox keepMeSignedIn;

    private String email;
    private String password;


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
        keepMeSignedIn = findViewById(R.id.keepMeSignedIn);
        recoverSharedPreferences();


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
                    Log.d("LOGIN", "onClick: " + email + " " + password);
                    if (!dbHelper.checkUser(email) || !dbHelper.checkPasswd(email, password)) {
                        Toast.makeText(LoginActivity.this, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // CODE TO KEEP THE USER LOGGED IN
                    if (keepMeSignedIn.isChecked()) {
                        SharedPreferences sharedPref = getSharedPreferences("LoginData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.apply();
                    }


                    // CODE TO SWITCH TO MAIN ACTIVITY
                    Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(mainActivity);
                } else {
                    Toast.makeText(LoginActivity.this, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    // METHOD TO RECOVER EMAIL AND PW FROM SHARED PREFERENCES
    public void recoverSharedPreferences() {
        SharedPreferences sharedPref = getSharedPreferences("LoginData", Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", "");
        String password = sharedPref.getString("password", "");
        if (!email.equals("") && !password.equals("")) {
            userText.setText(email);
            pwText.setText(password);
        }
    }


}