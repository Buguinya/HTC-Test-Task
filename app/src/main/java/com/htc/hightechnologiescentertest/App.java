package com.htc.hightechnologiescentertest;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {

    private final String BASE_URL = "http://www.mocky.io/v2/";

    private static CompanyApi sCompanyApi;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sCompanyApi = mRetrofit.create(CompanyApi.class);
    }

    public static CompanyApi getCompanyApi() {
        return sCompanyApi;
    }
}
