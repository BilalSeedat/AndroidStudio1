package com.example.budgetapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Transactions extends AppCompatActivity {

    private static final String TAG = "Transactions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        Log.d(TAG,"onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.transactionList);

        OneTransaction one = new OneTransaction(32.10, "29-03-20", "money");

    }
}
