package com.example.myapplication.ExTraining.activity.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.R;

import androidx.fragment.app.Fragment;

/**

 */
public class LinearFragment extends Fragment implements View.OnClickListener {

    private Button btSetColor;
    private Button btClear;
    private TextView tvText;
    private RadioButton rbRed;
    private RadioButton rbWhite;
    private RadioButton rbBlue;

    public LinearFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_linear, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        btSetColor = view.findViewById(R.id.bt_setColor);
        btClear = view.findViewById(R.id.bt_clear);
        rbRed = view.findViewById(R.id.rb_red);
        rbWhite = view.findViewById(R.id.rb_white);
        rbBlue = view.findViewById(R.id.rb_blue);
        tvText = view.findViewById(R.id.tv_text);

        btSetColor.setOnClickListener(this);
        btClear.setOnClickListener(this);
        rbRed.setOnClickListener(this);
        rbWhite.setOnClickListener(this);
        rbBlue.setOnClickListener(this);

    }

    private void setCheckFalseRb(RadioButton rb1, RadioButton rb2) {
        rb1.setChecked(false);
        rb2.setChecked(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
