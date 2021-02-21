package ru.dmkalvan.inote.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import ru.dmkalvan.inote.R;
import ru.dmkalvan.inote.observe.OnDialogListener;

public class BottomDialogFragment extends BottomSheetDialogFragment {
    private OnDialogListener dialogListener;

    public static BottomDialogFragment newInstance(){
        return new BottomDialogFragment();
    }
     public void setOnDialogListener(OnDialogListener dialogListener){
        this.dialogListener = dialogListener;
     }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        setCancelable(false);

        view.findViewById(R.id.btn_cancel).setOnClickListener(v -> {
            dismissAllowingStateLoss();
            if (dialogListener != null){
                dialogListener.onDialogCancel();
            }
        });
        view.findViewById(R.id.btn_accept).setOnClickListener(v -> {
            dismissAllowingStateLoss();
            if (dialogListener != null){
                dialogListener.onDialogAccept();
            }
        });

        return view;
    }
}
