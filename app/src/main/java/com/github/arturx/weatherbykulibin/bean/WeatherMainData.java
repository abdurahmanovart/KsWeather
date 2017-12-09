package com.github.arturx.weatherbykulibin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by arturx on 07.12.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMainData {

    public WeatherMainData() {
        //empty constructor needed by jackson
    }

    @JsonProperty("temp")
    private double mTemperature;

    @JsonProperty("humidity")
    private int mHumidity;

    public double getTemperature() {
        return mTemperature;
    }

    public int getHumidity() {
        return mHumidity;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherMainData that = (WeatherMainData) o;
        return Double.compare(that.mTemperature, mTemperature) == 0 &&
                mHumidity == that.mHumidity;
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mTemperature, mHumidity);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mTemperature", mTemperature)
                .add("mHumidity", mHumidity)
                .toString();
    }
}
