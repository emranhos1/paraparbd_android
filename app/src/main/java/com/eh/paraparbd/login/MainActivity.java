package com.eh.paraparbd.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.eh.paraparbd.R;
import com.eh.paraparbd.utils.CustomAlertMessage;
import com.eh.paraparbd.classes.SignInfo;
import com.eh.paraparbd.utils.IntentUtil;
import com.eh.paraparbd.utils.PBDUtil;

public class MainActivity extends AppCompatActivity {

	Context context;
	EditText btnPhoneNo, btnPassword;
	Button btnLogin, btnSignUp;
	String phoneNo, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getSupportActionBar().setTitle("");
		setContentView(R.layout.activity_main);

		context = MainActivity.this;
		btnPhoneNo = findViewById(R.id.phone_no);
		btnPassword = findViewById(R.id.password);
		btnLogin = findViewById(R.id.btnLogin);
		btnSignUp = findViewById(R.id.btnSignUp);

		//Sign up button Action
		btnSignUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				IntentUtil.goToAnotherActivity(context, CommonUserRegistration.class);
			}
		});

		//Login Button Action
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNo = btnPhoneNo.getText().toString();
				password = btnPassword.getText().toString();

				if (!phoneNo.isEmpty()) {
					if (!password.isEmpty()) {
						if (PBDUtil.isInternetConnected(context)) {
							SignInfo.getLoginInfo(context, phoneNo, password);
						} else {
							String title = "NO INTERNET CONNECTION";
							String message = "Please check your internet connection";
							boolean status = false;
							CustomAlertMessage.showCustomAlert(context, title, message, status);
						}
					} else {
						btnPassword.setError("Password Should Not Be Blank");
					}
				} else {
					btnPhoneNo.setError("UserId Should Not Be Blank");
				}
			}
		});
	}
}
