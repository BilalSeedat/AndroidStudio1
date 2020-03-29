package com.example.budgetapp;

public class OneTransaction {
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

    public String toString(){
        return this.amount + " -- " + this.category;
    }
}
