package com.phool.searchfavouritephotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    Context mCtx;
    List<Results> photosList;

    public ImageAdapter(Context mCtx, List<Results> photosList) {
        this.mCtx = mCtx;
        this.photosList = photosList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Results photos = photosList.get(position);

        Glide.with(mCtx)
                .load(photos.getUrls().getSmall())
//                .apply(new RequestOptions().override(300, 600))
                .into(holder.imageView);

        Glide.with(mCtx)
                .load(photos.getUser().getProfileImage().getSmall())
                .into(holder.photographer_profile);

//        Glide.with(mCtx)
//                .load(photos.getUser().getUsername())
//                .set(holder.photographer_name);
        String s = "Photographer:- "+ photos.getUser().getUsername();
        holder.photographer_name.setText(s);
//        holder.textViewVotesCount.setText(photos.getUser().getLinks().getLikes());



//        holder.textView.setText(hero.getDescription());
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        ImageView photographer_profile;
        TextView photographer_name;
        TextView textViewVotesCount;
//        TextView textView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            photographer_profile = itemView.findViewById(R.id.photographer_profile);
            photographer_name= itemView.findViewById(R.id.photographer_name);
//            textViewVotesCount = itemView.findViewById(R.id.textViewVotesCount);
        }
    }


}
