
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


public class BottomSheetdialog extends BottomSheetDialogFragment implements View.OnClickListener {

    TextView tv19201080,tv1280720,textView5,button;
    public static final String TAG = "ActionBottomDialog";
    private ItemClickListener mListener;

    public static BottomSheetdialog newInstance() {
        return new BottomSheetdialog();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.AppBottomSheetDialogTheme);


        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }





    private void init(View v) {

        tv19201080=v.findViewById(R.id.tv19201080);
        tv1280720=v.findViewById(R.id.tv1280720);
        textView5=v.findViewById(R.id.tv800480);

        tv19201080.setOnClickListener(this);
        tv1280720.setOnClickListener(this);
        textView5.setOnClickListener(this);


        button=v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListener) {
            mListener = (ItemClickListener) context;
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
        TextView tvresolutionnumber = (TextView) v;
        mListener.onItemClick(tvresolutionnumber.getText().toString());
        dismiss();
    }

    public interface ItemClickListener {
        void onItemClick(String item);


    }
}
