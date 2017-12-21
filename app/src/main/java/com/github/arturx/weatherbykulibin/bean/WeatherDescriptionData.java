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
public class WeatherDescriptionData implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();

    public WeatherDescriptionData() {
        //empty constructor needed by jackson
    }

    @JsonProperty("description")
    private String mDescription;

    public String getDescription() {
        return mDescription;
    }

    protected WeatherDescriptionData(Parcel in) {
        mDescription = in.readString();
    }

    @JsonIgnore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDescription);
    }

    @JsonIgnore
    @Override
    public int describeContents() {
        return 0;
    }

    public static final class ClassCreator implements Creator<WeatherDescriptionData> {
        @Override
        public WeatherDescriptionData createFromParcel(Parcel in) {
            return new WeatherDescriptionData(in);
        }

        @Override
        public WeatherDescriptionData[] newArray(int size) {
            return new WeatherDescriptionData[size];
        }
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDescriptionData that = (WeatherDescriptionData) o;
        return Objects.equal(mDescription, that.mDescription);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mDescription);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mDescription", mDescription)
                .toString();
    }
}