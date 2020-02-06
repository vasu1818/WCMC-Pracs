package com.example.practical_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=this.getWindow().getDecorView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.color_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1: {
                view.setBackgroundResource(R.color.red);
                break;
            }
            case R.id.item2: {
                view.setBackgroundResource(R.color.green);
                break;
            }
            case R.id.item3: {
                view.setBackgroundResource(R.color.black);
                break;
            }
            case R.id.item4: {
                view.setBackgroundResource(R.color.orange);
                break;
            }
            case R.id.item5: {
                view.setBackgroundResource(R.color.blue);
                break;
            }
            default:{
                return super.onOptionsItemSelected(item);
            }


        }
        return super.onOptionsItemSelected(item);
    }
}
