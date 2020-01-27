package com.eh.paraparbd.classes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.eh.paraparbd.Service.PBDApi;
import com.eh.paraparbd.commonuser.CommonUserDashboard;
import com.eh.paraparbd.model.LoginTable;
import com.eh.paraparbd.pojo.JsonCollection;
import com.eh.paraparbd.utils.AlertUtil;
import com.eh.paraparbd.utils.PBDUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInfo {
	private static LoginTable loginTable = new LoginTable();
	private static PBDApi pbdApi = PBDUtil.webserviceInitialize();
	private final static String TAG = "SignInfo";

	public static void getLoginInfo(final Context context, String phoneNo, String password) {
		AlertUtil.showProgressDialog(context);
		Log.d(TAG, "user phone and pass :: " + phoneNo + " " + password);
		loginTable.setPhoneNo(phoneNo);
		loginTable.setPassword(password);

		Call<JsonCollection> getInfo = pbdApi.userLogin(loginTable);
		getInfo.enqueue(new Callback<JsonCollection>() {

			@Override
			public void onResponse(Call<JsonCollection> call, Response<JsonCollection> response) {

				try {
					JsonCollection responseData = response.body();
					Log.d(TAG, "DATA :: " + responseData.getSuccess());
					if (responseData.getSuccess()) {
						LoginTable login = responseData.getData();
						Log.d(TAG, "AllUser Id :: " + login.getAllUserId());
						Log.d(TAG, "Active status :: " + login.getActiveStatus());
						Log.d(TAG, "Role :: " + login.getUserRole());

						Intent intent = new Intent(context, CommonUserDashboard.class);
						context.startActivity(intent);
						Toast.makeText(context, responseData.getMessage(), Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(context, responseData.getMessage(), Toast.LENGTH_SHORT).show();
					}
					AlertUtil.hideProgressDialog();
				} catch (Exception e) {
					Log.d(TAG, "list is null");
					e.printStackTrace();
					AlertUtil.hideProgressDialog();
					AlertUtil.showAPInotResponseWarn(context);
				}
			}

			@Override
			public void onFailure(Call<JsonCollection> call, Throwable t) {
				Log.d(TAG, t.getMessage());
				//Hide Dialog
				AlertUtil.hideProgressDialog();
				AlertUtil.showAPInotResponseWarn(context);
			}
		});
	}
}
