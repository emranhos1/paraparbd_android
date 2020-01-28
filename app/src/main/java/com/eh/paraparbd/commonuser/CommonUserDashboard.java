package com.eh.paraparbd.commonuser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.eh.paraparbd.R;
import com.eh.paraparbd.utils.CustomAlertMessage;

public class CommonUserDashboard extends AppCompatActivity {

	Context context;
	Button raidSharingBtn, rentACarBtn, eBusTicketingBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Set action bar
		getSupportActionBar().setTitle("Dashboard");
		setContentView(R.layout.activity_common_user_dashboard);

		context = CommonUserDashboard.this;
		raidSharingBtn = findViewById(R.id.raid_sharing);
		rentACarBtn = findViewById(R.id.rent_a_car);
		eBusTicketingBtn = findViewById(R.id.e_bus_ticketing);

		raidSharingBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String title = "NOT IN SERVICE";
				String message = "COMING SOON!";
				CustomAlertMessage.showCustomAlert(context, title, message, false);
			}
		});

		rentACarBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, RentACarBooking.class);
				startActivity(intent);
			}
		});

		eBusTicketingBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String title = "NOT IN SERVICE";
				String message = "COMING SOON!";
				CustomAlertMessage.showCustomAlert(context, title, message, false);
			}
		});
	}
}
