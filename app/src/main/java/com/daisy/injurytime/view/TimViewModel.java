package com.daisy.injurytime.view;

import com.daisy.injurytime.model.TimItem;
import com.daisy.injurytime.model.TimResponse;
import com.daisy.injurytime.service.ApiMain;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<TimItem>> listTim = new MutableLiveData<>();

    public void setDiscoverTim() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiTim().getDiscoverTim().enqueue(new Callback<TimResponse>() {
            @Override
            public void onResponse(Call<TimResponse> call, Response<TimResponse> response) {
                TimResponse responseTim = (TimResponse) response.body();
                if (responseTim != null && responseTim.getTeams() != null){
                    ArrayList<TimItem> timDiscoverItems = responseTim.getTeams();
                    listTim.postValue(timDiscoverItems);

                }
            }

            @Override
            public void onFailure(Call<TimResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<TimItem>> getTimDiscover(){
        return listTim;
    }
}




