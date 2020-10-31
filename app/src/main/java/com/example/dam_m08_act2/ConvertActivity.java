package com.example.dam_m08_act2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        // Button Go Back.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Get Unit to Convert.
        String unitToConvert = getIntent().getStringExtra("unitToConvert");

        final TextView testText = (TextView) findViewById(R.id.testText);
        testText.setText(unitToConvert);

        // Switch to watch correct Spinner
        final Spinner spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        final Spinner spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        ArrayAdapter<String> spinnersItems;
        String[] valors = new String[0];

        switch (unitToConvert) {
            case "Peso":
                spinnersItems = new ArrayAdapter<String>(ConvertActivity.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.masaSpinner));
                valors = getResources().getStringArray(R.array.valoresMasaSpinner);

                break;
            case "Distancia":
                spinnersItems = new ArrayAdapter<String>(ConvertActivity.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.longitudSpinner));
                valors = getResources().getStringArray(R.array.valoresLongitudSpinner);
                break;
            case "Tiempo":
                spinnersItems = new ArrayAdapter<String>(ConvertActivity.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.temperaturaSpinner));
                valors = getResources().getStringArray(R.array.valoresTempSpinner);

                break;
            case "Bytes":
                spinnersItems = new ArrayAdapter<String>(ConvertActivity.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.byteSpinner));
                valors = getResources().getStringArray(R.array.valoresByteSpinner);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + unitToConvert);
        }
        spinnersItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(spinnersItems);
        spinnerTo.setAdapter(spinnersItems);

        // Doing the convert.

        Button buttonResult = findViewById(R.id.buttonConvertResult);
        TextView resultText = (TextView) findViewById(R.id.resultText);

        String[] finalValors = valors;
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numberToConvert = (TextView) findViewById(R.id.numbertToConvert);
                Float valueSpinnerFrom = Float.valueOf(finalValors[spinnerFrom.getSelectedItemPosition()]);
                Float valueSpinnerTo = Float.valueOf(finalValors[spinnerTo.getSelectedItemPosition()]);
                Float value = Float.valueOf(numberToConvert.getText().toString());
                Float result = ((valueSpinnerFrom * value) / valueSpinnerTo);

                resultText.setText(result + "");
            }
        });
    }
}