package com.example.josemainstadam.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.josemainstadam.R;

public class PersonViewHolder extends RecyclerView.ViewHolder{
    ImageView personImage;
    TextView username;
    TextView fullName;
    TextView followerCount;

    Context context;


    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_card, parent, false);
        return new PersonViewHolder(view, context);
    }
    public PersonViewHolder(@NonNull View itemView,Context context ) {
        super(itemView);
        this.context = context;
        personImage = itemView.findViewById(R.id.userImage);
        username = itemView.findViewById(R.id.username);
        fullName = itemView.findViewById(R.id.fullName);
        followerCount = itemView.findViewById(R.id.followerCount);
    }

    public void bindData(Person person) {
        Glide.with(itemView.getContext())
                .load(person.getImageResource())
                .into(personImage);
        username.setText(person.getUsername());
        fullName.setText(person.getFullName());
        followerCount.setText(person.getFollowerCount());
    }


}
