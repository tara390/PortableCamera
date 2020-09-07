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
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;


public class Orientationbottomsheet extends BottomSheetDialogFragment implements View.OnClickListener {

    TextView tvauto, tvportrait, tvlandscape, bcancel;
    private ItemClickListeneror mListener;

    public static Orientationbottomsheet newInstance() {
        return new Orientationbottomsheet();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppBottomSheetDialogTheme);


        return inflater.inflate(R.layout.fragment_orientationbottomsheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }


    private void init(View v) {

        bcancel = v.findViewById(R.id.bcancel);
        tvauto = v.findViewById(R.id.tvauto);
        tvlandscape = v.findViewById(R.id.tvlandscape);
        tvportrait = v.findViewById(R.id.tvportrait);


        tvauto.setOnClickListener(this);
        tvlandscape.setOnClickListener(this);
        tvportrait.setOnClickListener(this);

        bcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListeneror) {
            mListener = (ItemClickListeneror) context;
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
        TextView tvorientationtype = (TextView) v;
        mListener.onItemClickor(tvorientationtype.getText().toString());
        dismiss();

    }

    public interface ItemClickListeneror {
        void onItemClickor(String item);
    }
}