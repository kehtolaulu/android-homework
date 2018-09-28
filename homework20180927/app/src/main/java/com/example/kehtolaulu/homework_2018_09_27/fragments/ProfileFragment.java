package com.example.kehtolaulu.homework_2018_09_27.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kehtolaulu.homework_2018_09_27.EditDialog;
import com.example.kehtolaulu.homework_2018_09_27.Listener;
import com.example.kehtolaulu.homework_2018_09_27.R;

import static android.widget.Toast.LENGTH_SHORT;


public class ProfileFragment extends Fragment implements Listener {
    TextView tvLogin;
    TextView tvEmail;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Button btnEdit = v.findViewById(R.id.btn_edit);
        tvLogin = v.findViewById(R.id.tv_login);
        tvEmail = v.findViewById(R.id.tv_email);
        btnEdit.setOnClickListener(v1 -> {
            EditDialog editDialog = new EditDialog();
            editDialog.show(ProfileFragment.this.getChildFragmentManager(), "dialog");
        });
        return v;
    }

    @Override
    public void mListener(String login, String email) {
        tvLogin.setText(login);
        tvEmail.setText(email);
    }
}
