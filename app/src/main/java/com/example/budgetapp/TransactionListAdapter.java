package com.example.budgetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class TransactionListAdapter extends ArrayAdapter<OneTransaction> {
    private static final String TAG = "TransactionListAdapter";
    private Context mContext;
    int mResource;

    public TransactionListAdapter(Context context, int resource, ArrayList<OneTransaction> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    private static class ViewHolder{
        TextView amount;
        TextView category;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        double amount = getItem(position).getAmount();
        String category = getItem(position).getCategory();

        OneTransaction transaction = new OneTransaction(amount,category);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvAmount = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvCategory= (TextView) convertView.findViewById(R.id.textView2);

        tvAmount.setText((int) amount);
        tvCategory.setText(category);

        return convertView;

    }
}
