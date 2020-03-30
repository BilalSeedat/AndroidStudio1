package com.example.budgetapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class KeyboardActivity extends AppCompatActivity {

    private static final String TAG = "Transactions";

    private Spinner spnCategory;
    private TextView txtCategory;

    Double amnt;

    EditText amntInput;
    Button submit;
    Button back;

    ArrayList<OneTransaction> lstAmount = new ArrayList<>();

    ArrayList<OneTransaction> lstAmount = ArrayList<OneTransaction>();
    Intent intent = new Intent(KeyboardActivity.this, TransactionsActivity.class);
    intent.putParcelableArrayListExtra("ARRAY_LIST_KEY", lsta);
    startActivity(intent);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        Log.d(TAG, "onCreate: Started.");

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
        back = (Button) findViewById(R.id.back);

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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

    }

    public void openDashboard(){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }


    private void showToast(String text){
        Toast.makeText(KeyboardActivity.this, text, Toast.LENGTH_SHORT).show();

    }
}
