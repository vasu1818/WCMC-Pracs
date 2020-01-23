package com.example.practical_6;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView off,on;
    Camera camera;
    boolean b=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        off=findViewById(R.id.imOff);
        on=findViewById(R.id.imOn);

        camera=Camera.open();
        final Camera.Parameters parameters =camera.getParameters();



        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b==false){
                    on.setVisibility(View.VISIBLE);

                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();
                    b=true;
                }
                else {
                    on.setVisibility(View.INVISIBLE);

                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    camera.startPreview();
                    b=false;
                }
            }
        });

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b){
                    on.setVisibility(View.INVISIBLE);

                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    camera.startPreview();
                    b=false;
                }
            }
        });



    }
}
