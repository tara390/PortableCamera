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


public class BottomSheetDialog extends BottomSheetDialogFragment {

    TextView tv19201080,tv1280720,textView5;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.AppBottomSheetDialogTheme);
        View v = inflater.inflate(R.layout.fragment_bottom_sheet_dialog,
                container, false);
        init(v);

        return v;
    }

    private void init(View v) {

        tv19201080=v.findViewById(R.id.tv19201080);
        tv1280720=v.findViewById(R.id.tv1280720);
        textView5=v.findViewById(R.id.textView5);
    }
}