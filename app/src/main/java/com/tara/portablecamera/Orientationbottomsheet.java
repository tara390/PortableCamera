package com.tara.portablecamera;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;


public class Orientationbottomsheet extends BottomSheetDialogFragment {

    TextView tvauto,tvportrait,tvlandscape,bcancel;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.AppBottomSheetDialogTheme);
        View v = inflater.inflate(R.layout.fragment_orientationbottomsheet,
                container, false);
        init(v);
        getAllList();

        return v;
    }

    private void getAllList() {
        ArrayList<String> mylist =new ArrayList<String>();
        mylist.add("Auto");
        mylist.add("Landscape");
        mylist.add("Portrait");


        final ArrayList<TextView>text=new ArrayList<TextView>(Arrays.asList(tvauto,tvlandscape,tvportrait));
        for (int i=0;i<mylist.size();i++){
            text.get(i).setText(mylist.get(i));

            final int finalI = i;
            text.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String orientation=text.get(finalI).getText().toString();
                    Intent i=new Intent(getContext(),SettingActivity.class);
                    i.putExtra("orientation",orientation);
                    startActivity(i);
                }
            });

        }

    }

    private void init(View v) {

        bcancel=v.findViewById(R.id.bcancel);
        tvauto=v.findViewById(R.id.tvauto);
        tvlandscape=v.findViewById(R.id.tvlandscape);
        tvportrait=v.findViewById(R.id.tvportrait);

        bcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });



    }


}