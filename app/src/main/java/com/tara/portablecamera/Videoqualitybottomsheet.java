package com.tara.portablecamera;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class Videoqualitybottomsheet extends BottomSheetDialogFragment implements View.OnClickListener {
    String videoHD, videomedium, videlow;
    TextView tvhd, tvmedium, tvlow,btncancel;
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppBottomSheetDialogTheme);
        View v = inflater.inflate(R.layout.fragment_videoqualitybottomsheet,
                container, false);
        init(v);

        return v;
    }

    private void init(View v) {

        tvhd = v.findViewById(R.id.tvhd);
        tvlow = v.findViewById(R.id.tvLow);
        tvmedium = v.findViewById(R.id.tvmedium);

        btncancel=v.findViewById(R.id.tvcancel);
        tvhd.setOnClickListener(this);
        tvmedium.setOnClickListener(this);
        tvlow.setOnClickListener(this);

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


    }

    @Override
    public void onClick(View v) {

        videomedium = tvmedium.getText().toString();
        videoHD = tvhd.getText().toString();
        videlow = tvlow.getText().toString();

        Intent intent = new Intent(getContext(), SettingActivity.class);

        Bundle extras = new Bundle();
        extras.putString("videoHD",videoHD);
        extras.putString("videoMedium",videomedium);
        extras.putString("video",videlow);
        intent.putExtras(extras);
        startActivity(intent);

    }
}