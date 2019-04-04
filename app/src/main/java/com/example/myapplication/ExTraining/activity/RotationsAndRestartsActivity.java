package com.example.myapplication.ExTraining.activity;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.ExTraining.activity.base.BaseActivity;
import com.example.myapplication.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RotationsAndRestartsActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.et_message)
    EditText etMessage;
    @BindView(R.id.bt_addMessage)
    Button btAddMessage;
    @BindView(R.id.rl_layoutrotation)
    RelativeLayout relativeLayout;
    @BindView(R.id.tv_message)
    TextView tvMessage;

    @Override
    public int getLayoutId() {
        return R.layout.activity_rotations_and_restarts;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        btAddMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_addMessage:
                tvMessage.setText(etMessage.getText());
                break;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("textMessege", tvMessage.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvMessage.setText(savedInstanceState.getSerializable("textMessege").toString());
    }
}
