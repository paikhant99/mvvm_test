package com.paikhantko.mvvm_test.ui.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.DialogFragment;

import com.paikhantko.mvvm_test.R;
import com.paikhantko.mvvm_test.ui.delegates.TextInputDialogDelegate;

public class TextInputDialog extends DialogFragment {

    private final TextInputDialogDelegate mDelegate;
    private AppCompatEditText etSentence;

    public TextInputDialog(final TextInputDialogDelegate delegate) {
        mDelegate = delegate;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_text_input, null);
        initiateViewIds(view);
        builder.setView(view)
                .setPositiveButton(R.string.text_input_dialog_save_btn_name, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!TextUtils.isEmpty(etSentence.getText()))
                            mDelegate.onSaveClick(etSentence.getText().toString());

                    }
                })
                .setNegativeButton(R.string.text_input_dialog_cancel_btn_name, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setCancelable(false);
        return builder.create();
    }

    void initiateViewIds(View view) {
        etSentence = view.findViewById(R.id.et_sentence);
    }
}
