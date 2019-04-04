package com.example.myapplication.ExTraining.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.R;

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btSetColor;
    private Button btClear;
    private TextView tvText;
    private RadioButton rbRed;
    private RadioButton rbWhite;
    private RadioButton rbBlue;

    private static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();

    }

    private void initView() {
        btSetColor = findViewById(R.id.bt_setColor);
        btClear = findViewById(R.id.bt_clear);
        rbRed = findViewById(R.id.rb_red);
        rbWhite = findViewById(R.id.rb_white);
        rbBlue = findViewById(R.id.rb_blue);
        tvText = findViewById(R.id.tv_text);

        btSetColor.setOnClickListener(this);
        btClear.setOnClickListener(this);
        rbRed.setOnClickListener(this);
        rbWhite.setOnClickListener(this);
        rbBlue.setOnClickListener(this);
    }

    private void initData() {

    }

    private void setCheckFalseRb(RadioButton rb1, RadioButton rb2) {
        rb1.setChecked(false);
        rb2.setChecked(false);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: ");
        switch (view.getId()) {
            //Set TH button Click
            case R.id.bt_setColor:
                if (rbRed.isChecked()) {
                    tvText.setTextColor(getResources().getColor(R.color.doSam));
                }
                if (rbWhite.isChecked()) {
                    tvText.setTextColor(getResources().getColor(R.color.white));
                }
                if (rbBlue.isChecked()) {
                    tvText.setTextColor(getResources().getColor(R.color.xanhDuong));
                }
                break;
            case R.id.bt_clear:
                tvText.setTextColor(getResources().getColor(R.color.black));
                break;

            //Set TH Radiobutton Click
            case R.id.rb_red:
                setCheckFalseRb(rbWhite, rbBlue);
                break;
            case R.id.rb_blue:
                setCheckFalseRb(rbWhite, rbRed);
                break;
            case R.id.rb_white:
                setCheckFalseRb(rbRed, rbBlue);
                break;
        }

    }
}
