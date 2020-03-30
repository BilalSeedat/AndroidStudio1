package com.example.budgetapp;

import android.os.Parcel;
import android.os.Parcelable;

public class OneTransaction implements Parcelable{
    private double amount;
    private String category;


    public OneTransaction(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return this.amount + " -- " + this.category;
    }

    protected OneTransaction(Parcel in) {
        amount = in.readDouble();
        category = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(amount);
        dest.writeString(category);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<OneTransaction> CREATOR = new Parcelable.Creator<OneTransaction>() {
        @Override
        public OneTransaction createFromParcel(Parcel in) {
            return new OneTransaction(in);
        }

        @Override
        public OneTransaction[] newArray(int size) {
            return new OneTransaction[size];
        }
    };
}
