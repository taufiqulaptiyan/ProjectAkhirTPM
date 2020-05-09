package com.daisy.injurytime.service;

import com.daisy.injurytime.model.TimResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimRepository {
    @GET("api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain")
    Call<TimResponse> getDiscoverTim();
}
