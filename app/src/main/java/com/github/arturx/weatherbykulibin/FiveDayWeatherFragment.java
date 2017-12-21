package com.github.arturx.weatherbykulibin;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.arturx.weatherbykulibin.adapter.WeatherDataAdapter;
import com.github.arturx.weatherbykulibin.bean.WeatherData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturx on 10.12.17.
 */

public class FiveDayWeatherFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<WeatherData> mWeatherData;
    private WeatherDataAdapter mAdapter;

    public static FiveDayWeatherFragment newInstance(List<WeatherData> data) {
        FiveDayWeatherFragment fragment = new FiveDayWeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(MainActivity.TAG, (ArrayList<? extends Parcelable>) data);
        fragment.setArguments(bundle);
        return fragment;
    }

    public FiveDayWeatherFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeatherData = getArguments().getParcelableArrayList(MainActivity.TAG);
        mAdapter = new WeatherDataAdapter(mWeatherData);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five_day_weather, null);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
