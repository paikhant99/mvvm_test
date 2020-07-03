package com.paikhantko.mvvm_test.models.network;


import com.paikhantko.mvvm_test.models.entities.Covid19Response;
import com.paikhantko.mvvm_test.utils.AppConstants;

import io.reactivex.Single;
import retrofit2.http.GET;

interface ApiService {

    @GET(AppConstants.END_POINT)
    Single<Covid19Response> getData();
}
