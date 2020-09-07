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
    FloatingActionButton fabopenVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        init();


    }


    private void init() {

        ivsetting = findViewById(R.id.ivsetting);
        fabopenVideo = findViewById(R.id.openVideo);


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