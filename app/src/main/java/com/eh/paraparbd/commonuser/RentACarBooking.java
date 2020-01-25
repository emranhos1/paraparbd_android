package com.eh.paraparbd.commonuser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.eh.paraparbd.R;

import java.text.DateFormat;
import java.util.Calendar;

public class RentACarBooking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    Button btnDatePicker,btnSendRequest;
//    Button btnTimePicker;
    TextView dateText, timeText;

    final static String TAG = "RentACarBooking";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Rent A Car Booking");
        setContentView(R.layout.activity_rent_acar_booking);

        btnDatePicker = findViewById(R.id.date_picker);
        btnSendRequest = findViewById(R.id.btn_send_request);

        dateText = findViewById(R.id.date_text);

//        btnTimePicker = findViewById(R.id.time_picker);
//        timeText = findViewById(R.id.time_text);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDailog();
            }
        });

//        btnTimePicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showTimePickerDailog();
//            }
//        });
    }

    private void showDatePickerDailog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.ERA),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth +"/"+ month +"/"+ year;
        dateText.setText(date);
    }

//    private void showTimePickerDailog(){
//        TimePickerDialog timePickerDialog = new TimePickerDialog(
//                this,
//                this,
//                Calendar.getInstance().get(Calendar.HOUR),
//                Calendar.getInstance().get(Calendar.MINUTE),
//                DateFormat.is24HourFormat(getContext())
//        );
//        timePickerDialog.show();

//    }

//    @Override
//    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//    }
}
