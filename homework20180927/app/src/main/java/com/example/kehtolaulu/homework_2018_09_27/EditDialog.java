package com.example.kehtolaulu.homework_2018_09_27;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class EditDialog extends DialogFragment {
    EditText etLogin;
    EditText etEmail;
    Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = ((Listener) context);
        } catch (RuntimeException exception) {
            throw new RuntimeException(context.toString()
                    + " must implement Listener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_edit, null);
        etLogin = view.findViewById(R.id.et_login);
        etEmail = view.findViewById(R.id.et_email);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setTitle("fill").setView(view)
                .setPositiveButton("save", (dialog, which) -> {
                    String login = etLogin.getText().toString();
                    String email = etEmail.getText().toString();
                    listener.loginEmailRefreshListener(login, email);
                    ((Listener) getParentFragment()).loginEmailRefreshListener(login, email);
                })
                .setNegativeButton("dismiss", (dialog, which) -> dismiss());

        return adb.show();
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
