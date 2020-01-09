package com.example.practical_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spSource, spDestination;
    EditText etFirst;
    TextView tvsecond;
    Button btnconvert,btnReset;
    int numberOfConverter;
    String source,destination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSource = findViewById(R.id.spSource);
        spDestination = findViewById(R.id.spDestination);
        etFirst = findViewById(R.id.etFirst);
        tvsecond = findViewById(R.id.tvSecond);
        btnconvert=findViewById(R.id.btnConvert);
        btnReset=findViewById(R.id.btnReset);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirst.setText(null);
                tvsecond.setText(null);
            }
        });

        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etFirst.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter valid number", Toast.LENGTH_SHORT).show();
                }
                else {
                    TemeratureConverter convert =
                            new TemeratureConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                    tvsecond.setText(Double.toString(convert.conversion()));
                }

            }
        });

        numberOfConverter=2;
        String [] unit={"celsius","fahrenheit","kelvin"};
        ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,unit);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSource.setAdapter(unitAdapter);
        spDestination.setAdapter(unitAdapter);
        spSource.setSelection(0);
        spDestination.setSelection(1);
        source="celsius";
        destination="fahhrenheit";

        spSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                source=parent.getItemAtPosition(position).toString();
                if(!etFirst.getText().toString().isEmpty()){
                    TemeratureConverter convert =
                            new TemeratureConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                    tvsecond.setText(Double.toString(convert.conversion()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                destination=parent.getItemAtPosition(position).toString();
                if(!etFirst.getText().toString().isEmpty()){
                    TemeratureConverter convert =
                            new TemeratureConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                    tvsecond.setText(Double.toString(convert.conversion()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
