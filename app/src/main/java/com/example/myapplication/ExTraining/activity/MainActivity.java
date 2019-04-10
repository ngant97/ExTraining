package com.example.myapplication.ExTraining.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ExTraining.activity.fragment.ColorFragment;
import com.example.myapplication.ExTraining.activity.fragment.LoanFragment;
import com.example.myapplication.ExTraining.activity.fragment.NetWorkingFragment;
import com.example.myapplication.ExTraining.activity.fragment.WorkFragment;
import com.example.myapplication.R;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btLinearLayout;
    private Button btTableLayout;
    private Button btRelativeLayout;
    private Button btExUi1;
    private Button btRotations;
    private static final String TAG = "MainActivity";
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        btLinearLayout = findViewById(R.id.bt_linearLayout);
        btExUi1 = findViewById(R.id.bt_exUI1);
        btRotations = findViewById(R.id.bt_rotationsAndResetApp);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft_add = fm.beginTransaction();
        ft_add.add(R.id.fm_main_net_working, new ColorFragment());
        ft_add.commit();

        btLinearLayout.setOnClickListener(this);
        btExUi1.setOnClickListener(this);
        btRotations.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {

        //set TH Button click
        switch (view.getId()) {
            case R.id.bt_linearLayout:
                Intent intentLinear = new Intent(this, Main2Activity.class);
                startActivity(intentLinear);
                break;
            case R.id.bt_exUI1:
                Intent intentexUI = new Intent(this, ExUiActivity.class);
                startActivity(intentexUI);
                break;
            case R.id.bt_rotationsAndResetApp:
                Intent intentRotations = new Intent(this, RotationsAndRestartsActivity.class);
                startActivity(intentRotations);
                break;
        }
    }
}
