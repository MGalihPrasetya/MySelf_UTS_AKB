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

import java.util.List;

public class WalkthroughAdapter extends RecyclerView.Adapter<WalkthroughAdapter.WalkthroughHolder> {

    private List<WalkthroughData> walkthroughModels;

    public WalkthroughAdapter(List<WalkthroughData> walkthroughModels) {
        this.walkthroughModels = walkthroughModels;
    }

    @NonNull
    @Override
    public WalkthroughHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new WalkthroughHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.item_container_walkthrough, viewGroup, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull WalkthroughHolder holder, int position) {
        holder.setWalkthroughData(walkthroughModels.get(position));
    }

    @Override
    public int getItemCount() {
        return walkthroughModels.size();
    }

    public class WalkthroughHolder extends RecyclerView.ViewHolder {
        private TextView tvTitleWalkthrough;
        private TextView tvSubtitleWalkthrough;
        private ImageView ivWalkthrough;

        public WalkthroughHolder(@NonNull View itemView) {
            super(itemView);

            tvTitleWalkthrough = itemView.findViewById(R.id.tv_title_walkthrough);
            tvSubtitleWalkthrough = itemView.findViewById(R.id.tv_subtitle_walkthrough);
            ivWalkthrough = itemView.findViewById(R.id.iv_walkthrough);
        }

        void setWalkthroughData(WalkthroughData walkthroughModel) {
            tvTitleWalkthrough.setText(walkthroughModel.title);
            tvSubtitleWalkthrough.setText(walkthroughModel.subtitle);
            ivWalkthrough.setImageResource(walkthroughModel.image);
        }
    }
}
