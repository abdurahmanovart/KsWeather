package com.github.arturx.weatherbykulibin.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by arturx on 10.12.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();

    public City() {
        //empty constructor needed by Jackson
    }

    @JsonProperty("name")
    private String mCItyName;

    @JsonProperty("country")
    private String mCountryCode;

    protected City(Parcel in) {
        mCItyName = in.readString();
        mCountryCode = in.readString();
    }

    @JsonIgnore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCItyName);
        dest.writeString(mCountryCode);
    }

    @JsonIgnore
    @Override
    public int describeContents() {
        return 0;
    }

    public static final class ClassCreator implements Creator<City> {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    }

    ;

    public String getCityName() {
        return mCItyName;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equal(mCItyName, city.mCItyName) &&
                Objects.equal(mCountryCode, city.mCountryCode);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mCItyName, mCountryCode);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mCItyName", mCItyName)
                .add("mCountryCode", mCountryCode)
                .toString();
    }
}