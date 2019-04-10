package com.example.myapplication.ExTraining.http;

import com.example.myapplication.ExTraining.db.LoanResponseJson;
import com.example.myapplication.ExTraining.utils.Utils;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    void setLoanInput(String loanInput);
    String getLoanInput();

    @GET("loan-calculator")
    Call<LoanResponseJson> getAll();
    @GET("loan-calculator?loanInputs={amount: 200000, rate: 6.5, months: 180}")
    Call<LoanResponseJson> getLoan2k1();
    @GET("loan-calculator?loanInputs={amount: 200000, rate: 8, months: 120}")
    Call<LoanResponseJson> getLoan2k2();

}
