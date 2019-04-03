package com.example.myapplication.ExTraining.activity;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myapplication.R;

public class ExUiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgbtnRed, imgbtnBlue;
    private TextView tvText, tvText1;
    private ToggleButton tgbtnRed, tgbtnYellow, tgbtnBlue;

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

        imgbtnRed.setOnClickListener(this);
        imgbtnBlue.setOnClickListener(this);
        tgbtnRed.setOnClickListener(this);
        tgbtnYellow.setOnClickListener(this);
        tgbtnBlue.setOnClickListener(this);
    }

    private void setCheckFalseToggleButton(ToggleButton tgbtn1, ToggleButton tgbtn2) {
        tgbtn1.setChecked(false);
        tgbtn2.setChecked(false);
    }

    @Override
    public void onClick(View view) {

        ToggleButton toggleButton = (ToggleButton) view;
        ImageButton imageButton = (ImageButton) view;

        //set TH click ToggleButton
        switch (toggleButton.getId()) {
            case R.id.tgbtn_red:
                if (tgbtnRed.getText().equals("Red")) {
                    setCheckFalseToggleButton(tgbtnYellow, tgbtnBlue);
                    tvText1.setTextColor(Color.RED);
                }
                if (tgbtnRed.getText().equals("Not Red")) {
                    tvText1.setTextColor(Color.BLACK);
                }
                break;
            case R.id.tgbtn_yellow:
                if (tgbtnYellow.getText().equals("Yellow")) {
                    setCheckFalseToggleButton(tgbtnRed, tgbtnBlue);
                    tvText1.setTextColor(Color.YELLOW);
                }
                if (tgbtnYellow.getText().equals("Not Yellow")) {
                    tvText1.setTextColor(Color.BLACK);
                }
                break;
            case R.id.tgbtn_blue:
                if (tgbtnBlue.getText().equals("Blue")) {
                    setCheckFalseToggleButton(tgbtnYellow, tgbtnRed);
                    tvText1.setTextColor(Color.BLUE);
                }
                if (tgbtnBlue.getText().equals("Not Blue")) {
                    tvText1.setTextColor(Color.BLACK);
                }
                break;
            default:
                tvText1.setTextColor(Color.BLACK);
        }

        //set TH click ImageButton
        switch (imageButton.getId()) {
            case R.id.imgbtn_red:
                tvText.setTextColor(Color.RED);
                break;
            case R.id.imgbtn_blue:
                tvText.setTextColor(Color.BLUE);
                break;
            default:
                tvText1.setTextColor(Color.BLACK);
        }
    }
}
