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

    // Variables to store the author, image and imageuser of the item
    TextView author;
    ImageView image;
    ImageView profileimg;
    LottieAnimationView deleteButton;

    // Variable to store the context
     Context context;

     // Constructor to initialize the views
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


    // Method to bind the views with the data
    public void bind(SaveCardItem saveCardItem, List<HomeCardItem> homeHomeCardItems, List<SaveCardItem> saveCardItems,RecyclerView.Adapter adapter) {
        author.setText(saveCardItem.getAuthor());
        image.setImageResource(saveCardItem.getImage());
        profileimg.setImageResource(saveCardItem.getImageuser());
        // Set the click listener for the delete button
        deleteButton.setOnClickListener(new View.OnClickListener() {
            // When the delete button is clicked
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

                // Remove the item from the list
                int position = saveCardItems.indexOf(saveCardItem);
                saveCardItems.remove(saveCardItem);
                adapter.notifyItemRemoved(position);
                deleteButton.setAnimation(R.raw.defheart);
                deleteButton.playAnimation();
            }
        });
    }
}
