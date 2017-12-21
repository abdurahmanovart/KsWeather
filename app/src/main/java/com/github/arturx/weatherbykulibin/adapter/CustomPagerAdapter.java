package com.github.arturx.weatherbykulibin.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.arturx.weatherbykulibin.CurrentWeatherFragment;
import com.github.arturx.weatherbykulibin.R;
import com.github.arturx.weatherbykulibin.ThreeDayWeatherFragment;
import com.github.arturx.weatherbykulibin.TodayWeatherFragment;
import com.github.arturx.weatherbykulibin.bean.BaseResponse;
import com.github.arturx.weatherbykulibin.bean.WeatherData;

import java.util.List;

/**
 * Created by arturx on 06.12.17.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    private List<WeatherData> mWeatherDataList;
    private String mCityName;

    public CustomPagerAdapter(FragmentManager fm, BaseResponse response) {
        super(fm);
        mWeatherDataList = response.getDataList();
        mCityName = response.getCity().getCityName();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CurrentWeatherFragment.newInstance(mWeatherDataList.get(0), mCityName);
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
        switch (position){
            case 0:
                return "Текущая погода";
            case 1:
                return "Погода сегодня";
            case 2:
                return "Погода на 5 дней";
            default:
                return "Погода";
        }
    }
}
