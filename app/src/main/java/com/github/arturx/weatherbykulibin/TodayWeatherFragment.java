package com.github.arturx.weatherbykulibin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.arturx.weatherbykulibin.bean.WeatherData;

import java.util.List;

/**
 * Created by arturx on 10.12.17.
 */

public class TodayWeatherFragment extends Fragment {

    private List<WeatherData> mWeatherData;

    public static TodayWeatherFragment newInstance(List<WeatherData> data){
        TodayWeatherFragment fragment = new TodayWeatherFragment();
        return fragment;
    }

    public TodayWeatherFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_weather,null);
        return view;
    }
}
