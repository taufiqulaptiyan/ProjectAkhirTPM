package com.daisy.injurytime.service;

import com.daisy.injurytime.model.LigaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LigaRepository {
    @GET("api/v1/json/1/search_all_leagues.php?c=Spain&s=Soccer")
    Call<LigaResponse> getDiscoverLiga();
}
