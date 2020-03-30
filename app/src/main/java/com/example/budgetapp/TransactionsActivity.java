package com.example.budgetapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TransactionsActivity extends AppCompatActivity {

    public static String TRANSACTIONS_KEY = "TRANSACTIONS_KEY";

    KeyboardActivity k = new KeyboardActivity();

    ArrayList<OneTransaction> lst = k.lstAmount;

    private ArrayList<OneTransaction> transactions;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);


        lst = savedInstanceState.getParcelableArrayList(TRANSACTIONS_KEY);


        ListView mListView = findViewById(R.id.transactionList);
        TransactionListAdapter adapter = new TransactionListAdapter(this, R.layout.adapter_view_layout, lst);
        mListView.setAdapter(adapter);
    }

    public static void startTransactionsActivity(Context ctx, ArrayList<OneTransaction> args) {
        Intent intent = new Intent(ctx, TransactionsActivity.class);
        intent.putParcelableArrayListExtra(TRANSACTIONS_KEY, args);
        ctx.startActivity(intent);
    }
}
