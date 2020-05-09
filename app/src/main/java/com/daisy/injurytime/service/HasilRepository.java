package com.daisy.injurytime.service;

import com.daisy.injurytime.model.HasilResponse;
import com.daisy.injurytime.model.JadwalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HasilRepository {
        @GET("api/v1/json/1/eventsround.php?id=4335&r=38&s=1415")
        Call<HasilResponse> getDiscoverHasil();
}
