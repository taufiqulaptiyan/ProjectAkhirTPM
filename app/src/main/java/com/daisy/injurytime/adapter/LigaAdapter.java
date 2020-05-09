package com.daisy.injurytime.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.daisy.injurytime.R;
import com.daisy.injurytime.model.LigaItem;
import com.daisy.injurytime.view.LigaDetail;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class LigaAdapter extends RecyclerView.Adapter<LigaAdapter.ViewHolder> {

    private ArrayList<LigaItem> ligaItems = new ArrayList<>();
    private Context context;

    public LigaAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<LigaItem> items){
        ligaItems.clear();
        ligaItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LigaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_liga,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LigaAdapter.ViewHolder holder, final int position) {
        RequestOptions options=new RequestOptions().error(R.drawable.ic_refresh);
        Glide.with(context).load(ligaItems.get(position).getStrBadge()).apply(options).into(holder.iv_logo_liga);
        holder.tv_liga.setText(ligaItems.get(position).getStrLeague());

        holder.cv_item_liga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, LigaDetail.class);
//                intent.putExtra("foto",getPahlawanModels().get(position).getHeroImages());
                intent.putExtra("nama",ligaItems.get(position).getStrLeague());
                intent.putExtra("detail",ligaItems.get(position).getStrDescriptionEN());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ligaItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_logo_liga;
        TextView tv_liga,tv_sport;
        CardView cv_item_liga;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_logo_liga=itemView.findViewById(R.id.iv_logo_liga);
            tv_liga=itemView.findViewById(R.id.tv_liga);
            cv_item_liga=itemView.findViewById(R.id.itemlistliga_cv);

        }
    }
}
