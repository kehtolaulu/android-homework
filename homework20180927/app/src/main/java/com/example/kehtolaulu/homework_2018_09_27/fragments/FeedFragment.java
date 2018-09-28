package com.example.kehtolaulu.homework_2018_09_27.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kehtolaulu.homework_2018_09_27.R;

import static com.example.kehtolaulu.homework_2018_09_27.R.*;
import static com.example.kehtolaulu.homework_2018_09_27.R.layout.fragment_feed;


public class FeedFragment extends Fragment {

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(fragment_feed, container, false);
    }

}
