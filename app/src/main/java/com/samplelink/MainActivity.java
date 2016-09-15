package com.samplelink;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.samplelink.model.EmployeeDetails;
import com.samplelink.networks.HerokuAppRestApi;
import com.samplelink.util.Constant;
import com.samplelink.util.StringConverterFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String url = "https://new-linky.herokuapp.com";
    TextView tv_id, tv_first_name, tv_last_name, tv_email, tv_mobile, tv_password, tv_created_at, tv_updated_at, tv_url;
    TextView t_id, t_first_name, t_last_name, t_email, t_mobile, t_password, t_created_at, t_updated_at, t_url;
    Button btn_herokuapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        pull Views
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_first_name = (TextView) findViewById(R.id.tv_first_name);
        tv_last_name = (TextView) findViewById(R.id.tv_last_name);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_mobile = (TextView) findViewById(R.id.tv_mobile);
        tv_password = (TextView) findViewById(R.id.tv_password);
        tv_created_at = (TextView) findViewById(R.id.tv_created_at);
        tv_updated_at = (TextView) findViewById(R.id.tv_updated_at);
        tv_url = (TextView) findViewById(R.id.tv_url);

        t_id = (TextView) findViewById(R.id.t_id);
        t_first_name = (TextView) findViewById(R.id.t_first_name);
        t_last_name = (TextView) findViewById(R.id.t_last_name);
        t_email = (TextView) findViewById(R.id.t_email);
        t_mobile = (TextView) findViewById(R.id.t_mobile);
        t_password = (TextView) findViewById(R.id.t_password);
        t_created_at = (TextView) findViewById(R.id.t_created_at);
        t_updated_at = (TextView) findViewById(R.id.t_updated_at);
        t_url = (TextView) findViewById(R.id.t_url);

        btn_herokuapp = (Button) findViewById(R.id.btn_herokuapp);
        btn_herokuapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View VisibleArray = findViewById(R.id.btn_herokuapp);
                VisibleArray.setVisibility(View.GONE);
                getData();
            }
        });
    }

    void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HerokuAppRestApi service = retrofit.create(HerokuAppRestApi.class);
        Call<List<EmployeeDetails>> call = service.readUser();
        call.enqueue(new Callback<List<EmployeeDetails>>() {

            @Override
            public void onResponse(Call<List<EmployeeDetails>> call, Response<List<EmployeeDetails>> response) {
                try {
                    List<EmployeeDetails> EmployeeData = response.body();
                    for (int i = 0; i < EmployeeData.size(); i++) {
                        if (i == 0) {
                            tv_id.setText(Constant.ID + EmployeeData.get(i).getId());
                            tv_first_name.setText(Constant.FIRST_NAME + EmployeeData.get(i).getFirst_name());
                            tv_last_name.setText(Constant.LAST_NAME + EmployeeData.get(i).getLast_name());
                            tv_email.setText(Constant.EMAIL + EmployeeData.get(i).getEmail());
                            tv_mobile.setText(Constant.MOBILE + EmployeeData.get(i).getMobile());
                            tv_password.setText(Constant.PASSWORD + EmployeeData.get(i).getPassword());
                            tv_created_at.setText(Constant.CREATED_AT + EmployeeData.get(i).getCreated_at());
                            tv_updated_at.setText(Constant.UPDATED_AT + EmployeeData.get(i).getUpdated_at());
                            tv_url.setText(Constant.URL + EmployeeData.get(i).getUrl());
                        } else if (i == 1) {
                            t_id.setText(Constant.ID + EmployeeData.get(i).getId());
                            t_first_name.setText(Constant.FIRST_NAME + EmployeeData.get(i).getFirst_name());
                            t_last_name.setText(Constant.LAST_NAME + EmployeeData.get(i).getLast_name());
                            t_email.setText(Constant.EMAIL + EmployeeData.get(i).getEmail());
                            t_mobile.setText(Constant.MOBILE + EmployeeData.get(i).getMobile());
                            t_password.setText(Constant.PASSWORD + EmployeeData.get(i).getPassword());
                            t_created_at.setText(Constant.CREATED_AT + EmployeeData.get(i).getCreated_at());
                            t_updated_at.setText(Constant.UPDATED_AT + EmployeeData.get(i).getUpdated_at());
                            t_url.setText(Constant.URL + EmployeeData.get(i).getUrl());
                        }
                    }
                } catch (Exception e) {
                    Log.d(TAG, "onResponse: " + Constant.ERROR);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeDetails>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }
}

