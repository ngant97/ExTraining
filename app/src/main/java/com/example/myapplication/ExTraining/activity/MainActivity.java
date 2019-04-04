package com.example.myapplication.ExTraining.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btLinearLayout, btTableLayout, btRelativeLayout, btExUi1;
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
        btTableLayout = findViewById(R.id.bt_tableLayout);
        btRelativeLayout = findViewById(R.id.bt_relativeLayout);
        btExUi1 = findViewById(R.id.bt_exUI1);

        btLinearLayout.setOnClickListener(this);
        btTableLayout.setOnClickListener(this);
        btRelativeLayout.setOnClickListener(this);
        btExUi1.setOnClickListener(this);
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
            case R.id.bt_tableLayout:
                Intent intentTable = new Intent(this, TableActivity.class);
                startActivity(intentTable);
                break;
            case R.id.bt_exUI1:
                Intent intentexUI = new Intent(this, ExUiActivity.class);
                startActivity(intentexUI);
                break;
        }
    }
}
