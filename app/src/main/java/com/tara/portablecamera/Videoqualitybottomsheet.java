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

import java.util.ArrayList;
import java.util.Arrays;


public class Videoqualitybottomsheet extends BottomSheetDialogFragment {
    String[] videoquality;
    TextView tvhd,tvvideomedium,tvvideolow,btncancel;
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppBottomSheetDialogTheme);
        View v = inflater.inflate(R.layout.fragment_videoqualitybottomsheet,
                container, false);
        init(v);

        getAllList();

        return v;
    }

    private void getAllList() {
        ArrayList<String> mylist =new ArrayList<String>();
        mylist.add("HD");
        mylist.add("Medium");
        mylist.add("Low");


        final ArrayList<TextView>text=new ArrayList<TextView>(Arrays.asList(tvhd,tvvideolow,tvvideomedium));
        for (int i=0;i<mylist.size();i++){
            text.get(i).setText(mylist.get(i));

            final int finalI = i;
            text.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String video=text.get(finalI).getText().toString();
                    Intent i=new Intent(getContext(),SettingActivity.class);
                    i.putExtra("video",video);
                    startActivity(i);
                }
            });

        }

    }

    private void init(View v) {


        btncancel=v.findViewById(R.id.tvcancel);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        tvhd=v.findViewById(R.id.tvhd);
        tvvideolow=v.findViewById(R.id.tvLow);
        tvvideomedium=v.findViewById(R.id.tvmedium);




    }


}