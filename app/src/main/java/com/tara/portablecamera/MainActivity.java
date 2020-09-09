package com.tara.portablecamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView ivsetting;
    Boolean isRotate = false;
    FloatingActionButton fabopenVideo, fabsettings, fabhome,fabstart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        init();


    }


    private void init() {


        //Floating button
        fabopenVideo = findViewById(R.id.openVideo);
        fabsettings=findViewById(R.id.fabsetting);
        fabhome=findViewById(R.id.fabhoms);
        fabstart=findViewById(R.id.fabstart);


        fabstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent videostart=new Intent(MainActivity.this,VideoStartPlayer.class);
                videostart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(videostart);
                finish();

            }
        });

        fabhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home=new Intent(MainActivity.this,MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                finish();
            }
        });



        fabsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings=new Intent(MainActivity.this,SettingActivity.class);
                settings.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(settings);
                finish();
            }
        });









        ViewAnimation.init(fabsettings);
        ViewAnimation.init(fabhome);
        ViewAnimation.init(fabstart);
        fabopenVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isRotate = ViewAnimation.rotateFab(view, !isRotate);
                if (isRotate) {
                    ViewAnimation.showIn(fabsettings);
                    ViewAnimation.showIn(fabhome);
                    ViewAnimation.showIn(fabstart);

                } else {
                    ViewAnimation.showOut(fabsettings);
                    ViewAnimation.showOut(fabhome);
                    ViewAnimation.showOut(fabstart);
                }
            }


        });


        //Image function
        ivsetting = findViewById(R.id.ivsetting);
        ivsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setting = new Intent(MainActivity.this, SettingActivity.class);
                setting.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(setting);
                finish();


            }
        });


    }

   /* @Override
    protected void onRestart() {
        finish();
        startActivity(getIntent());
        super.onRestart();
    }*/

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                String result = data.getStringExtra("resolution");
                //ednom.setText(result);

                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "Result not show", Toast.LENGTH_SHORT).show();
                }


            }
        }
    }
}