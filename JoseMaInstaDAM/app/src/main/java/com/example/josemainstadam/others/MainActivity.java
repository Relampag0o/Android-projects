package com.example.josemainstadam.others;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;

import com.example.josemainstadam.R;
import com.example.josemainstadam.databinding.ActivityMainBinding;
import com.example.josemainstadam.fav.FavFragment;
import com.example.josemainstadam.news.NewFragment;
import com.example.josemainstadam.search.SearchFragment;
import com.example.josemainstadam.home.HomeFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // VARIABLES FOR THE NAVIGATION:
    private AppBarConfiguration mAppBarConfiguration;

    // WE USE THE BINDING AS A WAY OF RETRIEVING ELEMENTS INSTEAD USING VIEW.FINDELEMENTBYID..
    private ActivityMainBinding binding;

    // VARIABLES FOR THE TOOLBAR:
    SpannableString spannableString;

    // TYPEFACE FOR THE FONT
    Typeface typeface;

    // TOOLBAR
    Toolbar toolbar;

    // FRAGMENT
    Fragment f;


    // ONCREATE METHOD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // this is the application code after creating the proyect with the bar.
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        // code for the nav
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        // until this point.

        // MY CODE:
        // MAKING SURE THE HOME FRAGMENT IS CHARGED BY DEFAULT:
        loadFragment(new HomeFragment());
        toolbar = binding.appBarMain.toolbar;

        setupToolbar("           InstaDAM");


        // instances
        BottomNavigationView bottomNavigation = findViewById(R.id.menuBot);
        // MANAGING THE BOTTOM MENU OPTIONS:
        bottomNavigation.setOnItemSelectedListener(item -> {

            // CODE TO MANAGE THE DOT
            for (int i = 0; i < bottomNavigation.getMenu().size(); i++) {
                bottomNavigation.removeBadge(bottomNavigation.getMenu().getItem(i).getItemId());
            }

            // THE LOOP REMOVES EVERY BADGE THAT WAS ALREADY IN.

            BadgeDrawable badge = bottomNavigation.getOrCreateBadge(item.getItemId());
            badge.setBackgroundColor(Color.WHITE);
            badge.setVisible(true);

            // WE SET A NEW BADGE TO THE CURRENT ITEM

            int idItem = item.getItemId();
            String title = " ";
            f = null;

            if (idItem == R.id.action_home) {
                f = new HomeFragment();
                title = "          InstaDAM";
            } else if (idItem == R.id.action_search) {
                f = new SearchFragment();
                title = "         Search friends";
            } else if (idItem == R.id.action_notifications) {
                f = new NewFragment();
                title = "             News";
            } else if (idItem == R.id.action_messages) {
                f = new FavFragment();
                title = "           Your likes";
            }

            // IF THE FRAGMENT IS NOT NULL, WE LOAD IT AND SET THE TITLE.
            if (f != null) {
                loadFragment(f);
                setupToolbar(title);
            }

            return true;
        });


    }

    // METHOD TO CHANGE THE FRAGMENTS:
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }


    // navigation methods from default DO NOT DELETE!!!
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // navigation methods from default DO NOT DELETE!!!!
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    // METHOD TO CONVERT THE XML INTO A BITMAP SO I CAN MAKE IT ROUNDED!

    public Bitmap getBitmapFromVectorDrawable(int drawableId) {
        Drawable drawable = getResources().getDrawable(drawableId);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof VectorDrawable) {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } else {
            throw new IllegalArgumentException("unsupported drawable type");
        }
    }


    /**
     * METHOD TO SETUP NECESSARY THINGS FOR THE TOOLBAR:
     * THE ROUNDED PROFILE PIC AND THE TITLE BASED ON THE FRAGMENT.
     *
     * @param text THIS TEXT IS THE TITTLE THAT WE WANT TO SET FROM THE FRAGMENT.
     */
    private void setupToolbar(String text) {
        toolbar = binding.appBarMain.toolbar;

        // CREATION OF THE PROFILE PICTURE IN THE TOP
        Bitmap bitmap = getBitmapFromVectorDrawable(R.drawable.programming);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 170, 170, true);
        Drawable userImage = new BitmapDrawable(getResources(), resizedBitmap);
        toolbar.setNavigationIcon(userImage);

        // CREATION OF THE FONT INSTADAM:
        typeface = ResourcesCompat.getFont(this, R.font.instadamfont);
        spannableString = new SpannableString(text);
        spannableString.setSpan(new TypefaceSpan(typeface), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int fontSizeInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 28, getResources().getDisplayMetrics());
        spannableString.setSpan(new AbsoluteSizeSpan(fontSizeInPixels), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        toolbar.setTitle(spannableString);
    }

    // NAVIGATION METHODS:
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent profileIntent = new Intent(MainActivity.this, ProfileIntent.class);
            startActivity(profileIntent);

        } else if (id == R.id.nav_settings) {
            Log.d("Navigation", "Settings clicked");
        } else if (id == R.id.nav_notifications) {
            Log.d("Notifications", "notifications clicked");

        }

        // CLOSE THE DRAWER
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}