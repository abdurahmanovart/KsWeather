package com.github.arturx.weatherbykulibin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.arturx.weatherbykulibin.R;
import com.github.arturx.weatherbykulibin.bean.WeatherData;
import com.github.arturx.weatherbykulibin.utils.Utils;

import java.util.List;

/**
 * Created by arturx on 22.12.17.
 */

public class WeatherDataAdapter extends RecyclerView.Adapter<WeatherDataViewHolder> {

    private List<WeatherData> mWeatherDataList;

    public WeatherDataAdapter(List<WeatherData> weatherDataList) {
        mWeatherDataList = weatherDataList;
    }

    @Override
    public WeatherDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_data_item, parent, false);
        return new WeatherDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherDataViewHolder holder, int position) {
        holder.mWeatherTypeImageView.setImageResource(Utils.getWeatherImageId(mWeatherDataList.get(position).getDescriptionData().get(0).getDescription()));
        holder.mWeatherDataTextView.setText(getWeatherDataText(mWeatherDataList.get(position)));
        holder.mDateTimeTextView.setText(mWeatherDataList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mWeatherDataList.size();
    }

    private String getWeatherDataText(WeatherData weatherData) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(weatherData.getMainWeatherData().getTemperature());
        stringBuilder.append("C   ");
        stringBuilder.append(weatherData.getWindData().getSpeed());
        stringBuilder.append(" м/с");
        stringBuilder.append("    ");
        stringBuilder.append(weatherData.getMainWeatherData().getHumidity());
        stringBuilder.append(" %");
        return stringBuilder.toString();
    }
}
