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
        import com.daisy.injurytime.adapter.JadwalAdapter;
        import com.daisy.injurytime.model.JadwalItem;

        import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalFragment extends Fragment {
    private JadwalAdapter jadwalAdapter;
    private RecyclerView rvjadwalDiscover;
    private JadwalViewModel jadwalViewModel;

    public JadwalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jadwalAdapter = new JadwalAdapter(getContext());
        jadwalAdapter.notifyDataSetChanged();

        rvjadwalDiscover = view.findViewById(R.id.fragmentjadwal_rv);
        rvjadwalDiscover.setLayoutManager(new GridLayoutManager(getContext(), 1));

        jadwalViewModel = new ViewModelProvider(this).get(JadwalViewModel.class);
        jadwalViewModel.setDiscoverJadwal();
        jadwalViewModel.getJadwalDiscover().observe(this,getDiscoverJadwal);

        rvjadwalDiscover.setAdapter(jadwalAdapter);
    }
    private Observer<ArrayList<JadwalItem>> getDiscoverJadwal = new Observer<ArrayList<JadwalItem>>(){
        @Override
        public void onChanged(ArrayList<JadwalItem> jadwalItems) {
            if (jadwalItems != null){
                jadwalAdapter.setData(jadwalItems);
            }
        }
    };
}