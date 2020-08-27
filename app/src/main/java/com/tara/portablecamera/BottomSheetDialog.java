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


public class BottomSheetDialog extends BottomSheetDialogFragment {

    TextView tv19201080,tv1280720,textView5,button;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.AppBottomSheetDialogTheme);
        View v = inflater.inflate(R.layout.fragment_bottom_sheet_dialog,
                container, false);
        init(v);
        getAllList();
        return v;
    }

    private void getAllList() {
        ArrayList<String> mylist =new ArrayList<String>();
        mylist.add("1920*1080");
        mylist.add("1280*720");
        mylist.add("800*480");


        final ArrayList<TextView>text=new ArrayList<TextView>(Arrays.asList(tv19201080,tv1280720,textView5));
        for (int i=0;i<mylist.size();i++){
            text.get(i).setText(mylist.get(i));

            final int finalI = i;
            text.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String resolution=text.get(finalI).getText().toString();
                    Intent i=new Intent(getContext(),SettingActivity.class);
                    i.putExtra("resolution",resolution);
                    startActivity(i);
                }
            });

        }

    }

    private void init(View v) {

        tv19201080=v.findViewById(R.id.tv19201080);
        tv1280720=v.findViewById(R.id.tv1280720);
        textView5=v.findViewById(R.id.tv800480);
        button=v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}