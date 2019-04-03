package com.example.myapplication.ExTraining.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btLinearLayout, btTableLayout, btRelativeLayout, btExUi1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLinearLayout = findViewById(R.id.bt_linearLayout);
        btTableLayout = findViewById(R.id.bt_tableLayout);
        btRelativeLayout = findViewById(R.id.bt_relativeLayout);
        btExUi1 = findViewById(R.id.bt_exUI1);

        btLinearLayout.setOnClickListener(this);
        btTableLayout.setOnClickListener(this);
        btRelativeLayout.setOnClickListener(this);
        btExUi1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Button button = (Button) view;

        switch (button.getId()) {
            case R.id.bt_linearLayout:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.bt_tableLayout:
                Intent intentTable = new Intent(this, TableActivity.class);
                startActivity(intentTable);
                break;
            case R.id.bt_relativeLayout:
                Intent intentRelative = new Intent(this, RelativeActivity.class);
                startActivity(intentRelative);
                break;
            case R.id.bt_exUI1:
                Intent intentexUI = new Intent(this, ExUiActivity.class);
                startActivity(intentexUI);
                break;
        }
    }
}
