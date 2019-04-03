package com.example.myapplication;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ExUiActivity extends AppCompatActivity {
    ImageButton imgbtnRed, imgbtnBlue;
    TextView tvText, tvText1;
    ToggleButton tgbtnRed,tgbtnYellow,tgbtnBlue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_ui);
        imgbtnRed = findViewById(R.id.imgbtn_red);
        imgbtnBlue = findViewById(R.id.imgbtn_blue);
        tvText = findViewById(R.id.tv_text);
        tvText1 = findViewById(R.id.tv_text1);
        tgbtnRed = findViewById(R.id.tgbtn_red);
        tgbtnYellow = findViewById(R.id.tgbtn_yellow);
        tgbtnBlue = findViewById(R.id.tgbtn_blue);
        imgbtnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvText.setTextColor(Color.RED);
            }
        });
        imgbtnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvText.setTextColor(Color.BLUE);
            }
        });
        tgbtnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(tgbtnRed.getText().equals("Red")){
                   tgbtnYellow.setChecked(false);
                   tgbtnBlue.setChecked(false);
                   tvText1.setTextColor(Color.RED);
               }
                if(tgbtnRed.getText().equals("Not Red")){
                    tvText1.setTextColor(Color.BLACK);
                }
            }
        });
        tgbtnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgbtnYellow.getText().equals("Yellow")){
                    tgbtnRed.setChecked(false);
                    tgbtnBlue.setChecked(false);
                    tvText1.setTextColor(Color.YELLOW);
                }
                if(tgbtnYellow.getText().equals("Not Yellow")){
                    tvText1.setTextColor(Color.BLACK);
                }
            }
        });
        tgbtnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgbtnBlue.getText().equals("Blue")){
                    tgbtnYellow.setChecked(false);
                    tgbtnRed.setChecked(false);
                    tvText1.setTextColor(Color.BLUE);
                }
                if(tgbtnBlue.getText().equals("Not Blue")){
                    tvText1.setTextColor(Color.BLACK);
                }
            }
        });
    }
}
