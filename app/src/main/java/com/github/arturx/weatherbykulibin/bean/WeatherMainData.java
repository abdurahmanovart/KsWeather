package com.github.arturx.weatherbykulibin.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by arturx on 07.12.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMainData implements Parcelable{

    public static final ClassCreator CREATOR = new ClassCreator();

    public WeatherMainData() {
        //empty constructor needed by jackson
    }

    @JsonProperty("temp")
    private double mTemperature;

    @JsonProperty("humidity")
    private int mHumidity;

    protected WeatherMainData(Parcel in) {
        mTemperature = in.readDouble();
        mHumidity = in.readInt();
    }

    @JsonIgnore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mTemperature);
        dest.writeInt(mHumidity);
    }

    @JsonIgnore
    @Override
    public int describeContents() {
        return 0;
    }

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

    public static final class ClassCreator implements Creator<WeatherMainData> {
        @Override
        public WeatherMainData createFromParcel(Parcel in) {
            return new WeatherMainData(in);
        }

        @Override
        public WeatherMainData[] newArray(int size) {
            return new WeatherMainData[size];
        }
    }
}
