package com.galih.myself;

/*21 Mei 2022*/
/*10119175*/
/*Mochamad Galih Prasetya*/
/*IF-5*/

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryHolder> {

    private ArrayList<Integer> list;
    private Activity activity;

    public GalleryAdapter(FragmentActivity activity, ArrayList<Integer> list) {
        this.list=list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public GalleryAdapter.GalleryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery,parent,false);
        return new GalleryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.GalleryHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new RoundedCorners(16));
        Glide.with(activity)
                .load(list.get(position))
                .apply(requestOptions)
                .into(holder.img_gallery);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GalleryHolder extends RecyclerView.ViewHolder {
        ImageView img_gallery;

        public GalleryHolder(@NonNull View itemView) {
            super(itemView);
            img_gallery = itemView.findViewById(R.id.iv_gallery);
        }
    }
}
