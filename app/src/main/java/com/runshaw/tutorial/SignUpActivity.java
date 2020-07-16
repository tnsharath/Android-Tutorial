package com.runshaw.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText etPassword, etUserName, etUserID;

    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etPassword = findViewById(R.id.etPassword);
        etUserName = findViewById(R.id.etUserName);
        etUserID = findViewById(R.id.etUserID);

        sharedPref = new SharedPref(this);
    }

    public void confirm(View view) {

        String userName = etUserName.getText().toString();
        String userId = etUserID.getText().toString();
        String userPassword = etPassword.getText().toString();

        if (!userName.equals("") && !userId.equals("") && !userPassword.equals("")){
            sharedPref.setUserName(userName);
            sharedPref.setUserId(userId);
            sharedPref.setUserPassword(userPassword);
            Toast.makeText(this, "Sign up Successful!!!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_LONG).show();
        }
    }
}