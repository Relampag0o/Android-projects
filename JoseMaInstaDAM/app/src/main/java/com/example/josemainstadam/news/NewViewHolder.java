package com.example.josemainstadam.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.josemainstadam.R;

public class NewViewHolder extends RecyclerView.ViewHolder{
    ImageView newImage;
    TextView title;

    TextView body;
    TextView author;

    ImageView photo;

    public NewViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tittle);
        newImage = itemView.findViewById(R.id.newImage);
        body = itemView.findViewById(R.id.body);
        author = itemView.findViewById(R.id.author);
        photo = itemView.findViewById(R.id.photo);
    }
    public void bind(NewItem newItem) {
        title.setText(newItem.getTitle());
        newImage.setImageResource(newItem.getImageResource());
        body.setText(newItem.getBody());
        author.setText(newItem.getAuthor());


    }
}
