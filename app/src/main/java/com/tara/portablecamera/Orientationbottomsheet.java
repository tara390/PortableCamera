package com.tara.portablecamera;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


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

        return v;
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