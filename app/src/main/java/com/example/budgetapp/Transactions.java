package com.example.budgetapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Transactions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        ListView mListView = findViewById(R.id.transactionList);
        TransactionListAdapter adapter = new TransactionListAdapter(this, R.layout.adapter_view_layout, lstAmount);
        mListView.setAdapter(adapter);

        }

    }
}
