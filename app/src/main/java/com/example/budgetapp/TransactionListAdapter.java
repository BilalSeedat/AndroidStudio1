package com.example.budgetapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TransactionListAdapter extends ArrayAdapter<OneTransaction> {
    private static final String TAG = "TransactionListAdapter";
    private Transactions mContext;
    private int mResource;


    public TransactionListAdapter(Transactions keyboard, int adapter_view_layout, ArrayList<OneTransaction> lstAmount) {
        super(keyboard,adapter_view_layout,lstAmount);
        mContext = keyboard;
        mResource = adapter_view_layout;
    }

    private static class ViewHolder{
        TextView amount;
        TextView category;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        double amount = getItem(position).getAmount();
        String category = getItem(position).getCategory();

        OneTransaction transaction = new OneTransaction(amount,category);

        final View result;

        ViewHolder holder;

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource,parent,false);
            holder = new ViewHolder();
            holder.amount= (TextView) convertView.findViewById(R.id.textView1);
            holder.category= (TextView) convertView.findViewById(R.id.textView2);
            result = convertView;
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        holder.amount.setText((int) transaction.getAmount());
        holder.category.setText(transaction.getCategory());

        return convertView;

    }
}
