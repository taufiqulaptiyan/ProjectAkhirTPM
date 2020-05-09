package com.daisy.injurytime.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daisy.injurytime.R;
import com.daisy.injurytime.adapter.TimAdapter;
import com.daisy.injurytime.model.TimItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimFragment extends Fragment {

    private TimAdapter timAdapter;
    private RecyclerView rvTimDiscover;
    private TimViewModel timViewModel;

    public TimFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tim, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        timAdapter = new TimAdapter(getContext());
        timAdapter.notifyDataSetChanged();

        rvTimDiscover = view.findViewById(R.id.fragmenttim_rv);
        rvTimDiscover.setLayoutManager(new GridLayoutManager(getContext(), 1));

        timViewModel = new ViewModelProvider(this).get(TimViewModel.class);
        timViewModel.setDiscoverTim();
        timViewModel.getTimDiscover().observe(this,getDiscoverTim);

        rvTimDiscover.setAdapter(timAdapter);
    }
    private Observer<ArrayList<TimItem>> getDiscoverTim = new Observer<ArrayList<TimItem>>(){
        @Override
        public void onChanged(ArrayList<TimItem> timItems) {
            if (timItems != null){
                timAdapter.setData(timItems);
            }
        }
    };
}
