package com.github.arturx.weatherbykulibin.bean;

import android.icu.util.Calendar;
import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Date;
import java.util.List;

/**
 * Created by arturx on 07.12.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();

    public WeatherData() {
    }

    @JsonProperty("main")
    private WeatherMainData mMainWeatherDataData;

    @JsonProperty("weather")
    private List<WeatherDescriptionData> mDescriptionData;

    @JsonProperty("wind")
    private WindData mWindData;

    @JsonProperty("dt_txt")
    private String mDate;


    private static final class ClassCreator implements Creator<WeatherData> {
        @Override
        public WeatherData createFromParcel(Parcel in) {
            return new WeatherData(in);
        }

        @Override
        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    }

    protected WeatherData(Parcel in) {
        mMainWeatherDataData = in.readParcelable(WeatherMainData.class.getClassLoader());
        mDescriptionData = in.createTypedArrayList(WeatherDescriptionData.CREATOR);
        mWindData = in.readParcelable(WindData.class.getClassLoader());
        mDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mMainWeatherDataData, flags);
        dest.writeTypedList(mDescriptionData);
        dest.writeParcelable(mWindData, flags);
        dest.writeString(mDate);
    }


    @JsonIgnore
    @Override
    public int describeContents() {
        return 0;
    }


    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Objects.equal(mMainWeatherDataData, that.mMainWeatherDataData) &&
                Objects.equal(mDescriptionData, that.mDescriptionData) &&
                Objects.equal(mWindData, that.mWindData) &&
                Objects.equal(mDate, that.mDate);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mMainWeatherDataData, mDescriptionData, mWindData, mDate);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mMainWeatherDataData", mMainWeatherDataData)
                .add("mDescriptionData", mDescriptionData)
                .add("mWindData", mWindData)
                .add("mDate", mDate)
                .toString();
    }

    public String getDate() {
        return mDate;
    }

    public WeatherMainData getMainWeatherData() {
        return mMainWeatherDataData;
    }

    public List<WeatherDescriptionData> getDescriptionData() {
        return mDescriptionData;
    }


    public WindData getWindData() {
        return mWindData;
    }
}