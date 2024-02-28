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

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    // This class is the adapter for the recycler view.
    // It is responsible for creating the view holder and binding the data to the view holder.
    private Context context;
    // This is the context of the activity.
    private List<Person> persons;

    // This is the list of persons that will be displayed in the recycler view.

    public PersonAdapter(Context context, List<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_card, parent, false);
        return new PersonViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.bindData(person);

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


}

