package com.eh.paraparbd.commonuser;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.eh.paraparbd.R;
import com.eh.paraparbd.utils.CustomAlertMessage;
import com.eh.paraparbd.utils.CustomSpinnerArrayAdapter;

import java.util.Calendar;

public class RentACarBooking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {


    Button btnDatePicker,btnSendRequest;
//    Button btnTimePicker;
    TextView dateText, timeText;
    Context context;

    final static String TAG = "RentACarBooking";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = RentACarBooking.this;

        getSupportActionBar().setTitle("Rent A Car Booking");
        setContentView(R.layout.activity_rent_acar_booking);

        Spinner divisionSpinner = findViewById(R.id.spinner_division);
        Spinner districtSpinner = findViewById(R.id.spinner_district);
        Spinner policeStationSpinner = findViewById(R.id.spinner_police_station);

        //division
        ArrayAdapter<CharSequence> divisionAdapter = CustomSpinnerArrayAdapter.getAdapter(context, R.array.division);
        CustomSpinnerArrayAdapter.setSpinner(this, divisionSpinner, divisionAdapter);

        //district
        ArrayAdapter<CharSequence> districtAdapter = CustomSpinnerArrayAdapter.getAdapter(context, R.array.district);
        CustomSpinnerArrayAdapter.setSpinner(this, districtSpinner, districtAdapter);

        //police station
        ArrayAdapter<CharSequence> policeStationAdapter = CustomSpinnerArrayAdapter.getAdapter(context, R.array.policeStation);
        CustomSpinnerArrayAdapter.setSpinner(this, policeStationSpinner, policeStationAdapter);

        btnDatePicker = findViewById(R.id.date_picker);
        btnSendRequest = findViewById(R.id.btn_send_request);

        dateText = findViewById(R.id.date_text);

        //btnTimePicker = findViewById(R.id.time_picker);
        //timeText = findViewById(R.id.time_text);
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDailog();
            }
        });
        //btnTimePicker.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        showTimePickerDailog();
        //    }
        //});
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = parent.getItemAtPosition(position).toString();
        CustomAlertMessage.toastMessage(context, message);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
