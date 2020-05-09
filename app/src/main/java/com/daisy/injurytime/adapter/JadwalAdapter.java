package com.daisy.injurytime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.daisy.injurytime.R;
import com.daisy.injurytime.model.JadwalItem;
import com.daisy.injurytime.model.TimItem;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {
//    private ArrayList<TimItem> timItems = new ArrayList<>();
    private ArrayList<JadwalItem> jadwalItems = new ArrayList<>();
    private Context context;
//    private static String BASE_IMAGE_URL = "https://www.thesportsdb.com/images/media/team/badge/";

    public JadwalAdapter(Context context) {
        this.context = context;
    }
    public void setData(ArrayList<JadwalItem> items){
        jadwalItems.clear();
        jadwalItems.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public JadwalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_jadwal,parent,false);
        return new JadwalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalAdapter.ViewHolder holder, int position) {
        RequestOptions options=new RequestOptions().error(R.drawable.ic_refresh);
//        if(jadwalItems.get(position).getIdHomeTeam()==timItems.get(position).getIdTeam()){
//            Glide.with(context).load(timItems.get(position).getStrTeamBadge()).apply(options).into(holder.iv_badge_home);
//        }
//        else if(jadwalItems.get(position).getIdAwayTeam()==timItems.get(position).getIdTeam()){
//            Glide.with(context).load(timItems.get(position).getStrTeamBadge()).apply(options).into(holder.iv_badge_away);
//        }

        holder.tv_home.setText(jadwalItems.get(position).getStrHomeTeam());
        holder.tv_away.setText(jadwalItems.get(position).getStrAwayTeam());
        holder.tv_tanggal.setText(jadwalItems.get(position).getStrDate());
        holder.tv_jam.setText(jadwalItems.get(position).getStrTime());
    }

    @Override
    public int getItemCount() {
        return jadwalItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_badge_home,iv_badge_away;
        TextView tv_home,tv_away,tv_tanggal,tv_jam;
        CardView cv_item_jadwal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_home=itemView.findViewById(R.id.tv_home);
            tv_away=itemView.findViewById(R.id.tv_away);
            tv_tanggal=itemView.findViewById(R.id.tv_tanggal);
//            iv_badge_home=itemView.findViewById(R.id.iv_badge_home);
//            iv_badge_away=itemView.findViewById(R.id.iv_badge_away);
            tv_jam=itemView.findViewById(R.id.tv_jam);
            cv_item_jadwal=itemView.findViewById(R.id.itemlistjadwal_cv);

        }
    }
}
