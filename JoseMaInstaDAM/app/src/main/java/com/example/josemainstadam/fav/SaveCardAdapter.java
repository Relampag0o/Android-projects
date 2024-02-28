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

// Adapter for the SaveCardItem
public class SaveCardAdapter extends RecyclerView.Adapter<SaveCardViewHolder> {

    // Variables

    private List<SaveCardItem> saveCardItems;
    // List of HomeCardItem
    private List<HomeCardItem> homeHomeCardItems;
    // Context
    private Context context;

    // Constructor
    public SaveCardAdapter(List<HomeCardItem> homeHomeCardItems, List<SaveCardItem> saveCardItems, Context context) {
        this.homeHomeCardItems = homeHomeCardItems;
        this.saveCardItems = saveCardItems;
        this.context = context;
    }

    // Create the view holder
    @NonNull
    @Override
    public SaveCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.save_card, parent, false);
        return new SaveCardViewHolder(view, context);
    }


    // Bind the view holder
    public void onBindViewHolder(@NonNull SaveCardViewHolder holder, int position) {
        SaveCardItem saveCardItem = saveCardItems.get(holder.getAdapterPosition());
        holder.bind(saveCardItem, homeHomeCardItems, saveCardItems, this);

    }


    // Get the item count
    @Override
    public int getItemCount() {
        return saveCardItems.size();
    }


}
