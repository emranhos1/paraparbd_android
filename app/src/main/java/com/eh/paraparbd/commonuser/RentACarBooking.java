package com.eh.paraparbd.commonuser;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.eh.paraparbd.R;
import com.eh.paraparbd.classes.CarModelInfo;
import com.eh.paraparbd.classes.PlaceInfo;
import com.eh.paraparbd.utils.CustomAlertMessage;
import com.eh.paraparbd.utils.PBDUtil;

import java.util.ArrayList;
import java.util.Calendar;

public class RentACarBooking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {


    Button btnDatePicker,btnSendRequest;
//    Button btnTimePicker;
    TextView dateText;
//    TextView timeText;
    EditText addressPickText, addressDropText, totalAmountText;
    String addressPickup, addressDrop, totalAmount, divisionName, divisionDropName;
    String districtName, districtDropName, policeStationName, policeStationDropName, carName;
    Context context;
    ArrayList<String> responseData;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = RentACarBooking.this;

        getSupportActionBar().setTitle("Rent A Car Booking");
        setContentView(R.layout.activity_rent_acar_booking);

        final Spinner divisionSpinner = findViewById(R.id.spinner_division);
        final Spinner divisionDropSpinner = findViewById(R.id.spinner_drop_division);
        final Spinner districtSpinner = findViewById(R.id.spinner_district);
        final Spinner districtDropSpinner = findViewById(R.id.spinner_drop_district);
        final Spinner policeStationSpinner = findViewById(R.id.spinner_police_station);
        final Spinner policeStationDropSpinner = findViewById(R.id.spinner_drop_police_station);
        final Spinner carSpinner = findViewById(R.id.spinner_car);
        addressPickText = findViewById(R.id.pickup_address);
        addressDropText = findViewById(R.id.drop_address);
        totalAmountText = findViewById(R.id.total_amount);

        if (PBDUtil.isInternetConnected(context)) {

            responseData = PlaceInfo.getAllDivision(context);
            adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, responseData);
            divisionSpinner.setAdapter(adapter);
            divisionDropSpinner.setAdapter(adapter);

            responseData = PlaceInfo.getAllDistrict(context);
            adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, responseData);
            districtSpinner.setAdapter(adapter);
            districtDropSpinner.setAdapter(adapter);

            responseData = PlaceInfo.getAllPoliceStation(context);
            adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, responseData);
            policeStationSpinner.setAdapter(adapter);
            policeStationDropSpinner.setAdapter(adapter);

            responseData = CarModelInfo.getAllCarModel(context);
            adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, responseData);
            carSpinner.setAdapter(adapter);
        } else {
            CustomAlertMessage.showCustomAlert(context, "No Internet Connection", "Please check your internet connection", false);
        }

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

        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divisionName = divisionSpinner.getSelectedItem().toString();
                divisionDropName = divisionDropSpinner.getSelectedItem().toString();
                districtName = districtSpinner.getSelectedItem().toString();
                districtDropName = districtDropSpinner.getSelectedItem().toString();
                policeStationName = policeStationSpinner.getSelectedItem().toString();
                policeStationDropName = policeStationDropSpinner.getSelectedItem().toString();
                carName = carSpinner.getSelectedItem().toString();
                addressPickup = addressPickText.getText().toString();
                addressDrop = addressDropText.getText().toString();
                totalAmount = totalAmountText.getText().toString();
                String message = ""+divisionName+" "+divisionDropName+" "+districtName
                        +" "+districtDropName+" "+policeStationName+" "+policeStationDropName+" "+carName
                        +" "+addressPickup+" "+addressDrop+" "+totalAmount;

                CustomAlertMessage.showCustomAlert(context, "Division", message, true);
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
