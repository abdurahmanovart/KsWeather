package com.github.arturx.weatherbykulibin;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.arturx.weatherbykulibin.adapter.CustomPagerAdapter;
import com.github.arturx.weatherbykulibin.bean.BaseResponse;
import com.github.arturx.weatherbykulibin.net.ApiClient;
import com.github.arturx.weatherbykulibin.net.WeatherService;
import com.github.arturx.weatherbykulibin.ui.SelectCityActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_CITY_NAME = "city_name";
    public static final String API_KEY = "da5a35e057d3d8d4df5a4b669da41d0d";
    public static final String ACCURACY = "like";
    public static final String UNITS = "metric";

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private CustomPagerAdapter mAdapter;
    private WeatherService mService;
    private String mCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCityName();
        initUI();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2 && resultCode == RESULT_OK) {
            mCityName = data.getExtras().getString(EXTRA_CITY_NAME);
            getDataFromServer();

        }
    }

    private void getDataFromServer() {
        mService = ApiClient.getClient().create(WeatherService.class);
        Call<BaseResponse> call = mService.getWeatherData(mCityName, ACCURACY, UNITS, API_KEY);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                try {
                    System.out.println(response.body().getDataList().get(0).getMainWeatherDataData().getTemperature());
                } catch (Exception e) {
                    getCityName();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }

    //region private methods

    private void initUI() {
        initToolbar();
        initTabLayout();
        initViewPager();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initTabLayout() {
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(mAdapter);
    }

    private void getCityName() {
        startActivityForResult(SelectCityActivity.createExplicitIntent(getApplicationContext()), 2);
    }

    //endregion
}

