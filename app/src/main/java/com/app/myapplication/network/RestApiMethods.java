package com.app.myapplication.network;

import com.app.myapplication.network.responsemodel.ClsGetListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RestApiMethods
{


    @GET("search_by_date?tags=story")
    Call<ClsGetListResponse> getList(@Query("page") int pageNo);


}
