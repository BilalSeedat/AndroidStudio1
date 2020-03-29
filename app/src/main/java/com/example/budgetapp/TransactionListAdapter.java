package com.example.budgetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TransactionListAdapter extends ArrayAdapter<OneTransaction> {
    private static final String TAG = "TransactionListAdapter";
    private Context mContext;
    int mResource;
    ListView mListView = (ListView) findViewbyId(R.id.transactionList);

    private Object findViewbyId(int transactionList) {
    }

    public TransactionListAdapter(Keyboard keyboard, int adapter_view_layout, ArrayList<OneTransaction> lstAmount) {
        super(keyboard, adapter_view_layout, lstAmount);
        this.mContext = mContext;
        this.mResource = mResource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        double amount = getItem(position).getAmount();
        String category = getItem(position).getCategory();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvAmount = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvCategory = (TextView) convertView.findViewById(R.id.textView2);

        tvAmount.setText((int) amount);
        tvCategory.setText(category);

        return convertView;

    }
}
