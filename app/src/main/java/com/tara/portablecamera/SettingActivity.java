package com.tara.portablecamera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class SettingActivity extends AppCompatActivity implements BottomSheetdialog.ItemClickListener, Orientationbottomsheet.ItemClickListeneror, Videoqualitybottomsheet.ItemClickListenerv, CameraViewBottomSheet.ItemClickListenercamera {
    ImageView ivbackbutton;
    RelativeLayout rvresolution, rvvideoquality, rvorientation, rvcamera, rvfilelocation;
    BottomSheetdialog bottomSheetDialog;
    Videoqualitybottomsheet videoquality;
    Orientationbottomsheet orientationbottomsheet;
    TextView tvvideoq, tvorientationtype, tvresolutionnumber, tvcamera, tvfile;
    CameraViewBottomSheet cameraViewBottomSheet;
    Switch swsoundrecord;
    String resolution, videoqa, orientation, camera;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Resolution = "resolution";
    public static final String VideoQuality = "videoquality";
    public static final String Orientation = "orientation";
    public static final String Camera = "camera";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);

        init();
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Resolution)){
            tvresolutionnumber.setHint(sharedpreferences.getString(Resolution,""));
        }if (sharedpreferences.contains(VideoQuality)){
            tvvideoq.setHint(sharedpreferences.getString(VideoQuality,""));
        }
        if (sharedpreferences.contains(VideoQuality)){
            tvorientationtype.setHint(sharedpreferences.getString(Orientation,""));
        }
        if (sharedpreferences.contains(Camera)){
            tvcamera.setHint(sharedpreferences.getString(Camera,""));
        }

    }


    private void init() {

        //TextView
        tvvideoq = findViewById(R.id.tvvideoq);
        tvorientationtype = findViewById(R.id.tvorientationtype);
        tvresolutionnumber = findViewById(R.id.tvresolutionnumber);
        tvcamera = findViewById(R.id.tvcamera);
        tvfile = findViewById(R.id.tvfile);

        //Relative Layout
        rvresolution = findViewById(R.id.rvresolution);
        rvvideoquality = findViewById(R.id.rvvideoquality);
        rvorientation = findViewById(R.id.rvorientation);
        rvcamera = findViewById(R.id.rvcamera);
        rvfilelocation = findViewById(R.id.rvfilelocation);


        //Switch Data

        swsoundrecord = findViewById(R.id.swsoundrecord);

        //Relative Layout on click

        rvfilelocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivityForResult(intent, 1);
            }
        });

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

            }
        });

        rvresolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog = new BottomSheetdialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "Resolution");


            }
        });

        rvcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraViewBottomSheet = new CameraViewBottomSheet();
                cameraViewBottomSheet.show(getSupportFragmentManager(), "Camera");

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

        Intent intent = new Intent(SettingActivity.this, MainActivity.class);
        startActivityForResult(intent, 1);
        //finish();
        super.onBackPressed();
    }

    @Override
    public void onItemClick(String item) {

        resolution = item.toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Resolution, resolution);
        editor.apply();
        tvresolutionnumber.setHint(resolution);
    }


    @Override
    public void onItemClickv(String item1) {
        videoqa = item1.toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(VideoQuality, videoqa);
        editor.apply();
        tvvideoq.setHint(videoqa);
    }

    @Override
    public void onItemClickor(String item) {
        orientation = item.toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Orientation, orientation);
        editor.apply();
        tvorientationtype.setHint(orientation);

    }


    @Override
    public void onItemClickcamera(String item) {
        camera = item.toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Camera, camera);
        editor.apply();
        tvcamera.setHint(camera);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);

        String Fpath = data.getDataString();
        tvfile.setHint(Fpath);
    }
}