package com.galih.myself;

/*21 Mei 2022*/
/*10119175*/
/*Mochamad Galih Prasetya*/
/*IF-5*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.galih.myself.DailyData;
import com.galih.myself.R;

import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyHolder> {

    List<DailyData> list;

    public DailyAdapter(List<DailyData> list){
        this.list = list;
    }

    @NonNull
    @Override
    public DailyAdapter.DailyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily,parent,false);
        return new DailyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyAdapter.DailyHolder holder, int position) {
        DailyData data = list.get(position);
        Glide.with(holder.itemView.getContext())
                .load(data.image)
                .apply(new RequestOptions().override(1000,1000))
                .into(holder.image);
        holder.title.setText(data.title);
        holder.desc.setText(data.desc);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DailyHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc;

        public DailyHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_daily);
            title = itemView.findViewById(R.id.title_daily);
            desc = itemView.findViewById(R.id.desc_daily);
        }
    }
}
