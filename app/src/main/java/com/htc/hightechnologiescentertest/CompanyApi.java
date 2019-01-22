package com.htc.hightechnologiescentertest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CompanyApi {

    @GET("56fa31e0110000f920a72134")
    Call<JsonResponse> getJSONCompany();

}
