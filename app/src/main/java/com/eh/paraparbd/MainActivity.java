package com.eh.paraparbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	EditText btnPhoneNo;
	EditText btnPassword;
	Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnPhoneNo = findViewById(R.id.phone_no);
		btnPassword = findViewById(R.id.password);
		btnLogin = findViewById(R.id.btnLogin);

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
	}

	public void mySuccessToast(){

		LayoutInflater layoutInflater = getLayoutInflater();
		View viewLayout = layoutInflater.inflate(R.layout.custom_toast_success, (ViewGroup) findViewById(R.id.customToastSuccessId));

		Toast toast = new Toast(getApplicationContext());

		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setView(viewLayout);
		toast.show();
	}

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
