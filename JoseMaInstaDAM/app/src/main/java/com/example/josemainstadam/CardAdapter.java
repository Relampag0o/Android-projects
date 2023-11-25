package com.example.josemainstadam;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<CardItem> cardItems;

    private Context context;

    public CardAdapter(List<CardItem> cardItems, Context context) {
        this.cardItems = cardItems;
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
        CardItem cardItem = cardItems.get(position);

        // CARD CONFIGURATION:
        holder.username.setText(cardItem.getUsername());
        holder.userImage.setImageResource(cardItem.getUserImageResource());
        holder.mainImage.setImageResource(cardItem.getMainImageResource());
        holder.likes.setText(cardItem.getLikes() + " Likes");
        int d = R.drawable.smallheart;

        // Set initial heart image
        if (cardItem.isLiked()) {
            holder.likeButton.setImageResource(R.drawable.smallheart);
        } else {
            holder.likeButton.setImageResource(R.drawable.whiteheart);
        }

        // LIKE CONFIGURATION:
        holder.likeButton.setClickable(true);
        holder.likeButton.setFocusable(true);

        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardItem.isLiked()) {
                    // Si el elemento ya tiene "me gusta", lo quitamos
                    cardItem.setLikes(cardItem.getLikes() - 1);
                    cardItem.setLiked(false);
                    holder.likeButton.setImageResource(R.drawable.whiteheart);
                } else {
                    // Si el elemento no tiene "me gusta", lo añadimos
                    cardItem.setLikes(cardItem.getLikes() + 1);
                    cardItem.setLiked(true);
                    holder.likeButton.setImageResource(R.drawable.smallheart);
                }
                cardItem.saveState(context);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }


    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView username;
        ImageView mainImage;
        ImageButton likeButton;

        ImageView profileimg;
        TextView likes;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            username = itemView.findViewById(R.id.username);
            mainImage = itemView.findViewById(R.id.mainImage);
            likeButton = itemView.findViewById(R.id.likeButton);
            profileimg = itemView.findViewById(R.id.profileimg);
            likes = itemView.findViewById(R.id.likeCount);
        }
    }
}

