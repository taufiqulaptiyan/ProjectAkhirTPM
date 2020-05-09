package com.daisy.injurytime.view;

import com.daisy.injurytime.model.HasilItem;
import com.daisy.injurytime.model.HasilResponse;
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

public class HasilViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<HasilItem>> listHasil = new MutableLiveData<>();

    public void setDiscoverHasil() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiHasil().getDiscoverHasil().enqueue(new Callback<HasilResponse>() {
            @Override
            public void onResponse(Call<HasilResponse> call, Response<HasilResponse> response) {
                HasilResponse responseHasil = (HasilResponse) response.body();
                if (responseHasil != null && responseHasil.getEvents() != null){
                    ArrayList<HasilItem> hasilDiscoverItems = responseHasil.getEvents();
                    listHasil.postValue(hasilDiscoverItems);

                }
            }

            @Override
            public void onFailure(Call<HasilResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<HasilItem>> getHasilDiscover(){
        return listHasil;
    }
}
