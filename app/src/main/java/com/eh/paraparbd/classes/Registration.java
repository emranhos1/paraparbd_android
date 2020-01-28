package com.eh.paraparbd.classes;

import android.content.Context;
import android.util.Log;

import com.eh.paraparbd.Service.PBDApi;
import com.eh.paraparbd.model.CommonUserRegTable;
import com.eh.paraparbd.pojo.CommonUserRegCollection;
import com.eh.paraparbd.utils.AlertUtil;
import com.eh.paraparbd.utils.CustomAlertMessage;
import com.eh.paraparbd.utils.PBDUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration {

	private static PBDApi pbdApi = PBDUtil.webserviceInitialize();
	private final static String TAG = "Registration";
	static CommonUserRegTable regTable = new CommonUserRegTable();

	public static void commonUserRegistration(final Context context, CommonUserRegTable commonUserRegTable) {
		AlertUtil.showProgressDialog(context);
		Call<CommonUserRegCollection> getInfo = pbdApi.commonUserRegistration(commonUserRegTable);
		getInfo.enqueue(new Callback<CommonUserRegCollection>() {
			@Override
			public void onResponse(Call<CommonUserRegCollection> call, Response<CommonUserRegCollection> response) {
				try {
					CommonUserRegCollection responseData = response.body();
					Log.d(TAG, "Registration Response DATA :: " + responseData.getSuccess());
					if (responseData.getSuccess()) {
						regTable = responseData.getData();
					} else {
						regTable = null;
					}

					CustomAlertMessage.showCustomAlert(context, responseData.getSuccess() ? "SUCCESS" : "FAILED", responseData.getMessage(), responseData.getSuccess());
					AlertUtil.hideProgressDialog();
				} catch (Exception e) {
					Log.e(TAG, context +" : "+e);
					e.printStackTrace();
					AlertUtil.hideProgressDialog();
					AlertUtil.showAPInotResponseWarn(context);
				}
			}

			@Override
			public void onFailure(Call<CommonUserRegCollection> call, Throwable t) {
				Log.d(TAG, t.getMessage());
				//Hide Dialog
				AlertUtil.hideProgressDialog();
				AlertUtil.showAPInotResponseWarn(context);
			}
		});
	}
}
