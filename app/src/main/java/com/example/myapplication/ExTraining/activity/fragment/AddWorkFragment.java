package com.example.myapplication.ExTraining.activity.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.ExTraining.activity.Main3Activity;
import com.example.myapplication.ExTraining.activity.base.BaseFragment;
import com.example.myapplication.ExTraining.db.DatabaseHelper;
import com.example.myapplication.ExTraining.model.Work;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddWorkFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.et_nameWork)
    EditText etNameWork;
    @BindView(R.id.et_timeWork)
    EditText etTimeWork;
    @BindView(R.id.bt_addWork)
    Button btAddWork;
    @BindView(R.id.bt_allWork)
    Button btAllWork;

    FragmentManager fm;

    private static final String TAG = "AddWorkFragment";

    public AddWorkFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_add_work;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, getView());
        btAddWork.setOnClickListener(this);
        btAllWork.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_addWork:
                addWork();
                break;
            case R.id.bt_allWork:
                Intent intent = new Intent(getActivity(), Main3Activity.class);
                startActivity(intent);
                break;
        }
    }

    private void addWork() {
        //get Instance
        DatabaseHelper db = DatabaseHelper.getInstance(getActivity());

        //insertData
        db.insertWork(new Work(etNameWork.getText().toString(), Float.parseFloat(etTimeWork.getText().toString())));

        //log
        //loge all word in database
        for (Work w : db.getAllWork()) {
            Log.e(TAG, "onCreate: " + w.getId() + ", " + w.getNameWork() + ", " + w.getTime());
        }
    }

}
