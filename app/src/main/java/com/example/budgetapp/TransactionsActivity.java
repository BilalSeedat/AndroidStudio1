package com.example.budgetapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TransactionsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        ListView mListView = findViewById(R.id.transactionList);
        TransactionListAdapter adapter = new TransactionListAdapter(this, R.layout.adapter_view_layout, lstAmount);
        mListView.setAdapter(adapter);

        }

    }
}