package com.eh.paraparbd.Service;

import com.eh.paraparbd.model.LoginTable;
import com.eh.paraparbd.pojo.LoginCollection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PBDApi {

    @POST("/login")
    Call<LoginCollection> userLogin(@Body LoginTable loginTable);
}
