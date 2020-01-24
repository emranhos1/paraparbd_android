package com.eh.paraparbd.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.eh.paraparbd.Service.PBDApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PBDUtil {

    final static String TAG = "PBDUtil";

    public static boolean isInternetConnected(Context context){

        boolean isConnected;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            isConnected = true;
        } else {
            isConnected = false;
        }
        return isConnected;
    }

    public static PBDApi webserviceInitialize() {
        PBDApi pbdApi;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PBDUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pbdApi = retrofit.create(PBDApi.class);
        return pbdApi;
    }
}
