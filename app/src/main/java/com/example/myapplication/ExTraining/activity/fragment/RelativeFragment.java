package com.example.myapplication.ExTraining.activity.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

import androidx.fragment.app.Fragment;

public class RelativeFragment extends Fragment {


    public RelativeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_relative, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {

    }

}
