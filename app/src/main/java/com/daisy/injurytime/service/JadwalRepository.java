package com.daisy.injurytime.service;

import com.daisy.injurytime.model.JadwalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JadwalRepository {
        @GET("api/v1/json/1/eventsnextleague.php?id=4335")
        Call<JadwalResponse> getDiscoverJadwal();
}
