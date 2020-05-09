package com.daisy.injurytime.view;

import com.daisy.injurytime.model.JadwalItem;
import com.daisy.injurytime.model.JadwalResponse;
import com.daisy.injurytime.service.ApiMain;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<JadwalItem>> listJadwal = new MutableLiveData<>();

    public void setDiscoverJadwal() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiJadwal().getDiscoverJadwal().enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                JadwalResponse responseJadwal = (JadwalResponse) response.body();
                if (responseJadwal != null && responseJadwal.getEvents() != null){
                    ArrayList<JadwalItem> jadwalDiscoverItems = responseJadwal.getEvents();
                    listJadwal.postValue(jadwalDiscoverItems);

                }
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<JadwalItem>> getJadwalDiscover(){
        return listJadwal;
    }
}


