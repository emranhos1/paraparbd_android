package com.eh.paraparbd.classes;

import android.content.Context;
import android.util.Log;

import com.eh.paraparbd.Service.PBDApi;
import com.eh.paraparbd.model.CarBrandTable;
import com.eh.paraparbd.pojo.CarBrandCollection;
import com.eh.paraparbd.utils.AlertUtil;
import com.eh.paraparbd.utils.PBDUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarModelInfo {

    private static PBDApi pbdApi = PBDUtil.webserviceInitialize();
    private static List<CarBrandTable> carModelData;
    private static ArrayList<String> carBrandList = new ArrayList<>();

    public static ArrayList<String> getAllCarModel(final Context context) {

        Call<CarBrandCollection> getCar = pbdApi.getAllCarBrand();
        getCar.enqueue(new Callback<CarBrandCollection>() {
            @Override
            public void onResponse(Call<CarBrandCollection> call, Response<CarBrandCollection> response) {
                try {
                    CarBrandCollection responseCollection = response.body();
                    if(responseCollection.getSuccess()){
                        carModelData = responseCollection.getData();
                        for (int i = 0; i < carModelData.size(); i++) {

                            String carBrandName = carModelData.get(i).getBrandName();
                            carBrandList.add(carBrandName);
                            Log.d("Car Brand Name :::::  ", carBrandName);
                        }
                        carBrandList.add(0,"Select One");
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    AlertUtil.hideProgressDialog();
                    AlertUtil.showAPInotResponseWarn(context);
                }
            }

            @Override
            public void onFailure(Call<CarBrandCollection> call, Throwable t) {
                AlertUtil.hideProgressDialog();
                AlertUtil.showAPInotResponseWarn(context);
            }
        });
        return carBrandList;
    }
}
