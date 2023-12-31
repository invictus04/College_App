package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.collegeapp.ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this,R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_drawer);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        navigationView.setNavigationItemSelectedListener(this);


        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean result = true;
        if (!toggle.onOptionsItemSelected(item)) {
        }
        return result;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_video) {
            Toast.makeText(this, "Video lectures", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.navigation_developer) {
            Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.navigation_rate) {
            Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show();
        }
//        else if(item.getItemId() == R.id.navigation_about){
//            Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();
//        }
        else if(item.getItemId() == R.id.navigation_ebook) {
           startActivity(new Intent(this, EbookActivity.class));
        }else if(item.getItemId() == R.id.navigation_theme) {
            Toast.makeText(this, "theme....", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.navigation_website) {
            Toast.makeText(this, "website....", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.navigation_share) {
            Toast.makeText(this, "Sharing....", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}