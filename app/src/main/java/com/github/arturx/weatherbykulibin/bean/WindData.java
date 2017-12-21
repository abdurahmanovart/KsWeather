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
public class WindData implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();

    public WindData() {
    }

    protected WindData(Parcel in) {
        mSpeed = in.readDouble();
        mDegree = in.readDouble();
    }

    @JsonProperty("speed")
    private double mSpeed;

    @JsonProperty("deg")
    private double mDegree;

    public double getSpeed() {
        return mSpeed;
    }

    public double getDegree() {
        return mDegree;
    }

    @JsonIgnore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mSpeed);
        dest.writeDouble(mDegree);
    }

    @JsonProperty
    @Override
    public int describeContents() {
        return 0;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WindData windData = (WindData) o;
        return Double.compare(windData.mSpeed, mSpeed) == 0 &&
                Double.compare(windData.mDegree, mDegree) == 0;
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mSpeed, mDegree);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mSpeed", mSpeed)
                .add("mDegree", mDegree)
                .toString();
    }

    public static final class ClassCreator implements Creator<WindData> {
        @Override
        public WindData createFromParcel(Parcel in) {
            return new WindData(in);
        }

        @Override
        public WindData[] newArray(int size) {
            return new WindData[size];
        }
    }
}
