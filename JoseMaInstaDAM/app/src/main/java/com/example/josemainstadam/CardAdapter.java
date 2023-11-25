package com.example.josemainstadam;

import android.content.Context;
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


        // LIKE CONFIGURATION:
        // LIKE CONFIGURATION:
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardItem.isLiked()) {
                    Log.d("INFO", "Setting the boolean to false: ");
                    cardItem.setLiked(false);
                    cardItem.saveState(context);  // Save state when unliked
                    //holder.likeButton.setAnimation(R.raw.unlike); // Set unlike animation
                    holder.likeButton.playAnimation(); // Play unlike animation
                    notifyItemChanged(holder.getAdapterPosition());

                } else {
                    Log.d("INFO", "Setting the boolean to true: ");
                    cardItem.setLiked(true);
                    cardItem.saveState(context);  // Save state when liked
                    holder.likeButton.setAnimation(R.raw.like); // Set like animation
                    holder.likeButton.playAnimation(); // Play like animation
                    Log.d("STATUS", cardItem.isLiked() + "");
                    notifyItemChanged(holder.getAdapterPosition());
                }
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
        LottieAnimationView likeButton;

        ImageView profileimg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            username = itemView.findViewById(R.id.username);
            mainImage = itemView.findViewById(R.id.mainImage);
            likeButton = itemView.findViewById(R.id.animationView);
            profileimg = itemView.findViewById(R.id.profileimg);
        }
    }
}

