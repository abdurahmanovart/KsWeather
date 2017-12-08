package com.github.arturx.weatherbykulibin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.arturx.weatherbykulibin.adapter.WeatherPagerAdapter;
import com.github.arturx.weatherbykulibin.bean.BaseResponse;
import com.github.arturx.weatherbykulibin.net.ApiClient;
import com.github.arturx.weatherbykulibin.net.WeatherService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private WeatherPagerAdapter mAdapter;
    private WeatherService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        showAlertDialog();
        initUI();
        getDataFromServer();
    }

    private void getDataFromServer() {
        mService = ApiClient.getClient().create(WeatherService.class);
        Call<BaseResponse> call = mService.getWeatherData("Moscow", "like", "metric", "da5a35e057d3d8d4df5a4b669da41d0d");
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                BaseResponse response1 = response.body();
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(getApplicationContext())
                .setView(R.layout.select_city_dialog)
                .create()
                .show();

    }

    private void initUI() {
        initToolbar();
        initTabLayout();
        initViewPager();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    private void initTabLayout() {
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(mAdapter);
    }
}
