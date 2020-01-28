package com.eh.paraparbd.classes;

import android.content.Context;
import android.util.Log;

import com.eh.paraparbd.Service.PBDApi;
import com.eh.paraparbd.commonuser.CommonUserDashboard;
import com.eh.paraparbd.model.LoginTable;
import com.eh.paraparbd.pojo.LoginCollection;
import com.eh.paraparbd.utils.AlertUtil;
import com.eh.paraparbd.utils.CustomAlertMessage;
import com.eh.paraparbd.utils.IntentUtil;
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
		loginTable.setPhoneNo(phoneNo);
		loginTable.setPassword(password);

		Call<LoginCollection> getInfo = pbdApi.userLogin(loginTable);
		getInfo.enqueue(new Callback<LoginCollection>() {
			@Override
			public void onResponse(Call<LoginCollection> call, Response<LoginCollection> response) {
				try {
					LoginCollection responseData = response.body();
					Log.d(TAG, "DATA :: " + responseData.getSuccess());
					if (responseData.getSuccess()) {
						LoginTable login = responseData.getData();

						IntentUtil.goToAnotherActivity(context, CommonUserDashboard.class);
						CustomAlertMessage.toastMessage(context, responseData.getMessage());
					} else {
						CustomAlertMessage.showCustomAlert(context, "LOGON FAILED",responseData.getMessage(), responseData.getSuccess());
					}
					AlertUtil.hideProgressDialog();
				} catch (Exception e) {
					Log.d(TAG, context +" : "+e);
					e.printStackTrace();
					AlertUtil.hideProgressDialog();
					AlertUtil.showAPInotResponseWarn(context);
				}
			}

			@Override
			public void onFailure(Call<LoginCollection> call, Throwable t) {
				Log.d(TAG, t.getMessage());
				//Hide Dialog
				AlertUtil.hideProgressDialog();
				AlertUtil.showAPInotResponseWarn(context);
			}
		});
	}
}
