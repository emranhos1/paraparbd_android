package com.eh.paraparbd.classes;

import android.content.Context;
import android.util.Log;

import com.eh.paraparbd.Service.PBDApi;
import com.eh.paraparbd.model.DivisionTable;
import com.eh.paraparbd.pojo.DivisionCollection;
import com.eh.paraparbd.utils.AlertUtil;
import com.eh.paraparbd.utils.PBDUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceInfo {

    private static PBDApi pbdApi = PBDUtil.webserviceInitialize();
    private static List<DivisionTable> responseData;

    public static List<DivisionTable> getAllDivision(final Context context) {
        AlertUtil.showProgressDialog(context);

        Call<DivisionCollection> getDivision = pbdApi.getAllDivision();
        getDivision.enqueue(new Callback<DivisionCollection>() {
            @Override
            public void onResponse(Call<DivisionCollection> call, Response<DivisionCollection> response) {
                try {
                    DivisionCollection responseCollection = response.body();
                    if(responseCollection.getSuccess()){
                        responseData = responseCollection.getData();
                        for (int i = 0; i < responseData.size(); i++) {

                            String name = responseData.get(i).getDivisionName();
                            Log.d("Division Name :::::  ", name);
                        }
                        AlertUtil.hideProgressDialog();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AlertUtil.hideProgressDialog();
                    AlertUtil.showAPInotResponseWarn(context);
                }
            }

            @Override
            public void onFailure(Call<DivisionCollection> call, Throwable t) {
                //Hide Dialog
                AlertUtil.hideProgressDialog();
                AlertUtil.showAPInotResponseWarn(context);
            }
        });
        return responseData;
    }
}
