package com.assignment.paygoproject.network;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService {

    @GET("data.json")
    Call<JsonArray> getAllData();
}
