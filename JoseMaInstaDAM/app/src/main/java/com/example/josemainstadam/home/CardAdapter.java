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

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<HomeCardItem> homeCardItems;

    private Context context;

    public CardAdapter(List<HomeCardItem> homeCardItems, Context context) {
        this.homeCardItems = homeCardItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new CardViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        HomeCardItem homeCardItem = homeCardItems.get(position);
        holder.bind(homeCardItem);
    }

    @Override
    public int getItemCount() {
        return homeCardItems.size();
    }


}

