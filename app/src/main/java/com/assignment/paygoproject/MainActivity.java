package com.assignment.paygoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.assignment.paygoproject.BottomMenuFragment.FavoriteFragment;
import com.assignment.paygoproject.BottomMenuFragment.HistoryFragment;
import com.assignment.paygoproject.BottomMenuFragment.HomeFragment;
import com.assignment.paygoproject.BottomMenuFragment.MenuFragment;
import com.assignment.paygoproject.BottomMenuFragment.PayFragment;
import com.assignment.paygoproject.database.DBUtils;
import com.assignment.paygoproject.network.HandleApiResponse;
import com.assignment.paygoproject.object.Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);



    }

    HomeFragment homeFragment = new HomeFragment();
    FavoriteFragment favoriteFragment = new FavoriteFragment();
    PayFragment payFragment = new PayFragment();
    HistoryFragment historyFragment = new HistoryFragment();
    MenuFragment menuFragment = new MenuFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                return true;

            case R.id.favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, favoriteFragment).commit();
                return true;

            case R.id.pay:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, payFragment).commit();
                return true;

            case R.id.history:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, historyFragment).commit();
                return true;

            case R.id.menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, menuFragment).commit();
                return true;
        }

        return false;
    }
}