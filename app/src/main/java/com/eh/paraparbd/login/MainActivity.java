package com.eh.paraparbd.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.eh.paraparbd.R;
import com.eh.paraparbd.classes.SignInfo;
import com.eh.paraparbd.utils.AlertUtil;
import com.eh.paraparbd.utils.PBDUtil;

public class MainActivity extends AppCompatActivity {

	Context context;
	EditText btnPhoneNo, btnPassword;
	Button btnLogin, btnSignUp;
	String phoneNo, password;
	final static String TAG = "MainActivity";

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
				Intent intent = new Intent(MainActivity.this, CommonUserRegistration.class);
				startActivity(intent);
			}
		});

		//Login Button Action
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNo = btnPhoneNo.getText().toString();
				password = btnPassword.getText().toString();
				Log.d(TAG, "Given Phone No"+ phoneNo);
				Log.d(TAG, "Given Password"+ password);

				if (!phoneNo.isEmpty()) {
					if (!password.isEmpty()) {
						if (PBDUtil.isInternetConnected(context)) {
							SignInfo.getLoginInfo(context, phoneNo, password);
						} else {
							String title = "No Internet Connection";
							String message = "Please check your internet connection";
							boolean status = false;
							AlertUtil.showAlartDialog(context, title, message, status);
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
