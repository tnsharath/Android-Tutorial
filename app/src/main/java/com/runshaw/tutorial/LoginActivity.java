package com.runshaw.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {


    TextInputEditText etUserID, etUserPassword;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPref = new SharedPref(this);

        etUserID = findViewById(R.id.etUserID);
        etUserPassword = findViewById(R.id.etPassword);
    }

    public void login(View view) {
        String enteredUserID = etUserID.getText().toString();
        String enteredPassword = etUserPassword.getText().toString();

        String sharedPrefUserID = sharedPref.getUserId();
        String sharedPrefPassword = sharedPref.getUserPassword();


        if (enteredUserID.equals("") || enteredPassword.equals("")){
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_LONG).show();
            return;
        }

        if (enteredUserID.equals(sharedPrefUserID) && enteredPassword.equals(sharedPrefPassword)){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
        } else{
            Toast
                    .makeText(this, "UserID or Password Incorrect!! Please try again", Toast.LENGTH_LONG)
                    .show();
        }

    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}