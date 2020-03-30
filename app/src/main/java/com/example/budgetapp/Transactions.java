package com.example.budgetapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Transactions extends AppCompatActivity {

    private static final String TAG = "Transactions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = findViewById(R.id.transactionList);

        ArrayList<OneTransaction> lstAmount = new ArrayList<>();
        TransactionListAdapter adapter = new TransactionListAdapter(this, R.layout.adapter_view_layout, lstAmount);
        mListView.setAdapter(adapter);
    }
}
