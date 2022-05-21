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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendHolder> {

    List<Integer> imageList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    Activity activity;

    public FriendAdapter(Activity activity, List<String> nameList, List<Integer> imageList) {
        this.activity = activity;
        this.imageList = imageList;
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public FriendAdapter.FriendHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_friend,viewGroup,false);

        return new FriendHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.FriendHolder holder, int position) {
        Glide.with(activity)
                .load(imageList.get(position))
                .circleCrop()
                .into(holder.imageView);

        holder.textView.setText(nameList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class FriendHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public FriendHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.pic_friend);
            textView = (TextView)itemView.findViewById(R.id.name);
        }

        public ImageView getImageView(){
            return imageView;
        }

        public TextView getTextView(){
            return textView;
        }
    }
}
