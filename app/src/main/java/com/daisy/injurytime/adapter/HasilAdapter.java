package com.daisy.injurytime.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.daisy.injurytime.R;
import com.daisy.injurytime.model.HasilItem;
import com.daisy.injurytime.model.JadwalItem;
import com.daisy.injurytime.view.HasilDetail;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HasilAdapter extends RecyclerView.Adapter<HasilAdapter.ViewHolder> {
    private ArrayList<HasilItem> hasilItems = new ArrayList<>();
    private Context context;

    public HasilAdapter(Context context) {
        this.context = context;
    }
    public void setData(ArrayList<HasilItem> items){
        hasilItems.clear();
        hasilItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HasilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_hasil,parent,false);
        return new HasilAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        RequestOptions options=new RequestOptions().error(R.drawable.ic_refresh);
//        Glide.with(context).load(timItems.get(position).getStrTeam()).apply(options).into(holder.iv_badge_home);
//        Glide.with(context).load(timItems.get(position).getStrTeam()).apply(options).into(holder.iv_badge_away);
        holder.tv_home_hasil.setText(hasilItems.get(position).getStrHomeTeam());
        holder.tv_away_hasil.setText(hasilItems.get(position).getStrAwayTeam());
        holder.tv_tanggal_hasil.setText(hasilItems.get(position).getDateEvent());
        holder.tv_home_skor.setText(hasilItems.get(position).getIntHomeScore());
        holder.tv_away_skor.setText(hasilItems.get(position).getIntAwayScore());

        holder.cv_item_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, HasilDetail.class);

                intent.putExtra("tanggal",hasilItems.get(position).getStrDate());
                intent.putExtra("jam",hasilItems.get(position).getStrTime());
                intent.putExtra("home",hasilItems.get(position).getStrHomeTeam());
                intent.putExtra("home_skor",hasilItems.get(position).getIntHomeScore());
                intent.putExtra("away",hasilItems.get(position).getStrAwayTeam());
                intent.putExtra("away_skor",hasilItems.get(position).getIntAwayScore());
                intent.putExtra("home_goal",hasilItems.get(position).getStrHomeGoalDetails());
                intent.putExtra("away_goal",hasilItems.get(position).getStrAwayGoalDetails());
                intent.putExtra("home_shots",hasilItems.get(position).getIntHomeShots());
                intent.putExtra("away_shots",hasilItems.get(position).getIntAwayShots());
                intent.putExtra("home_for",hasilItems.get(position).getStrHomeLineupForward());
                intent.putExtra("away_for",hasilItems.get(position).getStrAwayLineupForward());
                intent.putExtra("home_mid",hasilItems.get(position).getStrHomeLineupMidfield());
                intent.putExtra("away_mid",hasilItems.get(position).getStrAwayLineupMidfield());
                intent.putExtra("home_def",hasilItems.get(position).getStrHomeLineupDefense());
                intent.putExtra("away_def",hasilItems.get(position).getStrAwayLineupDefense());
                intent.putExtra("home_gk",hasilItems.get(position).getStrHomeLineupGoalkeeper());
                intent.putExtra("away_gk",hasilItems.get(position).getStrAwayLineupGoalkeeper());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hasilItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_badge_home,iv_badge_away;
        TextView tv_home_hasil,tv_away_hasil,tv_tanggal_hasil,tv_home_skor,tv_away_skor;
        CardView cv_item_hasil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_home_hasil=itemView.findViewById(R.id.tv_home_hasil);
            tv_away_hasil=itemView.findViewById(R.id.tv_away_hasil);
            tv_tanggal_hasil=itemView.findViewById(R.id.tv_tanggal_hasil);
            tv_home_skor=itemView.findViewById(R.id.tv_home_skor);
            tv_away_skor=itemView.findViewById(R.id.tv_away_skor);
            cv_item_hasil=itemView.findViewById(R.id.itemlisthasil_cv);
        }
    }
}
