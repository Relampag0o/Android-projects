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

public class CardViewHolder extends RecyclerView.ViewHolder {
    ImageView userImage;
    TextView username;
    ImageView mainImage;
    LottieAnimationView likeButton;
    TextView likes;
    TextView location;
    TextView uploader;
    TextView description;
    TextView date;

    private Context context;


    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new CardViewHolder(view, context);
    }
    public CardViewHolder(@NonNull View itemView,Context context ) {
        super(itemView);
        this.context = context;
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


    public void bind(HomeCardItem homeCardItem) {
        username.setText(homeCardItem.getUsername());
        location.setText(homeCardItem.getLocation());
        userImage.setImageResource(homeCardItem.getUserImageResource());
        mainImage.setImageResource(homeCardItem.getMainImageResource());
        likes.setText(homeCardItem.getLikes() + " Likes");
        uploader.setText(homeCardItem.getUploader());
        description.setText(homeCardItem.getDescription());
        date.setText(homeCardItem.getDate());

        // LIKE CONFIGURATION:
        likeButton.setClickable(true);
        likeButton.setFocusable(true);

        // Set initial Lottie animation
        if (homeCardItem.isLiked()) {
            likeButton.setAnimation(R.raw.defheart);
            likeButton.playAnimation();
        } else {
            likeButton.setAnimation(R.raw.graylike);
            likeButton.playAnimation();
        }

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeCardItem.isLiked()) {
                    // Si el elemento ya tiene "me gusta", lo quitamos
                    homeCardItem.setLikes(homeCardItem.getLikes() - 1);
                    homeCardItem.setLiked(false);
                    likeButton.setAnimation(R.raw.graylike);
                    likeButton.playAnimation();
                } else {
                    // Si el elemento no tiene "me gusta", lo añadimos
                    homeCardItem.setLikes(homeCardItem.getLikes() + 1);
                    homeCardItem.setLiked(true);
                    likeButton.setAnimation(R.raw.defheart);
                    likeButton.playAnimation();
                }
                homeCardItem.saveState(context);
                // notifyItemChanged(getAdapterPosition()); // This line may need to be handled differently
            }
        });
    }
}
