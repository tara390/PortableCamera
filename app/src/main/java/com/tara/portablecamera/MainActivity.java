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
        private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION = 2084;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {


                //If the draw over permission is not available open the settings screen
                //to grant the permission.
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, CODE_DRAW_OVER_OTHER_APP_PERMISSION);
            } else {


                init();

            }

        }


        private void init() {


            //Floating button
            MainActivity.this.startService(new Intent(MainActivity.this, FloatingViewService.class));




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

            if (requestCode == CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
                //Check if the permission is granted or not.
                if (resultCode == RESULT_OK) {
                    init();
                } else { //Permission is not available
                    Toast.makeText(this,
                            "Draw over other app permission not available. Closing the application",
                            Toast.LENGTH_SHORT).show();

                    finish();
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
