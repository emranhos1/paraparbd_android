package com.eh.paraparbd.classes;

import android.content.Context;
import android.util.Log;

import com.eh.paraparbd.Service.PBDApi;
import com.eh.paraparbd.model.CommonUserRegTable;
import com.eh.paraparbd.pojo.JsonCollection;
import com.eh.paraparbd.utils.AlertUtil;
import com.eh.paraparbd.utils.PBDUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration {

	private static PBDApi pbdApi = PBDUtil.webserviceInitialize();
	private final static String TAG = "Registration";

	public static void commonUserRegistration(Context context, CommonUserRegTable commonUserRegTable) {
		AlertUtil.showProgressDialog(context);
		//TODO
		//FIXME
		Call<JsonCollection> getInfo = pbdApi.commonUserRegistration(commonUserRegTable);
		getInfo.enqueue(new Callback<JsonCollection>() {
			@Override
			public void onResponse(Call<JsonCollection> call, Response<JsonCollection> response) {
				JsonCollection responseData = response.body();
				Log.d(TAG, "Registration Response DATA :: " + responseData.getSuccess());
			}

			@Override
			public void onFailure(Call<JsonCollection> call, Throwable t) {

			}
		});
	}
}
