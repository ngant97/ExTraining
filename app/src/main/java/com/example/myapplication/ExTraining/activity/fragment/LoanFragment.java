package com.example.myapplication.ExTraining.activity.fragment;


import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

import com.example.myapplication.ExTraining.activity.base.BaseFragment;
import com.example.myapplication.ExTraining.db.LoanResponseJson;
import com.example.myapplication.ExTraining.http.ApiInterface;
import com.example.myapplication.ExTraining.http.core.ApiClient;
import com.example.myapplication.ExTraining.utils.Utils;
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
    @BindView(R.id.tv_ket_qua_tinh)
    TextView tvKetQuaTinh;
    @BindView(R.id.et_amount1)
    EditText etAmount1;
    @BindView(R.id.et_rate1)
    EditText etRate1;
    @BindView(R.id.et_months1)
    EditText etMonths1;
    @BindView(R.id.et_amount2)
    EditText etAmount2;
    @BindView(R.id.et_rate2)
    EditText etRate2;
    @BindView(R.id.et_months2)
    EditText etMonths2;
    @BindView(R.id.bt_load)
    Button btLoad;

    private float monthlyPayment;
    private final static String TAG = "BaseFragment";
    private float totalPayments1;
    private float totalPayments2;
    private float totalMin;
    LoanResponseJson loanResponseJson1;
    LoanResponseJson loanResponseJson2;

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
        sendLoan1FromAPI();
        sendLoan2FromAPI();

    }

    private void getLoanFromAPI() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoanResponseJson> loanCall = apiService.getAll();

        loanCall.enqueue(new Callback<LoanResponseJson>() {
            @Override
            public void onResponse(Call<LoanResponseJson> call, Response<LoanResponseJson> response) {
                loanResponseJson1 = response.body();
                //Gson gson = new Gson();
                tvMothlyPayment.setText("The monthly payment: " + loanResponseJson1.getMonthlyPayment());


            }

            @Override
            public void onFailure(Call<LoanResponseJson> call, Throwable t) {
                //Mất mạng mạng chập chờn sẽ vào hàm này
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void sendLoan1FromAPI() {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoanResponseJson> loginCall = apiService.getLoan2k1();
        loginCall.enqueue(new Callback<LoanResponseJson>() {
            @Override
            public void onResponse(Call<LoanResponseJson> call, Response<LoanResponseJson> response) {
                loanResponseJson2 = response.body();
                Gson gson = new Gson();
                totalPayments1 = loanResponseJson2.getTotalPayments();
                tvKetQuaTinh.setText("Tổng tiền thanh toán theo tình huống 1 : " + totalPayments1);
            }

            @Override
            public void onFailure(Call<LoanResponseJson> call, Throwable t) {
                //Mất mạng mạng chập chờn sẽ vào hàm này
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void sendLoan2FromAPI() {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoanResponseJson> loginCall = apiService.getLoan2k2();
        loginCall.enqueue(new Callback<LoanResponseJson>() {
            @Override
            public void onResponse(Call<LoanResponseJson> call, Response<LoanResponseJson> response) {
                LoanResponseJson loanResponseJson = response.body();
                Gson gson = new Gson();
                totalPayments2 = loanResponseJson.getTotalPayments();
                tvKetQuaTinh.setText(tvKetQuaTinh.getText()
                        + "\r\nTổng tiền thanh toán theo tình huống 2 : " + totalPayments2);
            }

            @Override
            public void onFailure(Call<LoanResponseJson> call, Throwable t) {
                //Mất mạng mạng chập chờn sẽ vào hàm này
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

}
