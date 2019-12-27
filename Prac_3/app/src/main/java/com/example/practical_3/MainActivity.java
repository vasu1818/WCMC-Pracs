package com.example.practical_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText second_et;
    Button show_bt;
    private Toast mToastToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        second_et=findViewById(R.id.second_et);
        show_bt=findViewById(R.id.show_bt);

        show_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(second_et.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "enter input first", Toast.LENGTH_SHORT).show();
                }
                else {

                    showToast(view);
                }
            }
        });


    }

    public void showToast(View view) {
        // Set the toast and duration
        int toastDurationInMilliSeconds = Integer.parseInt(second_et.getText().toString());
        mToastToShow = Toast.makeText(MainActivity.this, "Hello world, I am a toast.", Toast.LENGTH_LONG);

        // Set the countdown to display the toast
        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
            public void onTick(long millisUntilFinished) {
                mToastToShow.show();
            }
            public void onFinish() {
                mToastToShow.cancel();
            }
        };

        // Show the toast and starts the countdown
        mToastToShow.show();
        toastCountDown.start();
    }
}
