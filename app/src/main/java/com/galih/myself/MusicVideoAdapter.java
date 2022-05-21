package com.galih.myself;

/*21 Mei 2022*/
/*10119175*/
/*Mochamad Galih Prasetya*/
/*IF-5*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MusicVideoAdapter extends RecyclerView.Adapter<MusicVideoAdapter.MusicVideoHolder>{

    List<MusicData> musicList = new ArrayList<>();

    public MusicVideoAdapter(List<MusicData> musicList) {
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MusicVideoAdapter.MusicVideoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_music, viewGroup, false);
        return new MusicVideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicVideoAdapter.MusicVideoHolder holder, int position) {
        holder.tvTitle.setText(musicList.get(position).title);
        holder.tvSinger.setText(musicList.get(position).singer);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class MusicVideoHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSinger;

        public MusicVideoHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSinger = itemView.findViewById(R.id.tv_singer);
        }
    }
}
