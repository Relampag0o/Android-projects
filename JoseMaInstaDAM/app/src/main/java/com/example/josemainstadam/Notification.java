package com.example.josemainstadam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.example.josemainstadam.ui.NewAdapter;
import com.example.josemainstadam.ui.NewItem;
import com.example.josemainstadam.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class Notification extends Fragment {
    List<NewItem> newItems;
    List<NewItem> preferedItems;
    Spinner sp;
    Button saveButton;

    public Notification() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        saveButton = view.findViewById(R.id.saveButton);
        sp = view.findViewById(R.id.newsSpinner);
        newItems = new ArrayList<>();
        preferedItems = new ArrayList<>();
        addData();
        NewAdapter newAdapter = new NewAdapter(preferedItems, requireContext());
        recyclerView.setAdapter(newAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chargePreferences();
                // we need to notify the adapter that the list changed!
                newAdapter.notifyDataSetChanged();
            }
        });


    }


    // code to add all the news to the list:


    public void addData() {

        newItems.add(new NewItem(R.drawable.atomic, "The Wonders of Quantum Physics", "Quantum physics is a fascinating field that challenges our understanding of the universe.", "Alice Johnson", Category.SCIENCE));
        newItems.add(new NewItem(R.drawable.sport, "The Thrill of the Soccer Season", "The soccer season is in full swing, with teams battling it out for the top spot.", "Bob Smith", Category.SPORTS));
        newItems.add(new NewItem(R.drawable.ai, "The Future of Tech", "Stay updated with the latest tech news and trends.", "Charlie Brown", Category.TECHNOLOGY));
        newItems.add(new NewItem(R.drawable.health, "Health and Wellness", "Get the latest news and advice on health, nutrition, fitness, and more.", "David Johnson", Category.HEALTH));
        newItems.add(new NewItem(R.drawable.travel, "Travel the World", "Discover the beauty of the world. Get travel tips, guides, and inspiring stories from experienced travelers.", "Eva Green", Category.TRAVEL));
        newItems.add(new NewItem(R.drawable.finance, "Finance and Economy", "Stay informed with the latest news on the economy, personal finance, and investment strategies.", "Frank White", Category.FINANCE));
        newItems.add(new NewItem(R.drawable.science, "Exploring the Universe", "The universe is vast and full of mysteries. Join us as we explore the cosmos.", "Grace Lee", Category.SCIENCE));
        newItems.add(new NewItem(R.drawable.sport, "Basketball Season Highlights", "Catch up on the highlights from this basketball season.", "Harry Potter", Category.SPORTS));
        newItems.add(new NewItem(R.drawable.ai, "Advancements in AI", "Artificial Intelligence is transforming the way we live and work.", "Ivy Smith", Category.TECHNOLOGY));
        newItems.add(new NewItem(R.drawable.health, "Mental Health Matters", "Understanding mental health is crucial in today's fast-paced world.", "Jack Brown", Category.HEALTH));
        newItems.add(new NewItem(R.drawable.travel, "Adventure Awaits", "Embark on an adventure of a lifetime with our travel guides.", "Kate Johnson", Category.TRAVEL));
        newItems.add(new NewItem(R.drawable.finance, "Investing 101", "Learn the basics of investing and grow your wealth.", "Leo White", Category.FINANCE));
        newItems.add(new NewItem(R.drawable.science, "The Magic of Chemistry", "Chemistry is a fascinating field with endless possibilities.", "Mia Green", Category.SCIENCE));
        newItems.add(new NewItem(R.drawable.sport, "Tennis Tournaments", "Stay updated with the latest tennis tournaments around the world.", "Nick Smith", Category.SPORTS));
        newItems.add(new NewItem(R.drawable.ai, "The Rise of Cryptocurrencies", "Cryptocurrencies are changing the financial landscape.", "Olivia Brown", Category.TECHNOLOGY));
        newItems.add(new NewItem(R.drawable.health, "Healthy Eating", "Discover delicious and nutritious recipes for a healthier lifestyle.", "Peter Johnson", Category.HEALTH));
        newItems.add(new NewItem(R.drawable.travel, "Exploring National Parks", "Experience the beauty of nature by visiting national parks.", "Queenie White", Category.TRAVEL));
        newItems.add(new NewItem(R.drawable.finance, "Understanding Taxes", "Demystify taxes with our comprehensive guides.", "Robert Green", Category.FINANCE));
        newItems.add(new NewItem(R.drawable.atomic, "The World of Biology", "Dive into the world of biology and discover the secrets of life.", "Sophia Smith", Category.SCIENCE));
        newItems.add(new NewItem(R.drawable.sport, "The Olympics", "Catch up on the latest news from the Olympics.", "Tom Brown", Category.SPORTS));


    }

    // code to show the selected preferences:

    public void chargePreferences() {
        preferedItems.clear();
        String selected = sp.getSelectedItem().toString();
        for (NewItem card : newItems) {
            if (selected.equals(card.getCat().toString())) {
                preferedItems.add(card);
            }
        }
    }

}