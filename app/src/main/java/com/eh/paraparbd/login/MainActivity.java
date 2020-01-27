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
import com.eh.paraparbd.Service.PBDApi;
import com.eh.paraparbd.commonuser.CommonUserDashboard;
import com.eh.paraparbd.model.LoginTable;
import com.eh.paraparbd.pojo.LoginCollection;
import com.eh.paraparbd.utils.AlartUtil;
import com.eh.paraparbd.utils.PBDUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	Context context;

	EditText btnPhoneNo, btnPassword;
	Button btnLogin, btnSignUp;
	String phoneNo, password;

	final static String TAG = "MainActivity";

	private static LoginTable loginTable = new LoginTable();
	private static PBDApi pbdApi = PBDUtil.webserviceInitialize();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		context = MainActivity.this;
		super.onCreate(savedInstanceState);

		//Set action bar
		//getSupportActionBar().setLogo(R.drawable.parapar);
		//getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayUseLogoEnabled(true);
		getSupportActionBar().setTitle("");
		setContentView(R.layout.activity_main);

		btnPhoneNo = findViewById(R.id.phone_no);
		btnPassword = findViewById(R.id.password);
		btnLogin = findViewById(R.id.btnLogin);
		btnSignUp = findViewById(R.id.btnSignUp);

		//After sign up button press
		btnSignUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CommonUserRegistration.class);
				startActivity(intent);
			}
		});

		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNo = btnPhoneNo.getText().toString();
				password = btnPassword.getText().toString();

				Log.d(TAG, phoneNo);
				Log.d(TAG, password);

				if(!phoneNo.isEmpty()){
					if(!password.isEmpty()){

//						AlartUtil.showAlartDialog(context, "Success", "Login Successful!!", true);
//						Toast.makeText(context, "Phone No :"+phoneNo, Toast.LENGTH_SHORT).show();
//						Toast.makeText(context, "Password :"+password, Toast.LENGTH_SHORT).show();
//						if (phoneNo.equals("01670932273") && password.equals("1234")) {

//							Intent intent = new Intent(MainActivity.this, CommonUserDashboard.class);
//							startActivity(intent);
//							finish();

//						} else {
//							Toast.makeText(context, "Not Match", Toast.LENGTH_SHORT).show();
//						}
						if(PBDUtil.isInternetConnected(context) == true){
							getLoginInfo(context, phoneNo, password);

						} else {
							String title = "No Internet Connection";
							String message = "Please check your internet connection";
							boolean status = false;
//							AlartUtil.showAlartDialog(context, title, message, status);
						}
					} else{
						btnPassword.setError("Password Should Not Be Blank");
					}
				} else {
					btnPhoneNo.setError("UserId Should Not Be Blank");
				}
			}
		});

	}

	public void getLoginInfo (final Context context, String phoneNo, String password){
//		AlartUtil.showProgressDialog(context);
		Log.d(TAG, "user phone and pass :: " + phoneNo+" "+password);
		loginTable.setPhoneNo(phoneNo);
		loginTable.setPassword(password);

		Call<LoginCollection> getInfo = pbdApi.userLogin(loginTable);
		getInfo.enqueue(new Callback<LoginCollection>() {
			@Override
			public void onResponse(Call<LoginCollection> call, Response<LoginCollection> response) {

				try {
					LoginCollection responseData =  response.body();
					Log.d(TAG, "DATA :: " + responseData.getSuccess());
					if(responseData.getSuccess()){
						LoginTable login = responseData.getData();
						Log.d(TAG, "AllUser Id :: " + login.getAllUserId());
						Log.d(TAG, "Active status :: " + login.getActiveStatus());
						Log.d(TAG, "Role :: " + login.getUserRole());
//						//now go to welcome activity
//						Intent welcomeIntent = new Intent(context, CommonUserDashboard.class);
//						//welcomeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//						welcomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//						welcomeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//						welcomeIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//						startActivity(welcomeIntent);

						Intent intent = new Intent(context, CommonUserDashboard.class);
						startActivity(intent);
						finish();
						Log.d(TAG,"Login success!!!##############################");
					}
//					AlartUtil.hideProgressDialog();
				} catch (Exception e){
					Log.d(TAG,"list is null");
					e.printStackTrace();
//					AlartUtil.hideProgressDialog();
//					AlartUtil.showAPInotResponseWarn(context);
				}
			}

			@Override
			public void onFailure(Call<LoginCollection> call, Throwable t) {
				Log.d(TAG,t.getMessage());
				//Hide Dialog
//				AlartUtil.hideProgressDialog();
//				AlartUtil.showAPInotResponseWarn(context);
			}
		});
	}
}
