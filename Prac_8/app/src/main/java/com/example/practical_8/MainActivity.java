package com.example.practical_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment;
                fragment = new fragment1();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.hide(fm.findFragmentById(R.id.fragment2));
                ft.show(fm.findFragmentById(R.id.fragment));
                ft.commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment;
                fragment = new fragment2();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.hide(fm.findFragmentById(R.id.fragment));
                ft.show(fm.findFragmentById(R.id.fragment2));
                ft.commit();
            }
        });


    }
}
