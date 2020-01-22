package com.eh.paraparbd;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	EditText btnPhoneNo;
	EditText btnPassword;
	Button btnLogin;
	Button btnSignUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Set action bar
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		//getSupportActionBar().setLogo(R.drawable.parapar);
		getSupportActionBar().setDisplayUseLogoEnabled(true);
		//getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setTitle("");
		setContentView(R.layout.activity_main);

		btnPhoneNo = findViewById(R.id.phone_no);
		btnPassword = findViewById(R.id.password);
		btnLogin = findViewById(R.id.btnLogin);
		btnSignUp = findViewById(R.id.btnSignUp);

		//After login button press
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String phoneNo = btnPhoneNo.getText().toString();
				String password = btnPassword.getText().toString();

				if (phoneNo.equals("01670932273") && password.equals("1234")) {
					mySuccessToast();
				} else {
					myErrorToast();
				}
			}
		});

		//After sign up button press
		btnSignUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CommonUserRegistration.class);
				startActivity(intent);
			}
		});
	}

	//Custom Toast for Success
	public void mySuccessToast(){

		LayoutInflater layoutInflater = getLayoutInflater();
		View viewLayout = layoutInflater.inflate(R.layout.custom_toast_success, (ViewGroup) findViewById(R.id.customToastSuccessId));

		Toast toast = new Toast(getApplicationContext());

		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setView(viewLayout);
		toast.show();
	}

	//Custom Toast for Error
	public void myErrorToast(){

		LayoutInflater layoutInflater = getLayoutInflater();
		View viewLayout = layoutInflater.inflate(R.layout.custom_toast_error, (ViewGroup) findViewById(R.id.customToastErrorId));

		Toast toast = new Toast(getApplicationContext());

		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setView(viewLayout);
		toast.show();
	}
}
