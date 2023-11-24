package com.example.josemainstadam.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.josemainstadam.CardItem;
import com.example.josemainstadam.R;

import java.util.List;

public class SaveCardAdapter extends RecyclerView.Adapter<SaveCardAdapter.ViewHolder> {

    private List<SaveCardItem> saveCardItems;
    private List<CardItem> homeCardItems;
    private Context context;

    public SaveCardAdapter(List<CardItem> homeCardItems, List<SaveCardItem> saveCardItems, Context context) {
        this.homeCardItems = homeCardItems;
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

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CardItem homeCardItem : homeCardItems) {
                    Log.d("SAVECARD ID: ", saveCardItem.getId() + "HOMECARDID" + homeCardItem.getId());
                    if (saveCardItem.getId() == homeCardItem.getId()) {
                        saveCardItem.setSaved(false);
                        homeCardItem.setLiked(false);
                        homeCardItem.saveState(context);
                        break;
                    }
                }

                // Elimina el elemento de saveCardItems
                saveCardItems.remove(saveCardItem);
                notifyItemRemoved(holder.getAdapterPosition());
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
        Button deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            image = itemView.findViewById(R.id.image);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
