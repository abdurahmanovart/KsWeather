package com.github.arturx.weatherbykulibin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.arturx.weatherbykulibin.R;

/**
 * Created by arturx on 21.12.17.
 */

public class WeatherDataViewHolder extends RecyclerView.ViewHolder {

    public ImageView mWeatherTypeImageView;
    public TextView mDateTimeTextView;
    public TextView mWeatherDataTextView;


    public WeatherDataViewHolder(View itemView) {
        super(itemView);
        mWeatherTypeImageView = itemView.findViewById(R.id.weather_type_image_view);
        mDateTimeTextView = itemView.findViewById(R.id.date_time_text_view);
        mWeatherDataTextView = itemView.findViewById(R.id.weather_data_text_view);
    }


}
