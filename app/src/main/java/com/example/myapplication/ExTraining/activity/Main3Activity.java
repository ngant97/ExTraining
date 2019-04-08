package com.example.myapplication.ExTraining.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

import com.example.myapplication.ExTraining.activity.base.BaseActivity;
import com.example.myapplication.ExTraining.activity.fragment.AddWorkFragment;
import com.example.myapplication.ExTraining.activity.fragment.WorkFragment;
import com.example.myapplication.R;

public class Main3Activity extends BaseActivity {

    FragmentManager fm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main3;
    }

    @Override
    public void initView() {
        fm = getSupportFragmentManager();
        FragmentTransaction ft_add = fm.beginTransaction();
        ft_add.add(R.id.fm_main, new WorkFragment());
        ft_add.commit();

    }
}
