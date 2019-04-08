package com.example.myapplication.ExTraining.activity.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.ExTraining.activity.base.BaseFragment;
import com.example.myapplication.ExTraining.service.PlaySongService;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaySongFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.bt_play_song)
    Button btPlaySong;
    @BindView(R.id.bt_stop_song)
    Button btStopSong;
    private Intent intent;

    public PlaySongFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_play_song;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this,getView());
        btPlaySong.setOnClickListener(this);
        btStopSong.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_play_song:
                intent = new Intent(getActivity(), PlaySongService.class);
                getActivity().startService(intent);
                break;
            case R.id.bt_stop_song:
                intent = new Intent(getActivity(), PlaySongService.class);
                getActivity().stopService(intent);
                break;
        }
    }
}
