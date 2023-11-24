package com.example.josemainstadam.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.josemainstadam.CardAdapter;
import com.example.josemainstadam.CardItem;
import com.example.josemainstadam.R;

import org.w3c.dom.Text;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {
    private List<NewItem> cardItems;

    private Context context;

    public NewAdapter(List<NewItem> cardItems, Context context) {
        this.cardItems = cardItems;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewItem newItem = cardItems.get(position);

        // CARD CONFIG:
        holder.title.setText(newItem.getTitle());
        holder.newImage.setImageResource(newItem.getImageResource());
        holder.body.setText(newItem.getBody());
        holder.author.setText(newItem.getAuthor());
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView newImage;
        TextView title;

        TextView body;
        TextView author;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newImage = itemView.findViewById(R.id.newImage);
            title = itemView.findViewById(R.id.tittle);
            body = itemView.findViewById(R.id.body);
            author = itemView.findViewById(R.id.author);
        }

    }
}
