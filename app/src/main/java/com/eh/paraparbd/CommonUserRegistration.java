package com.eh.paraparbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CommonUserRegistration extends AppCompatActivity {

    EditText firstNameText;
    EditText lastNameText;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText emailText;
    EditText phoneNoText;
    EditText addressText;
    EditText passwordText;

    Button btnSignUpCU;
    Button btnLoginPage;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_user_registration);

		firstNameText = findViewById(R.id.first_name);
        lastNameText = findViewById(R.id.last_name);
        emailText = findViewById(R.id.email);
        phoneNoText = findViewById(R.id.phone_no);
        addressText = findViewById(R.id.address);
        passwordText = findViewById(R.id.password);

		radioGroup = findViewById(R.id.gender_group);
		int radioButtonId = radioGroup.getCheckedRadioButtonId();
		radioButton = findViewById(radioButtonId);


		btnSignUpCU = findViewById(R.id.btnSignUp);
		btnLoginPage = findViewById(R.id.btnLoginPage);

		//After Registration button press
//        btnSignUpCU.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String firstName = firstNameText.getText().toString();
//                String lastName = lastNameText.getText().toString();
//                String email = emailText.getText().toString();
//                String phoneNo = phoneNoText.getText().toString();
//                String address = addressText.getText().toString();
//                String password = passwordText.getText().toString();
//
//                Toast.makeText(CommonUserRegistration.this, firstName, Toast.LENGTH_SHORT).show();
//                Toast.makeText(CommonUserRegistration.this, lastName, Toast.LENGTH_SHORT).show();
//                Toast.makeText(CommonUserRegistration.this, email, Toast.LENGTH_SHORT).show();
//                Toast.makeText(CommonUserRegistration.this, phoneNo, Toast.LENGTH_SHORT).show();
//                Toast.makeText(CommonUserRegistration.this, address, Toast.LENGTH_SHORT).show();
//                Toast.makeText(CommonUserRegistration.this, password, Toast.LENGTH_SHORT).show();
//                Toast.makeText(CommonUserRegistration.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
//
//            }
//        });

		//After Login page button press
		btnLoginPage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CommonUserRegistration.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
