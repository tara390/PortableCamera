package com.tara.portablecamera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class SettingActivity extends AppCompatActivity {
    ImageView ivbackbutton;
    RelativeLayout rvresolution, rvvideoquality, rvorientation;
    BottomSheetDialog bottomSheetDialog;
    Videoqualitybottomsheet videoquality;
    Orientationbottomsheet orientationbottomsheet;
    TextView tvvideoq, tvorientationtype, tvresolutionnumber;
    String video, orientation, resolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);


        video = getIntent().getStringExtra("video");
        orientation = getIntent().getStringExtra("orientation");
        resolution = getIntent().getStringExtra("resolution");

        init();
        getIntentData();
    }

    private void getIntentData() {


        tvvideoq.setText(video);
        tvorientationtype.setText(orientation);
        tvresolutionnumber.setText(resolution);
    }


    private void init() {

        //TextView
        tvvideoq = findViewById(R.id.tvvideoq);
        tvorientationtype = findViewById(R.id.tvorientationtype);
        tvresolutionnumber = findViewById(R.id.tvresolutionnumber);

        //Relative Layout
        rvresolution = findViewById(R.id.rvresolution);
        rvvideoquality = findViewById(R.id.rvvideoquality);
        rvorientation = findViewById(R.id.rvorientation);


        //Relative Layout on click
        rvorientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orientationbottomsheet = new Orientationbottomsheet();
                orientationbottomsheet.show(getSupportFragmentManager(), "Orientation");
                orientationbottomsheet.setCancelable(false);

            }
        });

        rvvideoquality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoquality = new Videoqualitybottomsheet();
                videoquality.show(getSupportFragmentManager(), "Video Quality");
                videoquality.setCancelable(false);

            }
        });

        rvresolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "Resolution");
                bottomSheetDialog.setCancelable(false);

            }
        });

        ivbackbutton = findViewById(R.id.ivbackbutton);

        ivbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent settings = new Intent(SettingActivity.this, MainActivity.class);
        startActivity(settings);
        finish();

        super.onBackPressed();
    }
}