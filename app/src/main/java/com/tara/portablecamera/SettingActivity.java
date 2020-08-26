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
    TextView tvvideohd, tvvideomedium, tvvideolow;
    String videohd, videolow, videomeddium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);

        videohd = getIntent().getStringExtra("videoHD");
        videolow = getIntent().getStringExtra("video");
        videomeddium = getIntent().getStringExtra("videoMedium");


        init();
        getIntentData();
    }

    private void getIntentData() {



            tvvideohd.setText(videohd);
            tvvideohd.setVisibility(View.VISIBLE);
            tvvideomedium.setVisibility(View.GONE);
            tvvideolow.setVisibility(View.GONE);





    }


    private void init() {

        tvvideohd = findViewById(R.id.tvvideohd);
        tvvideomedium = findViewById(R.id.tvvideomedium);
        tvvideolow = findViewById(R.id.tvvideolow);

        rvresolution = findViewById(R.id.rvresolution);
        rvvideoquality = findViewById(R.id.rvvideoquality);
        rvorientation = findViewById(R.id.rvorientation);


        rvorientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orientationbottomsheet = new Orientationbottomsheet();

                orientationbottomsheet.show(getSupportFragmentManager(), "Orientation");


            }
        });

        rvvideoquality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoquality = new Videoqualitybottomsheet();
                videoquality.show(getSupportFragmentManager(), "Video Quality");


            }
        });

        rvresolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "Resolution");


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