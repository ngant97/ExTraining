package com.example.myapplication.ExTraining.activity.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.ExTraining.activity.base.BaseFragment;
import com.example.myapplication.R;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * A simple {@link Fragment} subclass.
 */
public class NetWorkingFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.et_url)
    EditText etUrl;
    @BindView(R.id.bt_number_line)
    Button btNumberLine;
    @BindView(R.id.tv_ketQua)
    TextView tvKetQua;
    @BindView(R.id.tv_number_characters)
    TextView tvNumberCharacters;

    private static final String TAG = "NetWorkingFragment";

    public NetWorkingFragment() {
        // Required empty public constructor

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_net_working;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, getView());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        btNumberLine.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_number_line:
                getHtmlSource(etUrl.getText().toString());
                //getHtmlSource("https://www.google.com/");
                break;
        }
    }

    private void getHtmlSource(String url) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            String html = "";
            InputStream in = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder str = new StringBuilder();
            String line = null;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                str.append(line);
                count++;
            }
            in.close();
            html = str.toString();

            tvKetQua.setText("The number of lines in the page: " + count);
            tvNumberCharacters.setText("The number of characters in the page: " + html.length());
        } catch (NetworkOnMainThreadException ex) {
            tvKetQua.setText("Có lỗi " + ex);
            Log.d(TAG, "NetworkOnMainThreadException getHtmlSource: " + ex);
        } catch (Exception ex) {
            Log.d(TAG, "Exception getHtmlSource: " + ex);
        }
    }
}
