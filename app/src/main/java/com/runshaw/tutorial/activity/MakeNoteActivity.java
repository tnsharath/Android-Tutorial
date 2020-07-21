package com.runshaw.tutorial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.runshaw.tutorial.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MakeNoteActivity extends AppCompatActivity {

    EditText etTitle, etDesc;
    Button btnSelectDate;
    Button btnSelectTime;
    String selectedDate = "";
    String selectedTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_note);

        etTitle = findViewById(R.id.etTitle);
        etDesc = findViewById(R.id.etDesc);
        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnSelectTime = findViewById(R.id.btnSelectTime);
    }

    public void selectDate(View view) {

        final Calendar c = Calendar.getInstance();

        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                selectedDate = dayOfMonth + "-" + month + "-" + year;
                btnSelectDate.setText(selectedDate);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void selectTime(View view){
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                selectedTime = hourOfDay +":" + minute;

                try {
                    final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
                    final Date date = sdf.parse(selectedTime);
                    selectedTime = new SimpleDateFormat("K:mm").format(date);
                }catch (ParseException e){
                    e.printStackTrace();
                }

                btnSelectTime.setText(selectedTime);
            }
        }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void submit(View view) {
        String title = etTitle.getText().toString();
        String desc = etDesc.getText().toString();
        if (!title.isEmpty() || !desc.isEmpty()){
            //TODO push data into database
        }
    }
}