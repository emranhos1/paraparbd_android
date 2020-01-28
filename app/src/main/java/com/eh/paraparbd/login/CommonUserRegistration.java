package com.eh.paraparbd.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.eh.paraparbd.R;
import com.eh.paraparbd.utils.CustomAlertMessage;
import com.eh.paraparbd.classes.Registration;
import com.eh.paraparbd.model.CommonUserRegTable;
import com.eh.paraparbd.utils.IntentUtil;
import com.eh.paraparbd.utils.PBDUtil;

public class CommonUserRegistration extends AppCompatActivity {

	Context context;
	EditText firstNameText, lastNameText, emailText, phoneNoText, addressText, passwordText;
	RadioGroup radioGroup;
	Button btnSignUpCU, btnLoginPage;
	private String gender;
	int radioButtonId;
	CommonUserRegTable commonUserRegTable = new CommonUserRegTable();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = CommonUserRegistration.this;
		setContentView(R.layout.activity_common_user_registration);

		firstNameText = findViewById(R.id.first_name);
		lastNameText = findViewById(R.id.last_name);
		emailText = findViewById(R.id.email);
		phoneNoText = findViewById(R.id.phone_no);
		addressText = findViewById(R.id.address);
		passwordText = findViewById(R.id.password);
		radioGroup = findViewById(R.id.gender_group);
		radioButtonId = radioGroup.getCheckedRadioButtonId();

		btnSignUpCU = findViewById(R.id.btnSignUpCU);
		btnLoginPage = findViewById(R.id.btnLoginPage);

		//After Registration button press
		btnSignUpCU.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (firstNameText.length() != 0) {
					if (lastNameText.length() != 0) {
						if(radioGroup.getCheckedRadioButtonId() != -1){
							if(radioGroup.getCheckedRadioButtonId() == R.id.gender_male) {
								gender = "Male";
							} else {
								gender = "Female";
							}
							if (emailText.length() != 0) {
								if (phoneNoText.length() != 0) {
									if (addressText.length() != 0) {
										if (passwordText.length() != 0) {
											if (PBDUtil.isInternetConnected(context)) {
												String firstName = firstNameText.getText().toString();
												String lastName = lastNameText.getText().toString();
												String email = emailText.getText().toString();
												String phoneNo = phoneNoText.getText().toString();
												String address = addressText.getText().toString();
												String password = passwordText.getText().toString();

												commonUserRegTable.setFirstName(firstName);
												commonUserRegTable.setLastName(lastName);
												commonUserRegTable.setGender(gender);
												commonUserRegTable.setEmail(email);
												commonUserRegTable.setPhoneNo(phoneNo);
												commonUserRegTable.setAddress(address);
												commonUserRegTable.setPassword(password);
												commonUserRegTable.setRandomCode("1234");
												commonUserRegTable.setDeviceImeNo("");
												commonUserRegTable.setDeviceLocation("");
												commonUserRegTable.setDeviceIp("");

												Registration.commonUserRegistration(context, commonUserRegTable);
											} else {
												String title = "NO INTERNET CONNECTION";
												String message = "Please check your internet connection";
												boolean status = false;
												CustomAlertMessage.showCustomAlert(context, title, message, status);
											}
										} else {
											passwordText.setError("Password Should Not Be Blank");
										}
									} else {
										addressText.setError("Address Should Not Be Blank");
									}
								} else {
									phoneNoText.setError("Phone No Should Not Be Blank");
								}
							} else {
								emailText.setError("Email Should Not Be Blank");
							}
						} else {
							CustomAlertMessage.toastMessage(context, "Please Select Gender");
						}
					} else {
						lastNameText.setError("Last Name Should Not Be Blank");
					}
				} else {
					firstNameText.setError("First Name Should Not Be Blank");
				}
			}
		});

		//After Login page button press
		btnLoginPage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				IntentUtil.goToAnotherActivity(context, MainActivity.class);
			}
		});
	}
}
