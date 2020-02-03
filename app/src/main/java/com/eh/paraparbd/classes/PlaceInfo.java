package com.eh.paraparbd.classes;

import android.content.Context;
import android.util.Log;

import com.eh.paraparbd.Service.PBDApi;
import com.eh.paraparbd.model.DistrictTable;
import com.eh.paraparbd.model.DivisionTable;
import com.eh.paraparbd.model.PoliceStationTable;
import com.eh.paraparbd.pojo.DistrictCollection;
import com.eh.paraparbd.pojo.DivisionCollection;
import com.eh.paraparbd.pojo.PoliceStationCollection;
import com.eh.paraparbd.utils.AlertUtil;
import com.eh.paraparbd.utils.PBDUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceInfo {

    private static PBDApi pbdApi = PBDUtil.webserviceInitialize();
    private static List<DivisionTable> divisionData;
    private static List<DistrictTable> districtData;
    private static List<PoliceStationTable> policeStationData;
    private static ArrayList<String> divisionList = new ArrayList<>();
    private static ArrayList<String> districtList = new ArrayList<>();
    private static ArrayList<String> policeStationList = new ArrayList<>();

    public static ArrayList<String> getAllDivision(final Context context) {
        AlertUtil.showProgressDialog(context);

        Call<DivisionCollection> getDivision = pbdApi.getAllDivision();
        getDivision.enqueue(new Callback<DivisionCollection>() {
            @Override
            public void onResponse(Call<DivisionCollection> call, Response<DivisionCollection> response) {
                try {
                    DivisionCollection responseCollection = response.body();
                    if(responseCollection.getSuccess()){
                        divisionData = responseCollection.getData();
                        for (int i = 0; i < divisionData.size(); i++) {

                            String divisionName = divisionData.get(i).getDivisionName();
                            divisionList.add(divisionName);
                            Log.d("Division Name :::::  ", divisionName);
                        }

                        divisionList.add(0,"Select Division");
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
        return divisionList;
    }

    public static ArrayList<String> getAllDistrict(final Context context) {

        Call<DistrictCollection> getDistrict = pbdApi.getAllDistrict();
        getDistrict.enqueue(new Callback<DistrictCollection>() {
            @Override
            public void onResponse(Call<DistrictCollection> call, Response<DistrictCollection> response) {
                try {
                    DistrictCollection responseCollection = response.body();
                    if (responseCollection.getSuccess()) {
                        districtData = responseCollection.getData();
                        for (int i = 0; i < districtData.size(); i++) {

                            String divisionName = districtData.get(i).getDistrictName();
                            districtList.add(divisionName);
                            Log.d("Division Name :::::  ", divisionName);
                        }

                        districtList.add(0, "Select Division");
                        AlertUtil.hideProgressDialog();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AlertUtil.hideProgressDialog();
                    AlertUtil.showAPInotResponseWarn(context);
                }
            }

            @Override
            public void onFailure(Call<DistrictCollection> call, Throwable t) {
                AlertUtil.hideProgressDialog();
                AlertUtil.showAPInotResponseWarn(context);
            }
        });
        return districtList;
    }

    public static ArrayList<String> getAllPoliceStation(final Context context) {

        Call<PoliceStationCollection> getPoliceStation = pbdApi.getAllPoliceStation();
        getPoliceStation.enqueue(new Callback<PoliceStationCollection>() {
            @Override
            public void onResponse(Call<PoliceStationCollection> call, Response<PoliceStationCollection> response) {
                try {
                    PoliceStationCollection responseCollection = response.body();
                    if (responseCollection.getSuccess()) {
                        policeStationData = responseCollection.getData();
                        for (int i = 0; i < policeStationData.size(); i++) {

                            String policeStationName = policeStationData.get(i).getPoliceStationName();
                            policeStationList.add(policeStationName);
                            Log.d("Division Name :::::  ", policeStationName);
                        }

                        policeStationList.add(0, "Select Division");
                        AlertUtil.hideProgressDialog();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AlertUtil.hideProgressDialog();
                    AlertUtil.showAPInotResponseWarn(context);
                }
            }

            @Override
            public void onFailure(Call<PoliceStationCollection> call, Throwable t) {
                AlertUtil.hideProgressDialog();
                AlertUtil.showAPInotResponseWarn(context);
            }
        });
        return policeStationList;
    }
}
