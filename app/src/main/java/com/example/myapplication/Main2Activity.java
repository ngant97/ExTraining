package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {
    Button btSetColor;
    Button btClear;
    TextView tvText;
    RadioButton rbRed;
    RadioButton rbWhite;
    RadioButton rbBlue;

    private static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btSetColor = findViewById(R.id.bt_setColor);
        btClear = findViewById(R.id.bt_clear);
        rbRed = findViewById(R.id.rb_red);
        rbWhite = findViewById(R.id.rb_white);
        rbBlue = findViewById(R.id.rb_blue);
        tvText= findViewById(R.id.tv_text);
        btSetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbRed.isChecked()) {
                    tvText.setTextColor(Color.parseColor("#C50023"));
                }
                if(rbWhite.isChecked()){
                    tvText.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if(rbBlue.isChecked()){
                    tvText.setTextColor(Color.parseColor("#205AA7"));
                }
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvText.setTextColor(Color.parseColor("#000000"));
            }
        });
        rbRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbWhite.setChecked(false);
                rbBlue.setChecked(false);
            }
        });
        rbWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbRed.setChecked(false);
                rbBlue.setChecked(false);
            }
        });
        rbBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbWhite.setChecked(false);
                rbRed.setChecked(false);
            }
        });
    }
}
