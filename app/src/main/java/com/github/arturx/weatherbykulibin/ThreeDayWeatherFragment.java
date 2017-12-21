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

public class ThreeDayWeatherFragment extends Fragment {

    public static ThreeDayWeatherFragment newInstance(List<WeatherData> data) {
        ThreeDayWeatherFragment fragment = new ThreeDayWeatherFragment();
        return fragment;
    }

    public ThreeDayWeatherFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three_day_weather, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
