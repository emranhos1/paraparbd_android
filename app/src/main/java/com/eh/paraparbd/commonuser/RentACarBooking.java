package com.eh.paraparbd.commonuser;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.eh.paraparbd.classes.PlaceInfo;
import com.eh.paraparbd.model.DivisionTable;
import com.eh.paraparbd.utils.CustomAlertMessage;
import com.eh.paraparbd.utils.CustomSpinnerArrayAdapter;
import com.eh.paraparbd.utils.PBDUtil;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.List;

public class RentACarBooking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {


    Button btnDatePicker,btnSendRequest;
//    Button btnTimePicker;
    TextView dateText, timeText;
    EditText addressPickText, addressDropText, totalAmountText;
    String addressPickup, addressDrop, totalAmount, divisionName, divisionDropName;
    String districtName, districtDropName, policeStationName, policeStationDropName, carName;
    Context context;

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
            List<DivisionTable> responseData = PlaceInfo.getAllDivision(context);
//            for (int i = 0; i < responseData.size(); i++) {
//
//                String name = responseData.get(i).getDivisionName();
//                Log.d("Division Name :::::  ", name);
////                int id = responseData.get(i).getDivisionId();
//            }
        } else {
            CustomAlertMessage.showCustomAlert(context, "No Internet Connection", "Please check your internet connection", false);
        }

        //division
        ArrayAdapter<CharSequence> divisionAdapter = CustomSpinnerArrayAdapter.getAdapter(context, R.array.division);
        CustomSpinnerArrayAdapter.setSpinner(this, divisionSpinner, divisionAdapter);
        CustomSpinnerArrayAdapter.setSpinner(this, divisionDropSpinner, divisionAdapter);

        //district
        ArrayAdapter<CharSequence> districtAdapter = CustomSpinnerArrayAdapter.getAdapter(context, R.array.district);
        CustomSpinnerArrayAdapter.setSpinner(this, districtSpinner, districtAdapter);
        CustomSpinnerArrayAdapter.setSpinner(this, districtDropSpinner, districtAdapter);

        //police station
        ArrayAdapter<CharSequence> policeStationAdapter = CustomSpinnerArrayAdapter.getAdapter(context, R.array.policeStation);
        CustomSpinnerArrayAdapter.setSpinner(this, policeStationSpinner, policeStationAdapter);
        CustomSpinnerArrayAdapter.setSpinner(this, policeStationDropSpinner, policeStationAdapter);

        //car
        ArrayAdapter<CharSequence> carAdapter = CustomSpinnerArrayAdapter.getAdapter(context, R.array.car);
        CustomSpinnerArrayAdapter.setSpinner(this, carSpinner, carAdapter);

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
