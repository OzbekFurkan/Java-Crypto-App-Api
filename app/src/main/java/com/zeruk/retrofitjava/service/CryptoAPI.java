package com.zeruk.retrofitjava.service;

import com.zeruk.retrofitjava.model.CryptoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {
    @GET("prices?key=511a9f9be6f43b741f8f060c2a83c2fa2f4b5fdd")
    Observable<List<CryptoModel>> getData();
    //Call<List<CryptoModel>> getData();
}
