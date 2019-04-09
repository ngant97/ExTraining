package com.example.myapplication.ExTraining.activity.fragment;


import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.myapplication.ExTraining.activity.base.BaseFragment;
import com.example.myapplication.ExTraining.db.LoanResponseJson;
import com.example.myapplication.ExTraining.http.ApiInterface;
import com.example.myapplication.ExTraining.http.core.ApiClient;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoanFragment extends BaseFragment {

    @BindView(R.id.tv_monthly_payment)
    TextView tvMothlyPayment;

    private float monthlyPayment;
    private final static String TAG = "BaseFragment";


    public LoanFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_loan;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, getActivity());
    }

    @Override
    public void initData() {
        getLoanFromAPI();

    }

    private void getLoanFromAPI() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoanResponseJson> loginCall = apiService.getAll();

        loginCall.enqueue(new Callback<LoanResponseJson>() {
            @Override
            public void onResponse(Call<LoanResponseJson> call, Response<LoanResponseJson> response) {
                LoanResponseJson loanResponseJson = response.body();
                Gson gson = new Gson();
                tvMothlyPayment.setText("The monthly payment: " + loanResponseJson.getMonthlyPayment());
            }

            @Override
            public void onFailure(Call<LoanResponseJson> call, Throwable t) {
                //Mất mạng mạng chập chờn sẽ vào hàm này
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

}
