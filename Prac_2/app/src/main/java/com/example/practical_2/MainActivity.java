package com.example.practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=findViewById(R.id.et1);
        num2=findViewById(R.id.et2);
        bt1=findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ans=Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString());

                Toast.makeText(MainActivity.this, "Your addition is "+ans, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
