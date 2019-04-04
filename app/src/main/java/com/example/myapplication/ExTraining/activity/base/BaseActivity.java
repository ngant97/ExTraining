package com.example.myapplication.ExTraining.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity  extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //Hàm show thông báo toast
    public void showToast(String msg) {
        if (msg != null) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        }
    }

    //Hàm chuyển activity
    public void showActivity(Class t) {
        Intent intent = new Intent(this, t);
        startActivity(intent);
    }


}
