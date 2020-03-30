package com.example.budgetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), Dashboard.class));
                        overridePendingTransition(0,0);
                    case R.id.add:
                        startActivity(new Intent(getApplicationContext(), Keyboard.class));
                        overridePendingTransition(0,0);
                    case R.id.transaction:
                        startActivity(new Intent(getApplicationContext(), Transactions.class));
                        overridePendingTransition(0,0);
                  //  case R.id.settings:
                   //     startActivity(new Intent(getApplicationContext(), Setting.class));
                     //   overridePendingTransition(0,0);
                }
                return false;
            }
        });
    }
}
