package com.example.josemainstadam.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.example.josemainstadam.R;

import java.util.ArrayList;
import java.util.List;

public class NewFragment extends Fragment {
    // VARIABLES:
    // list of new items:
    List<NewItem> newItems;

    // list of prefered items:
    List<NewItem> preferedItems;
    // spinner:
    Spinner sp;
    // save button:
    Button saveButton;

    // constructor:
    public NewFragment() {
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
        this.saveButton = view.findViewById(R.id.saveButton);
        this.sp = view.findViewById(R.id.newsSpinner);
        this.newItems = new ArrayList<>();
        this.preferedItems = new ArrayList<>();
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

        newItems.add(new NewItem(R.drawable.atomic, "The Wonders of Quantum Physics", "Quantum physics is a fascinating field that challenges our understanding of the universe.", "Alice Johnson", Category.SCIENCE,"https://as2.ftcdn.net/v2/jpg/05/79/64/29/1000_F_579642932_z3CUhYjjYWcGIWJtO30pMyYVFpDyoa1W.jpg"));
        newItems.add(new NewItem(R.drawable.sport, "The Thrill of the Soccer Season", "The soccer season is in full swing, with teams battling it out for the top spot.", "Bob Smith", Category.SPORTS,"https://storage.googleapis.com/pod_public/1300/169544.jpg"));
        newItems.add(new NewItem(R.drawable.ai, "The Future of Tech", "Stay updated with the latest tech news and trends.", "Charlie Brown", Category.TECHNOLOGY,"https://www.globalfocusmagazine.com/wp-content/uploads/2020/02/Engaging_with_technology-scaled.jpg"));
        newItems.add(new NewItem(R.drawable.health, "Health and Wellness", "Get the latest news and advice on health, nutrition, fitness, and more.", "David Johnson", Category.HEALTH,"https://images.everydayhealth.com/homepage/health-topics-2.jpg?sfvrsn=757370ae_2"));
        newItems.add(new NewItem(R.drawable.travel, "Travel the World", "Discover the beauty of the world. Get travel tips, guides, and inspiring stories from experienced travelers.", "Eva Green", Category.TRAVEL,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/4f/7d/fc/caption.jpg?w=1200&h=1200&s=1"));
        newItems.add(new NewItem(R.drawable.finance, "Finance and Economy", "Stay informed with the latest news on the economy, personal finance, and investment strategies.", "Frank White", Category.FINANCE,"data:image/jpeg;base64,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"));
        newItems.add(new NewItem(R.drawable.science, "Exploring the Universe", "The universe is vast and full of mysteries. Join us as we explore the cosmos.", "Grace Lee", Category.SCIENCE,"https://plustatic.com/3032/conversions/fisica-cuantica-large.jpg"));
        newItems.add(new NewItem(R.drawable.sport, "Basketball Season Highlights", "Catch up on the highlights from this basketball season.", "Harry Potter", Category.SPORTS,"https://www.timeshighereducation.com/student/sites/default/files/styles/default/public/different_sports.jpg?itok=CW5zK9vp"));
        newItems.add(new NewItem(R.drawable.ai, "Advancements in AI", "Artificial Intelligence is transforming the way we live and work.", "Ivy Smith", Category.TECHNOLOGY,"https://www.globalfocusmagazine.com/wp-content/uploads/2020/02/Engaging_with_technology-scaled.jpg"));
        newItems.add(new NewItem(R.drawable.health, "Mental Health Matters", "Understanding mental health is crucial in today's fast-paced world.", "Jack Brown", Category.HEALTH,"https://images.everydayhealth.com/homepage/health-topics-2.jpg?sfvrsn=757370ae_2"));
        newItems.add(new NewItem(R.drawable.travel, "Adventure Awaits", "Embark on an adventure of a lifetime with our travel guides.", "Kate Johnson", Category.TRAVEL,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/4f/7d/fc/caption.jpg?w=1200&h=1200&s=1"));
        newItems.add(new NewItem(R.drawable.finance, "Investing 101", "Learn the basics of investing and grow your wealth.", "Leo White", Category.FINANCE,"https://trabian-canvas-prd-files.s3.amazonaws.com/lacapfcu-org/files/images/blog/blog_budget_1.jpg?VersionId=PQ5TqO4nMQLX.sC0HxEBhqoJ9ti1zojs"));
        newItems.add(new NewItem(R.drawable.science, "The Magic of Chemistry", "Chemistry is a fascinating field with endless possibilities.", "Mia Green", Category.SCIENCE,"https://plustatic.com/3032/conversions/fisica-cuantica-large.jpg"));
        newItems.add(new NewItem(R.drawable.sport, "Tennis Tournaments", "Stay updated with the latest tennis tournaments around the world.", "Nick Smith", Category.SPORTS,"https://www.timeshighereducation.com/student/sites/default/files/styles/default/public/different_sports.jpg?itok=CW5zK9vp"));
        newItems.add(new NewItem(R.drawable.ai, "The Rise of Cryptocurrencies", "Cryptocurrencies are changing the financial landscape.", "Olivia Brown", Category.TECHNOLOGY,"https://www.globalfocusmagazine.com/wp-content/uploads/2020/02/Engaging_with_technology-scaled.jpg"));
        newItems.add(new NewItem(R.drawable.health, "Healthy Eating", "Discover delicious and nutritious recipes for a healthier lifestyle.", "Peter Johnson", Category.HEALTH,"https://images.everydayhealth.com/homepage/health-topics-2.jpg?sfvrsn=757370ae_2"));
        newItems.add(new NewItem(R.drawable.travel, "Exploring National Parks", "Experience the beauty of nature by visiting national parks.", "Queenie White", Category.TRAVEL,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/4f/7d/fc/caption.jpg?w=1200&h=1200&s=1"));
        newItems.add(new NewItem(R.drawable.finance, "Understanding Taxes", "Demystify taxes with our comprehensive guides.", "Robert Green", Category.FINANCE,"https://trabian-canvas-prd-files.s3.amazonaws.com/lacapfcu-org/files/images/blog/blog_budget_1.jpg?VersionId=PQ5TqO4nMQLX.sC0HxEBhqoJ9ti1zojs"));
        newItems.add(new NewItem(R.drawable.atomic, "The World of Biology", "Dive into the world of biology and discover the secrets of life.", "Sophia Smith", Category.SCIENCE,"https://beyondexclamation.com/wp-content/uploads/2020/12/10-1.jpg"));
        newItems.add(new NewItem(R.drawable.sport, "The Olympics", "Catch up on the latest news from the Olympics.", "Tom Brown", Category.SPORTS,"https://www.timeshighereducation.com/student/sites/default/files/styles/default/public/different_sports.jpg?itok=CW5zK9vp"));
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