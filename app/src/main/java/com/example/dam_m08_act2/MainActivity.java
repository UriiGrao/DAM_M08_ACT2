package com.example.dam_m08_act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> firstSpinnerArray = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.firstSpinner));
        firstSpinnerArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner firstSpinner = (Spinner) findViewById(R.id.firstSpinner);
        firstSpinner.setAdapter(firstSpinnerArray);


        nextPage = (Button) findViewById(R.id.buttonNextPage);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPage = new Intent(MainActivity.this, ConvertActivity.class);
                nextPage.putExtra("unitToConvert", firstSpinner.getSelectedItem().toString());
                startActivity(nextPage);
            }
        });
    }
}