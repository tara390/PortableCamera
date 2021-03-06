package com.tara.portablecamera;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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


public class Videoqualitybottomsheet extends BottomSheetDialogFragment implements View.OnClickListener {

    TextView tvhd, tvvideomedium, tvvideolow, btncancel;
    private ItemClickListenerv mListener;

    public static Videoqualitybottomsheet newInstance() {
        return new Videoqualitybottomsheet();
    }

    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppBottomSheetDialogTheme);

            return inflater.inflate(R.layout.fragment_videoqualitybottomsheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }


    private void init(View v) {


        btncancel = v.findViewById(R.id.tvcancel);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        tvhd = v.findViewById(R.id.tvhd);
        tvvideolow = v.findViewById(R.id.tvLow);
        tvvideomedium = v.findViewById(R.id.tvmedium);

        tvhd.setOnClickListener(this);
        tvvideolow.setOnClickListener(this);
        tvvideomedium.setOnClickListener(this);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Videoqualitybottomsheet.ItemClickListenerv) {
            mListener = (Videoqualitybottomsheet.ItemClickListenerv) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ItemClickListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(View v) {

        TextView tvvideoq = (TextView) v;
        mListener.onItemClickv(tvvideoq.getText().toString());
        dismiss();

    }
    public interface ItemClickListenerv {
        void onItemClickv(String item1);
    }
}