package com.example.josemainstadam.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.josemainstadam.R;
import com.example.josemainstadam.db.DbHelper;

public class RegisterActivity extends AppCompatActivity {

    ImageButton gBack;
    EditText name;
    EditText email;
    EditText pw;

    DbHelper dbHelper;

    public RegisterActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        gBack = findViewById(R.id.backButton);
        name = findViewById(R.id.nameText);
        email = findViewById(R.id.emailText);
        pw = findViewById(R.id.pwRegisterText);
        Button submit = findViewById(R.id.submitButton);

        // method to comunicate with mainActivity and switch the activity.
        gBack.setOnClickListener(v -> {
            // looks like i can get back with the finish instead of creating a new intent.
            finish();
        });

        submit.setOnClickListener(v -> {
            String nameStr = name.getText().toString();
            String emailStr = email.getText().toString();
            String pwStr = pw.getText().toString();

            // validations:
            if (nameStr.isEmpty()) {
                name.setError("The name is required.");
            } else if (emailStr.isEmpty()) {
                email.setError("The email is required.");
            } else if (pwStr.isEmpty()) {
                pw.setError("The password is required.");
            } else if (pwStr.length() < 8) {
                pw.setError("The password must be at least 8 characters long.");
            } else {
                // we need to check if the user already exists.
                dbHelper = new DbHelper(this);
                if (dbHelper.checkUser(emailStr)) {
                    email.setError("The email is already registered.");
                    return;
                }
                // if everything is ok, we can create the user.
                dbHelper.insertBBDD(nameStr, pwStr);
                Toast.makeText(this, "User created successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}