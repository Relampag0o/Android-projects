package com.example.josemainstadam.fav;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.josemainstadam.R;
import com.example.josemainstadam.home.HomeCardItem;

import java.util.List;

public class SaveCardViewHolder extends RecyclerView.ViewHolder {

    TextView author;
    ImageView image;
    ImageView profileimg;
    LottieAnimationView deleteButton;

     Context context;

    public SaveCardViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        author = itemView.findViewById(R.id.author);
        image = itemView.findViewById(R.id.image);
        profileimg = itemView.findViewById(R.id.profileimg);
        deleteButton = itemView.findViewById(R.id.deleteButton);
        deleteButton.setAnimation(R.raw.defheart);
        deleteButton.playAnimation();
        this.context = context;
    }

    public void bind(SaveCardItem saveCardItem, List<HomeCardItem> homeHomeCardItems, List<SaveCardItem> saveCardItems) {
        author.setText(saveCardItem.getAuthor());
        image.setImageResource(saveCardItem.getImage());
        profileimg.setImageResource(saveCardItem.getImageuser());
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (HomeCardItem homeCardItem : homeHomeCardItems) {
                    Log.d("SAVECARD ID: ", saveCardItem.getId() + "HOMECARDID" + homeCardItem.getId());
                    if (saveCardItem.getId() == homeCardItem.getId()) {
                        saveCardItem.setSaved(false);
                        homeCardItem.setLiked(false);
                        homeCardItem.saveState(context);
                        break;
                    }
                }

                saveCardItems.remove(saveCardItem);
                // notifyItemRemoved(getAdapterPosition()); // This line may need to be handled differently

                deleteButton.setAnimation(R.raw.defheart);
                deleteButton.playAnimation();
            }
        });
    }
}
