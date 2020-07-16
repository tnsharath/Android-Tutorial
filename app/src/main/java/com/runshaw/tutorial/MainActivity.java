package com.runshaw.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView tvResult;
    DatePicker datePicker;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        String text = "This is the first coding session";

        textView.setText(text);

        editText = findViewById(R.id.editTextTextPersonName);
        tvResult = findViewById(R.id.tvResult);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        //Do get text and show it in result on click of button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                tvResult.setText(name);
            }
        });

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Toggle button clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void radioButtonSelected(View view) {
        Boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.btnPizza:
                // Button Pizza clicked
                if (checked) {
                    Toast.makeText(this, "I love Pizza", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnBurger:
                // Button Burger clicked
                if (checked) {
                    Toast.makeText(this, "I love Burger", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public void checkBoxSelected(View view) {
        Boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.cbDark:
                //  WE like Dark Series
                if (checked){
                    Toast.makeText(this, "I Like Dark", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "I dont like Dark", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.cbGOT:
                // WE like Got
                if (checked){
                    Toast.makeText(this, "I Like GOT", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "I dont like GOT", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.cbMoneyHeist:
                // WE like Money Heist
                if (checked){
                    Toast.makeText(this, "I Like Money Heist", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "I dont like Money Heist", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public void selectDate(View view) {
        String selectedDate = datePicker.getDayOfMonth()
                + "/" + datePicker.getMonth() +"/" + datePicker.getYear();
        Toast.makeText(this, selectedDate, Toast.LENGTH_LONG).show();
    }

    public void selectTime(View view) {
        String selectedTime = timePicker.getHour() + ":" + timePicker.getMinute();
        Toast.makeText(this, selectedTime, Toast.LENGTH_LONG).show();
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void goToRelativeLayout(View view) {
        Intent intent = new Intent(this, RelativeLayoutExampleActivity.class);
        startActivity(intent);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
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