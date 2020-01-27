package com.eh.paraparbd.Service;

import com.eh.paraparbd.model.CommonUserRegTable;
import com.eh.paraparbd.model.LoginTable;
import com.eh.paraparbd.pojo.JsonCollection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PBDApi {

    @POST("/login")
    Call<JsonCollection> userLogin(@Body LoginTable loginTable);

    @POST("/common-user/registration")
    Call<JsonCollection> commonUserRegistration(CommonUserRegTable commonUserRegTable);
}
