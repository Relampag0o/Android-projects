package com.example.josemainstadam;

import android.graphics.Bitmap;
import android.graphics.Canvas;
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
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;

import com.example.josemainstadam.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.josemainstadam.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // this is the application code after creating the proyect with the bar.
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
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
        Toolbar toolbar = binding.appBarMain.toolbar;

        // CREATION OF THE PROFILE PICTURE IN THE TOP
        Bitmap bitmap = getBitmapFromVectorDrawable(R.drawable.programming);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 170, 170, true);
        Drawable userImage = new BitmapDrawable(getResources(), resizedBitmap);
        toolbar.setNavigationIcon(userImage);


        //CREATION OF THE FONT INSTADAM:
        Typeface typeface = ResourcesCompat.getFont(this, R.font.instadamfont);
        SpannableString spannableString = new SpannableString("     instaDAM by Jose M");
        spannableString.setSpan(new TypefaceSpan(typeface), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int fontSizeInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 28, getResources().getDisplayMetrics());
        spannableString.setSpan(new AbsoluteSizeSpan(fontSizeInPixels), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        toolbar.setTitle(spannableString);


        BottomNavigationView bottomNavigation = findViewById(R.id.menuBot);

        // MANAGING THE BOTTOM MENU OPTIONS:
        bottomNavigation.setOnItemSelectedListener(item -> {
            int idItem = item.getItemId();
            Fragment f = null;

            if (idItem == R.id.action_home)
                f = new HomeFragment();
            if (idItem == R.id.action_search)
                f = new Search();
            if (idItem == R.id.action_notifications)
                f = new Notification();

            if (idItem == R.id.action_messages)
                f = new Fav();


            if (f != null)
                loadFragment(f);


            return true;
        });
    }

    // METHOD TO CHANGE THE FRAGMENTS:
    private void loadFragment(Fragment fragment) {
        Log.d("FragmentTag", "Loading fragment: " + fragment.getClass().getSimpleName());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment);
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
}