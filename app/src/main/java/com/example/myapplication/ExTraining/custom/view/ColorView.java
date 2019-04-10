package com.example.myapplication.ExTraining.custom.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


import com.example.myapplication.ExTraining.custom.ColorInterface;
import com.example.myapplication.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import static com.example.myapplication.ExTraining.activity.fragment.WorkFragment.TAG;

public class ColorView extends View implements ColorInterface {

    private String DEFAULT_MAIN_COLOR = "#FF3333";
    private String DEFAULT_PRESS_COLOR = "#6699FF";
    private String mainColor;
    private String pressColor;
    private Paint paint;

    private void initView() {
        if (mainColor == null) {
            mainColor = DEFAULT_MAIN_COLOR;
        }
        if (pressColor == null) {
            pressColor = DEFAULT_PRESS_COLOR;
        }
        setBackgroundColor(mainColor);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackgroundColor(pressColor);
            }
        });
    }

    private void setBackgroundColor(String mainColor) {
        this.setBackgroundColor(Color.parseColor(mainColor));
    }

    public ColorView(Context context) {
        super(context);
    }

    public ColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ColorView);
        mainColor = typedArray.getString(R.styleable.ColorView_cv_main_color);
        pressColor = typedArray.getString(R.styleable.ColorView_cv_color_press);
        typedArray.recycle();
        initView();
    }

    public ColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setMainColor(String color) {
        this.mainColor =color;
    }

    @Override
    public String getMainColor() {
        return this.mainColor;
    }

    @Override
    public void SetPressColor(String color) {
        this.pressColor= color;
    }

    @Override
    public String getPressColor() {
        return this.pressColor;
    }


}
