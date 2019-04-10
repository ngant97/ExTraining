package com.example.myapplication.ExTraining.activity.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.ExTraining.activity.base.BaseFragment;
import com.example.myapplication.ExTraining.custom.view.ColorView;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends BaseFragment {

    private final static String TAG = "ColorFragment";

    @BindView(R.id.cl_test)
    ColorView colorView;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_color;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, getActivity());
    }

    @Override
    public void initData() {

    }


}
