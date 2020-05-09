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
import com.daisy.injurytime.model.TimItem;
import com.daisy.injurytime.view.LigaDetail;
import com.daisy.injurytime.view.TimDetail;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TimAdapter extends RecyclerView.Adapter<TimAdapter.ViewHolder> {

    private ArrayList<TimItem> timItems = new ArrayList<>();
    private Context context;

    public TimAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TimItem> items){
        timItems.clear();
        timItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TimAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tim,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        RequestOptions options=new RequestOptions().error(R.drawable.ic_refresh);
        Glide.with(context).load(timItems.get(position).getStrTeamBadge()).apply(options).into(holder.iv_logo_tim);
        holder.tv_tim.setText(timItems.get(position).getStrTeam());

        holder.cv_item_tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, TimDetail.class);
//                intent.putExtra("foto",getPahlawanModels().get(position).getHeroImages());
                intent.putExtra("nama",timItems.get(position).getStrTeam());
                intent.putExtra("timliga",timItems.get(position).getStrLeague());
                intent.putExtra("detail",timItems.get(position).getStrDescriptionEN());
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return timItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_logo_tim;
        TextView tv_tim;
        CardView cv_item_tim;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_logo_tim=itemView.findViewById(R.id.iv_logo_tim);
            tv_tim=itemView.findViewById(R.id.tv_tim);
            cv_item_tim=itemView.findViewById(R.id.itemlisttim_cv);

        }
    }
}
