package com.example.myapplication.ExTraining.activity.fragment;


import android.content.ClipData;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.ExTraining.activity.base.BaseFragment;
import com.example.myapplication.ExTraining.db.DatabaseHelper;
import com.example.myapplication.ExTraining.model.Work;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    @BindView(R.id.lv_work)
    ListView lvWork;

    List<Work> workList;
    public static final String TAG = "WorkFragment";

    public WorkFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_work;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, getView());
        lvWork.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        DatabaseHelper db = DatabaseHelper.getInstance(getActivity());
        workList = db.getAllWork();
        ArrayAdapter<Work> arrayAdapter = new ArrayAdapter<Work>(getActivity(), android.R.layout.simple_list_item_1, workList);
        lvWork.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: click vào rồi nè");
        switch (v.getId()) {
            case R.id.lv_work:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
