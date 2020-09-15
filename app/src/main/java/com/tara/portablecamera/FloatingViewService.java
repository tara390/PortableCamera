package com.tara.portablecamera;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloatingViewService extends Service {

    private WindowManager mWindowManager;
    private View mFloatingView;
    Boolean isRotate = false;

    ImageView fabstart,fabhome,fabsettings,close_btn;

    public FloatingViewService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();



        mFloatingView = LayoutInflater.from(this).inflate(R.layout.layout_floating_widget, null);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);


        //Specify the view position
        params.gravity = Gravity.TOP | Gravity.LEFT;        //Initially view will be added to top-left corner
        params.x = 0;
        params.y = 100;

        //Add the view to the window
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);




        close_btn=mFloatingView.findViewById(R.id.close_btn);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSelf();
            }
        });


        fabsettings=mFloatingView.findViewById(R.id.fabsetting);
        fabhome=mFloatingView.findViewById(R.id.fabhoms);
        fabstart=mFloatingView.findViewById(R.id.fabstart);


        fabstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent videostart=new Intent(FloatingViewService.this,VideoStartPlayer.class);
                videostart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(videostart);


            }
        });

        fabhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home=new Intent(FloatingViewService.this,MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);

            }
        });



        fabsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings=new Intent(FloatingViewService.this,SettingActivity.class);
                settings.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(settings);

            }
        });










        ViewAnimation.init(fabsettings);
        ViewAnimation.init(fabhome);
        ViewAnimation.init(fabstart);



        mFloatingView.findViewById(R.id.openVideo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                v.setOnTouchListener(new View.OnTouchListener() {
                    private int initialX;
                    private int initialY;
                    private float initialTouchX;
                    private float initialTouchY;
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:

                                //remember the initial position.
                                initialX = params.x;
                                initialY = params.y;

                                //get the touch location
                                initialTouchX = event.getRawX();
                                initialTouchY = event.getRawY();
                                return true;
                            case MotionEvent.ACTION_UP:
                                int Xdiff = (int) (event.getRawX() - initialTouchX);
                                int Ydiff = (int) (event.getRawY() - initialTouchY);


                                //The check for Xdiff <10 && YDiff< 10 because sometime elements moves a little while clicking.
                                //So that is click event.
                                if (Xdiff < 10 && Ydiff < 10) {
                                    if (isViewCollapsed(v)) {
                                        //When user clicks on the image view of the collapsed layout,
                                        //visibility of the collapsed layout will be changed to "View.GONE"
                                        //and expanded view will become visible.


                                    }
                                }
                                return true;
                            case MotionEvent.ACTION_MOVE:
                                //Calculate the X and Y coordinates of the view.
                                params.x = initialX + (int) (event.getRawX() - initialTouchX);
                                params.y = initialY + (int) (event.getRawY() - initialTouchY);


                                //Update the layout with new X & Y coordinate
                                mWindowManager.updateViewLayout(mFloatingView, params);
                                return true;
                        }
                        return true;
                    }
                });




            //    return true;
            }
        });

      //  fabopenVideo=mFloatingView.findViewById(R.id.openVideo);






    }

    private boolean isViewCollapsed(View v) {
        isRotate = ViewAnimation.rotateFab(v, !isRotate);
        if (isRotate) {
            ViewAnimation.showIn(fabsettings);
            ViewAnimation.showIn(fabhome);
            ViewAnimation.showIn(fabstart);

        } else {
            ViewAnimation.showOut(fabsettings);
            ViewAnimation.showOut(fabhome);
            ViewAnimation.showOut(fabstart);
        }

        return true;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatingView != null) mWindowManager.removeView(mFloatingView);
    }





    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
