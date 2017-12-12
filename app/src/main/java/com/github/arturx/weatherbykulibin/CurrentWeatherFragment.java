package com.github.arturx.weatherbykulibin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.arturx.weatherbykulibin.bean.WeatherData;

/**
 * Created by arturx on 06.12.17.
 */

public class CurrentWeatherFragment extends Fragment {

    private ImageView mWeatherImage;
    private TextView mTemperatureTextView;
    private TextView mWindTextView;
    private TextView mHumidityTextView;
    private WeatherData mWeatherData;

    public static CurrentWeatherFragment newInstance(WeatherData data) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        Bundle args = new Bundle();
        args.putParcelable(MainActivity.TAG,data);
        fragment.setArguments(args);
        return fragment;
    }

    public CurrentWeatherFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeatherData = getArguments().getParcelable(MainActivity.TAG);
        System.out.println(mWeatherData.getMainWeatherDataData().getTemperature());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, null);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        mWeatherImage.setImageResource(R.drawable.icon_rainy_weather);
        mTemperatureTextView.setText(String.format("%sC", String.valueOf(mWeatherData.getMainWeatherDataData().getTemperature())));
        mWindTextView.setText(String.format("%sм/с", String.valueOf(mWeatherData.getWindData().getSpeed())));
        mHumidityTextView.setText(String.valueOf(mWeatherData.getMainWeatherDataData().getHumidity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initUI(View view) {
        mWeatherImage = view.findViewById(R.id.current_weather_image_view);
        mTemperatureTextView = view.findViewById(R.id.temperature_text_view);
        mWindTextView = view.findViewById(R.id.wind_text_view);
        mHumidityTextView = view.findViewById(R.id.humidity_text_view);
    }
}