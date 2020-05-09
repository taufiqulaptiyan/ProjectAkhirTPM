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
import com.daisy.injurytime.adapter.LigaAdapter;
import com.daisy.injurytime.model.LigaItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LigaFragment extends Fragment {
    private LigaAdapter ligaAdapter;
    private RecyclerView rvLigaDiscover;
    private LigaViewModel ligaViewModel;

    public LigaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liga, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ligaAdapter = new LigaAdapter(getContext());
        ligaAdapter.notifyDataSetChanged();

        rvLigaDiscover = view.findViewById(R.id.fragmentliga_rv);
        rvLigaDiscover.setLayoutManager(new GridLayoutManager(getContext(), 1));

        ligaViewModel = new ViewModelProvider(this).get(LigaViewModel.class);
        ligaViewModel.setDiscoverLiga();
        ligaViewModel.getLigaDiscover().observe(this,getDiscoverLiga);

        rvLigaDiscover.setAdapter(ligaAdapter);
    }
    private Observer<ArrayList<LigaItem>> getDiscoverLiga = new Observer<ArrayList<LigaItem>>(){
        @Override
        public void onChanged(ArrayList<LigaItem> ligaItems) {
            if (ligaItems != null){
                ligaAdapter.setData(ligaItems);
            }
        }
    };
}
