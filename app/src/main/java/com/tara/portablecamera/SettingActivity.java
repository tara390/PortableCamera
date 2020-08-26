package com.tara.portablecamera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class SettingActivity extends AppCompatActivity {
    ImageView ivbackbutton;
    RelativeLayout rvresolution;
    BottomSheetDialog bottomSheetDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);

        init();
    }

    private void init() {

        rvresolution=findViewById(R.id.rvresolution);

        rvresolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            bottomSheetDialog=new BottomSheetDialog();
            bottomSheetDialog.show(getSupportFragmentManager(),"Resolution");


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

        Intent settings=new Intent(SettingActivity.this,MainActivity.class);
        startActivity(settings);
        finish();

        super.onBackPressed();
    }
}