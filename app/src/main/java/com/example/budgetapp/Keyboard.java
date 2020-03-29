package com.example.budgetapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class Keyboard extends AppCompatActivity {

    private Spinner spnCategory;
    private TextView txtCategory;

    Double amount;

    EditText amntInput;
    Button submit;

    ArrayList<OneTransaction> lstAmount = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        spnCategory = findViewById(R.id.spnCategory);
        txtCategory = findViewById(R.id.txtCategory);

        List<String> category = new ArrayList<>();
        category.add("-- Choose the Category --");
        category.add("Transport");
        category.add("Food & Drink");
        category.add("Direct Debits");
        category.add("Entertainment");
        category.add("Salary");
        category.add("Clothes");
        category.add("Bills");
        category.add("Miscellaneous");

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, category);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategory.setAdapter(categoryAdapter);

        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String yourCategory = spnCategory.getSelectedItem().toString();
                if (!yourCategory.equals("-- Choose the Category --")){
                    txtCategory.setText("You choose "+yourCategory);
                } else {
                    txtCategory.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


        amntInput = (EditText) findViewById(R.id.amntInput);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double amnt = Double.valueOf(amntInput.getText().toString());
                String cat = String.valueOf(spnCategory.getSelectedItem());

                lstAmount.add(new OneTransaction(amnt, cat));
                System.out.println(lstAmount);
                amntInput.setText("");
                showToast(lstAmount.toString());

            }
        });



        List<PieEntry> values = new ArrayList<>();
        values.add(new PieEntry(145,"leisure"));
        values.add(new PieEntry(140, "bills"));
        values.add(new PieEntry(175, "insurance"));
        values.add(new PieEntry(65, "Transport"));
        values.add(new PieEntry(230 , "Food"));
        values.add(new PieEntry(157, "Clothing"));

    }

    private void showToast(String text){
        Toast.makeText(Keyboard.this, text, Toast.LENGTH_SHORT).show();

    }
}
