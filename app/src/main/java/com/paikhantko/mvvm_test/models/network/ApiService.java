package com.paikhantko.mvvm_test.models.network;


import com.paikhantko.mvvm_test.models.entities.Covid19Response;
import com.paikhantko.mvvm_test.utils.AppConstants;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiService {

    @GET(AppConstants.END_POINT)
    Call<Covid19Response> getData();
}
