package com.github.arturx.weatherbykulibin.utils;

import com.github.arturx.weatherbykulibin.R;

/**
 * Created by arturx on 13.12.17.
 */

public class Utils {

    private Utils(){
        throw new IllegalStateException();
    }

    public static int getWeatherImageId(String description) {
        description = description.toLowerCase();
        if (description.contains("rain"))
            return R.drawable.icon_rainy_weather;
        else if (description.contains("thunder") || description.contains("storm"))
            return R.drawable.icon_thunder_weather;
        else if (description.contains("clear"))
            return R.drawable.icon_clear_day;
        else if (description.contains("cloud"))
            return R.drawable.icon_cloudy;
        else if (description.contains("wind"))
            return R.drawable.icon_windy_weather;
        else if (description.contains("snow"))
            return R.drawable.icon_snow_weather;
        return R.drawable.icon_mostly_cloudy;
    }

    public static int convertPressure(double hPa){
        return (int) (hPa*0.750062);
    }
}