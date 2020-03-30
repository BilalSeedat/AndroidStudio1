package com.example.budgetapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Registered")
public class PieChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        com.github.mikephil.charting.charts.PieChart pieChart = findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        List<PieEntry> values = new ArrayList<>();
        values.add(new PieEntry(300,"leisure"));
        values.add(new PieEntry(140, "bills"));
        values.add(new PieEntry(175, "insurance"));
        values.add(new PieEntry(65, "Transport"));
        values.add(new PieEntry(230 , "Food"));
        values.add(new PieEntry(157, "Clothing"));


        PieDataSet pieDataSet = new PieDataSet(values, "");

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);

        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);


    }
}
