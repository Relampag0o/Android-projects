package com.example.josemainstadam.fav;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.josemainstadam.home.HomeCardItem;
import com.example.josemainstadam.R;

import java.util.List;

public class SaveCardAdapter extends RecyclerView.Adapter<SaveCardAdapter.ViewHolder> {

    private List<SaveCardItem> saveCardItems;
    private List<HomeCardItem> homeHomeCardItems;
    private Context context;

    public SaveCardAdapter(List<HomeCardItem> homeHomeCardItems, List<SaveCardItem> saveCardItems, Context context) {
        this.homeHomeCardItems = homeHomeCardItems;
        this.saveCardItems = saveCardItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.save_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SaveCardItem saveCardItem = saveCardItems.get(holder.getAdapterPosition());

        holder.author.setText(saveCardItem.getAuthor());
        holder.image.setImageResource(saveCardItem.getImage());
        holder.profileimg.setImageResource(saveCardItem.getImageuser());
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
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
                notifyItemRemoved(holder.getAdapterPosition());

                holder.deleteButton.setAnimation(R.raw.defheart);
                holder.deleteButton.playAnimation();
            }
        });
    }


    @Override
    public int getItemCount() {
        return saveCardItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        ImageView image;
        ImageView profileimg;
        LottieAnimationView deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            image = itemView.findViewById(R.id.image);
            profileimg = itemView.findViewById(R.id.profileimg);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            deleteButton.setAnimation(R.raw.defheart);
            deleteButton.playAnimation();
        }
    }
}
