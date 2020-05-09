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
import com.daisy.injurytime.adapter.HasilAdapter;
import com.daisy.injurytime.adapter.JadwalAdapter;
import com.daisy.injurytime.model.HasilItem;
import com.daisy.injurytime.model.JadwalItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HasilFragment extends Fragment {
    private HasilAdapter hasilAdapter;
    private RecyclerView rvhasilDiscover;
    private HasilViewModel hasilViewModel;

    public HasilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hasil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hasilAdapter = new HasilAdapter(getContext());
        hasilAdapter.notifyDataSetChanged();

        rvhasilDiscover = view.findViewById(R.id.fragmenthasil_rv);
        rvhasilDiscover.setLayoutManager(new GridLayoutManager(getContext(), 1));

        hasilViewModel = new ViewModelProvider(this).get(HasilViewModel.class);
        hasilViewModel.setDiscoverHasil();
        hasilViewModel.getHasilDiscover().observe(this,getDiscoverHasil);

        rvhasilDiscover.setAdapter(hasilAdapter);
    }
    private Observer<ArrayList<HasilItem>> getDiscoverHasil = new Observer<ArrayList<HasilItem>>(){
        @Override
        public void onChanged(ArrayList<HasilItem> hasilItems) {
            if (hasilItems != null){
                hasilAdapter.setData(hasilItems);
            }
        }
    };
}
