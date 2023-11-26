package com.example.josemainstadam.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.josemainstadam.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<HomeCardItem> homeCardItems;

    private Context context;

    public CardAdapter(List<HomeCardItem> homeCardItems, Context context) {
        this.homeCardItems = homeCardItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeCardItem homeCardItem = homeCardItems.get(position);

        // CARD CONFIGURATION:
        holder.username.setText(homeCardItem.getUsername());
        holder.location.setText(homeCardItem.getLocation());
        holder.userImage.setImageResource(homeCardItem.getUserImageResource());
        holder.mainImage.setImageResource(homeCardItem.getMainImageResource());
        holder.likes.setText(homeCardItem.getLikes() + " Likes");
        holder.uploader.setText(homeCardItem.getUploader());
        holder.description.setText(homeCardItem.getDescription());
        holder.date.setText(homeCardItem.getDate());


        // LIKE CONFIGURATION:
        holder.likeButton.setClickable(true);
        holder.likeButton.setFocusable(true);

        // Set initial Lottie animation
        if (homeCardItem.isLiked()) {
            holder.likeButton.setAnimation(R.raw.defheart);
            holder.likeButton.playAnimation();
        } else {
            holder.likeButton.setAnimation(R.raw.graylike);
            holder.likeButton.playAnimation();
        }

        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeCardItem.isLiked()) {
                    // Si el elemento ya tiene "me gusta", lo quitamos
                    homeCardItem.setLikes(homeCardItem.getLikes() - 1);
                    homeCardItem.setLiked(false);
                    holder.likeButton.setAnimation(R.raw.graylike);
                    holder.likeButton.playAnimation();
                } else {
                    // Si el elemento no tiene "me gusta", lo añadimos
                    homeCardItem.setLikes(homeCardItem.getLikes() + 1);
                    homeCardItem.setLiked(true);
                    holder.likeButton.setAnimation(R.raw.defheart);
                    holder.likeButton.playAnimation();
                }
                homeCardItem.saveState(context);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeCardItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView username;
        ImageView mainImage;
        LottieAnimationView likeButton;
        TextView likes;
        TextView location;
        TextView uploader;
        TextView description;
        TextView date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            username = itemView.findViewById(R.id.username);
            mainImage = itemView.findViewById(R.id.mainImage);
            likeButton = itemView.findViewById(R.id.likeButton);
            likes = itemView.findViewById(R.id.likeCount);
            location = itemView.findViewById(R.id.location);
            uploader = itemView.findViewById(R.id.uploader);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
        }
    }
}

