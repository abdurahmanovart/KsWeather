package com.github.arturx.weatherbykulibin.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.arturx.weatherbykulibin.TodayWeatherFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturx on 06.12.17.
 */

public class WeatherPagerAdapter extends FragmentStatePagerAdapter {

    private List<TodayWeatherFragment> mList;

    public WeatherPagerAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mList.isEmpty() ? null : mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).getTitle();
    }
}
