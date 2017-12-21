package com.github.arturx.weatherbykulibin;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.arturx.weatherbykulibin.bean.WeatherData;
import com.github.arturx.weatherbykulibin.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturx on 10.12.17.
 */

public class TodayWeatherFragment extends Fragment {

    private List<WeatherData> mWeatherData;
    private TextView mCurrentDataTextView;
    private TextView m3hDataTextView;
    private TextView m6hDataTextView;
    private ImageView mTodayWeatherImageView;
    private ImageView m3htWeatherImageView;
    private ImageView m6hWeatherImageView;

    public static final String EXTRA_WEATHER_DATA = "weather_data";

    public static TodayWeatherFragment newInstance(List<WeatherData> data) {
        TodayWeatherFragment fragment = new TodayWeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(EXTRA_WEATHER_DATA, (ArrayList<? extends Parcelable>) data);
        fragment.setArguments(bundle);
        return fragment;
    }

    public TodayWeatherFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeatherData = getArguments().getParcelableArrayList(EXTRA_WEATHER_DATA);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_weather, null);
        initViews(view);
        setValuesToViews();
        return view;
    }

    private void initViews(View view) {
        mCurrentDataTextView = view.findViewById(R.id.next_3h_text_view);
        m3hDataTextView = view.findViewById(R.id.next6h_weather_text_view);
        m6hDataTextView = view.findViewById(R.id.next9h_weather_text_view);
        mTodayWeatherImageView = view.findViewById(R.id.next_3h_image_view);
        m3htWeatherImageView = view.findViewById(R.id.next6h_weather_image_view);
        m6hWeatherImageView = view.findViewById(R.id.next9h_weather_image_view);
    }

    private void setValuesToViews() {
        mCurrentDataTextView.setText(getWeatherTextData(mWeatherData.get(1)));
        m3hDataTextView.setText(getWeatherTextData(mWeatherData.get(2)));
        m6hDataTextView.setText(getWeatherTextData(mWeatherData.get(3)));
        mTodayWeatherImageView.setImageResource(Utils.getWeatherImageId(mWeatherData.get(0).getDescriptionData().get(0).getDescription()));
        m3htWeatherImageView.setImageResource(Utils.getWeatherImageId(mWeatherData.get(1).getDescriptionData().get(0).getDescription()));
        m6hWeatherImageView.setImageResource(Utils.getWeatherImageId(mWeatherData.get(2).getDescriptionData().get(0).getDescription()));
    }

    private String getWeatherTextData(WeatherData weatherData) {
        StringBuilder sb = new StringBuilder();
        sb.append(weatherData.getMainWeatherDataData().getTemperature());
        sb.append("С    ");
        sb.append(weatherData.getWindData().getSpeed());
        sb.append(" м/с    ");
        sb.append(weatherData.getMainWeatherDataData().getHumidity());
        sb.append("%");
        return sb.toString();
    }
}