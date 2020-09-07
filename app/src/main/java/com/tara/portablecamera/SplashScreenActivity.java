package com.tara.portablecamera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView ivsplashlogo;
    Animation topanim;
    public static final int RequestPermissionCode = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        init();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
               // intent.putExtra(MainActivity.EXTRA_OBJECT, object);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(SplashScreenActivity.this,ivsplashlogo,"imagelogo");
                startActivity(intent, options.toBundle());
            }
        }, 4000);
    }

    private void init() {
        ivsplashlogo=findViewById(R.id.ivsplashlogo);
       topanim = AnimationUtils.loadAnimation(this, R.anim.animation);
        ivsplashlogo.setAnimation(topanim);

    }
}