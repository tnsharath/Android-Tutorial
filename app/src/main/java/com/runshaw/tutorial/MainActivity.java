package com.runshaw.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        String text = "This is the first coding session";

        textView.setText(text);

        editText = findViewById(R.id.editTextTextPersonName);
        tvResult = findViewById(R.id.tvResult);

        Button btnSubmit = findViewById(R.id.btnSubmit);

        //Do get text and show it in result on click of button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                tvResult.setText(name);
            }
        });
    }

    /**
     * This is to perform onclick
     * @param view buttonview
     */
    /*public void submit(View view) {
            String name = editText.getText().toString();
            tvResult.setText(name);
    }*/

}