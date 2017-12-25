package com.github.arturx.weatherbykulibin;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.github.arturx.weatherbykulibin.adapter.CustomPagerAdapter;
import com.github.arturx.weatherbykulibin.bean.BaseResponse;
import com.github.arturx.weatherbykulibin.net.ApiClient;
import com.github.arturx.weatherbykulibin.net.WeatherService;
import com.github.arturx.weatherbykulibin.ui.SelectCityActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_LONGITUDE = "longitude";
    public static final String EXTRA_LATITUDE = "latitude";
    public static final String EXTRA_CITY_NAME = "city_name";
    public static final String API_KEY = "da5a35e057d3d8d4df5a4b669da41d0d";
    public static final String ACCURACY = "like";
    public static final String UNITS = "metric";
    public static final String TAG = "extra_weather_data";
    public static final int RESULT_FROM_MAP = -2;

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private CustomPagerAdapter mAdapter;
    private WeatherService mService;
    private String mCityName;
    private BaseResponse mBaseResponse;

    //region activity lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCityName();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2 && resultCode == RESULT_OK) {
            String cityName = data.getExtras().getString(EXTRA_CITY_NAME);
            getDataFromServer(cityName);
        }
        if (requestCode == 2 && resultCode == RESULT_FROM_MAP) {
            getDataFromServer(data.getExtras().getDouble(EXTRA_LATITUDE), data.getExtras().getDouble(EXTRA_LONGITUDE));
        }
    }

    private void getDataFromServer(String cityName) {
        mService = ApiClient.getClient().create(WeatherService.class);
        Call<BaseResponse> call = mService.getWeatherData(cityName, ACCURACY, UNITS, API_KEY);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                if (response.body() == null) {
                    Toast.makeText(MainActivity.this, "Что-то пошло не так, попробуйте еще раз", Toast.LENGTH_LONG).show();
                    getCityName();
                } else {
                    mBaseResponse = response.body();
                    initUI();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
            }
        });

    }

    private void getDataFromServer(double latitude, double longitude) {
        mService = ApiClient.getClient().create(WeatherService.class);
        Call<BaseResponse> call = mService.getWeatherData(latitude, longitude, ACCURACY, UNITS, API_KEY);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                if (response.body() == null) {
                    Toast.makeText(MainActivity.this, "Что-то пошло не так, попробуйте еще раз", Toast.LENGTH_LONG).show();
                    getCityName();
                } else {
                    mBaseResponse = response.body();
                    initUI();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
            }
        });

    }

    //endregion

    // region private methods

    private void initUI() {
        initAdapter();
        initToolbar();
        initViewPager();
        initTabLayout();
    }

    private void initAdapter() {
        FragmentManager manager = getSupportFragmentManager();
        mAdapter = new CustomPagerAdapter(manager, mBaseResponse);
        mAdapter.notifyDataSetChanged();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
    }

    private void initTabLayout() {
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setFitsSystemWindows(true);
        mTabLayout.setupWithViewPager(mViewPager, true);
    }

    private void getCityName() {
        startActivityForResult(SelectCityActivity.createExplicitIntent(getApplicationContext()), 2);
    }

    //endregion
}

