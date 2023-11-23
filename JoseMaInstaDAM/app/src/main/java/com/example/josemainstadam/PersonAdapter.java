package com.example.josemainstadam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private Context context;
    private List<Person> persons;

    public PersonAdapter(Context context, List<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_card, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.username.setText(person.getUsername());
        holder.fullName.setText(person.getFullName());
        holder.followerCount.setText(person.getFollowerCount() + " followers");
        holder.bindData(persons.get(position));

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        ImageView personImage;
        TextView username;
        TextView fullName;
        TextView followerCount;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            personImage = itemView.findViewById(R.id.userImage);
            username = itemView.findViewById(R.id.username);
            fullName = itemView.findViewById(R.id.fullName);
            followerCount = itemView.findViewById(R.id.followerCount);

        }

        public void bindData(Person person) {
            personImage.setImageResource(person.getImageResource());
            username.setText(person.getUsername());
            fullName.setText(person.getUsername() + " " + person.getFullName());
            followerCount.setText(String.valueOf(person.getFollowerCount()) + " followers");
        }
    }
}

