package com.example.myapplication.ExTraining.activity.fragment;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.ExTraining.activity.MainActivity;
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
    @BindView(R.id.bt_Notification)
    Button btNotifi;

    FragmentManager fm = getFragmentManager();

    private NotificationCompat.Builder notBuilder;
    private static final int MY_NOTIFICATION_ID = 12345;
    private static final int MY_REQUEST_CODE = 100;

    public PlaySongFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.notBuilder = new NotificationCompat.Builder(getActivity());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_play_song;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, getView());
        btPlaySong.setOnClickListener(this);
        btStopSong.setOnClickListener(this);
        btNotifi.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_play_song:
                intent = new Intent(getActivity(), PlaySongService.class);
                getActivity().startService(intent);
                break;
            case R.id.bt_stop_song:
                intent = new Intent(getActivity(), PlaySongService.class);
                getActivity().stopService(intent);
                break;
            case R.id.bt_Notification:
                notiButtonClicked(v);
                break;
        }
    }

    public void notiButtonClicked(View view) {
        this.notBuilder.setSmallIcon(R.mipmap.ic_launcher);
        this.notBuilder.setTicker("This is a ticker");
        this.notBuilder.setWhen(System.currentTimeMillis() + 10 * 1000);
        this.notBuilder.setContentTitle("This is title");
        this.notBuilder.setContentText("This is content text ....");

        Intent intent = new Intent(getActivity(), MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), MY_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        this.notBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationService =
                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = notBuilder.build();
        notificationService.notify(MY_NOTIFICATION_ID, notification);

    }
}
