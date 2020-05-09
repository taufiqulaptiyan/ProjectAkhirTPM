package com.daisy.injurytime.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public LigaRepository getApiLiga(){
        String BASE_URL = "https://www.thesportsdb.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(LigaRepository.class);
    }

    public TimRepository getApiTim(){
        String BASE_URL = "https://www.thesportsdb.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TimRepository.class);
    }

    public JadwalRepository getApiJadwal(){
        String BASE_URL = "https://www.thesportsdb.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(JadwalRepository.class);
    }

    public HasilRepository getApiHasil(){
        String BASE_URL = "https://www.thesportsdb.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HasilRepository.class);
    }
}
