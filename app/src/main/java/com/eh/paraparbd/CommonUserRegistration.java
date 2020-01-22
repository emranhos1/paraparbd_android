package com.eh.paraparbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CommonUserRegistration extends AppCompatActivity {

	Button btnSignUpCU;
	Button btnLoginPage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_user_registration);

		btnSignUpCU = findViewById(R.id.btnSignUp);
		btnLoginPage = findViewById(R.id.btnLoginPage);


		//After Login page button press
		btnLoginPage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CommonUserRegistration.this, MainActivity.class);
				startActivity(intent);
			}
		});
		//After sign up button press
//		btnSignUpCU.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				String phoneNo = btnPhoneNo.getText().toString();
//				String password = btnPassword.getText().toString();

//				if (phoneNo.equals("01670932273") && password.equals("1234")) {
//					mySuccessToast();
//				} else {
//					myErrorToast();
//				}
//			}
//		});

	}
}
