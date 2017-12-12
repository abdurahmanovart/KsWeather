package com.github.arturx.weatherbykulibin.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.arturx.weatherbykulibin.CurrentWeatherFragment;
import com.github.arturx.weatherbykulibin.ThreeDayWeatherFragment;
import com.github.arturx.weatherbykulibin.TodayWeatherFragment;
import com.github.arturx.weatherbykulibin.bean.WeatherData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturx on 06.12.17.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    private List<WeatherData> mWeatherDataList;

    public void setWeatherDataList(List<WeatherData> weatherDataList) {
        mWeatherDataList = weatherDataList;
    }

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return CurrentWeatherFragment.newInstance(mWeatherDataList.get(0));
                case 1:
                    return TodayWeatherFragment.newInstance(mWeatherDataList);
                case 2:
                    return ThreeDayWeatherFragment.newInstance(mWeatherDataList);
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return String.valueOf(mWeatherDataList.get(position).getWindData().getSpeed());
    }
}
