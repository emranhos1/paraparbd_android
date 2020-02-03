package com.eh.paraparbd.Service;

import com.eh.paraparbd.model.CommonUserRegTable;
import com.eh.paraparbd.model.LoginTable;
import com.eh.paraparbd.pojo.CarBrandCollection;
import com.eh.paraparbd.pojo.CommonUserRegCollection;
import com.eh.paraparbd.pojo.DistrictCollection;
import com.eh.paraparbd.pojo.DivisionCollection;
import com.eh.paraparbd.pojo.LoginCollection;
import com.eh.paraparbd.pojo.PoliceStationCollection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PBDApi {

    @POST("/login")
    Call<LoginCollection> userLogin(@Body LoginTable loginTable);

    @POST("/common-user/registration")
    Call<CommonUserRegCollection> commonUserRegistration(@Body CommonUserRegTable commonUserRegTable);

    @GET("/place/division")
    Call<DivisionCollection> getAllDivision();

    @GET("/place/district")
    Call<DistrictCollection> getAllDistrict();

    @GET("/place/police-station")
    Call<PoliceStationCollection> getAllPoliceStation();

    @GET("/car/brand")
    Call<CarBrandCollection> getAllCarBrand();
}
