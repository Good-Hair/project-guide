package com.example.goodHair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;


import com.example.goodHair.fragments.CreatePostFragment;
import com.example.goodHair.fragments.FeedFragment;
import com.example.goodHair.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        final FragmentManager fragmentManager = getSupportFragmentManager();


        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new FeedFragment();
                switch (item.getItemId()) {
                    case R.id.action_home:
                        //TODO: swap fragment here
                        fragment = new FeedFragment();
                        break;
                    case R.id.action_post:
                        fragment = new CreatePostFragment();
                        break;
                    case R.id.action_profile:
                        //TODO: swap fragment here
                        fragment = new ProfileFragment();
                        break;
                    default: break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        //Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }

}
