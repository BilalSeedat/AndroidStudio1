package com.example.budgetapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Calendar;

public class Setting extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView pictureChanger;
    Button uploadImage;
    EditText nameChange;
    private Button saveChanges;

    public static final String SHARED_PREFS = "sharedPreferences";
    public static final String INPUT = "input";
    public static final String NEW_DATE = "date";

    TextView one;
    Button mBtn;

    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        pictureChanger = (ImageView) findViewById(R.id.PictureChanger);
        uploadImage = (Button) findViewById(R.id.PictureButton);

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.PictureButton:
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE );
                        break;
                }

            }

        });

        nameChange = (EditText) findViewById(R.id.NameChanger);
        saveChanges = (Button) findViewById(R.id.savechanges);

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                openDashboard();
            }
        });

        one = (TextView) findViewById(R.id.CurrentDateOfBirth);
        mBtn = (Button)  findViewById(R.id.DateChanger);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c= Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Setting.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        one.setText(dayOfMonth + "/" + (month+1) + "/" + year);

                    }
                }, day, month, year );
                dpd.show();
                dpd.updateDate(year,month,day);
            }
        });

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String uno = one.getText().toString();
        String two = mBtn.getText().toString();

        editor.putString(INPUT, uno);
        editor.putString(NEW_DATE, two);
        editor.apply();

    }

    public void openDashboard(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

}
