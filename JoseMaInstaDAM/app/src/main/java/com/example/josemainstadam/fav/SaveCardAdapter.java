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

public class SaveCardAdapter extends RecyclerView.Adapter<SaveCardViewHolder> {

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
    public SaveCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.save_card, parent, false);
        return new SaveCardViewHolder(view, context);
    }

    public void onBindViewHolder(@NonNull SaveCardViewHolder holder, int position) {
        SaveCardItem saveCardItem = saveCardItems.get(holder.getAdapterPosition());
        holder.bind(saveCardItem, homeHomeCardItems, saveCardItems, this);

    }


    @Override
    public int getItemCount() {
        return saveCardItems.size();
    }


}
