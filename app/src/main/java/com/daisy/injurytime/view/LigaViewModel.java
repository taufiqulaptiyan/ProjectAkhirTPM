package com.daisy.injurytime.view;

import com.daisy.injurytime.model.LigaItem;
import com.daisy.injurytime.model.LigaResponse;
import com.daisy.injurytime.service.ApiMain;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LigaViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<LigaItem>> listLiga = new MutableLiveData<>();

    public void setDiscoverLiga() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiLiga().getDiscoverLiga().enqueue(new Callback<LigaResponse>() {
            @Override
            public void onResponse(Call<LigaResponse> call, Response<LigaResponse> response) {
                LigaResponse responseLiga = (LigaResponse) response.body();
                if (responseLiga != null && responseLiga.getCountrys() != null){
                    ArrayList<LigaItem> ligaDiscoverItems = responseLiga.getCountrys();
                    listLiga.postValue(ligaDiscoverItems);

                }
            }

            @Override
            public void onFailure(Call<LigaResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<LigaItem>> getLigaDiscover(){
        return listLiga;
    }
}
