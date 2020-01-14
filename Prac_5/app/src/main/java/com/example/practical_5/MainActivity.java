package com.example.practical_5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etLogin,etPassword;
    private Button login,cancel;
    TextView textView;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        login=findViewById(R.id.btLogin);
        cancel=findViewById(R.id.btCancel);
        textView=findViewById(R.id.tvSuccess);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etLogin.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "enter email", Toast.LENGTH_SHORT).show();
                }
                else if(etPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "enter password", Toast.LENGTH_SHORT).show();
                }
                else {
                    if ((etLogin.getText().toString().equals("maulik@gmail.com")|| etLogin.getText().toString().equals("vasu")) && etPassword.getText().toString().equals("1234")){
                        textView.setText("Successful");
                        textView.setBackgroundColor(Color.parseColor("#00FF00"));
                    }
                    else {
                        textView.setText("Login failed");
                        textView.setBackgroundColor(Color.parseColor("#FF0000"));
                        count++;
                        if(count>=3){
                            login.setEnabled(false);
                        }
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                moveTaskToBack(true);
            }
        });
    }
}
