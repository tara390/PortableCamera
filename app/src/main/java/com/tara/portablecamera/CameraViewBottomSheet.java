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


public class CameraViewBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {

    TextView tvfrontfacing, tvbackfacing, btncancel;
    private ItemClickListenercamera mListener;

    public static CameraViewBottomSheet newInstance() {
        return new CameraViewBottomSheet();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppBottomSheetDialogTheme);

        return inflater.inflate(R.layout.fragment_camera_view_bottom_sheet, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        //Textview
        tvfrontfacing = view.findViewById(R.id.tvfrontview);
        tvbackfacing = view.findViewById(R.id.tvbackview);

        tvfrontfacing.setOnClickListener(this);
        tvbackfacing.setOnClickListener(this);

        btncancel = view.findViewById(R.id.btncancel);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListenercamera) {
            mListener = (ItemClickListenercamera) context;
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
        TextView tvcamera=(TextView)v;
        mListener.onItemClickcamera(tvcamera.getText().toString());
        dismiss();

    }

    public interface ItemClickListenercamera{
        void onItemClickcamera(String item);
    }
}