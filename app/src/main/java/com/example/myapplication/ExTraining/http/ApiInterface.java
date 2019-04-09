package com.example.myapplication.ExTraining.http;

import com.example.myapplication.ExTraining.db.LoanResponseJson;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("loan-calculator")
    Call<LoanResponseJson> getAll();
}
