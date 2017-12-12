package com.github.arturx.weatherbykulibin.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by arturx on 07.12.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Parcelable{

    public static final ClassCreator CREATOR = new ClassCreator();

    public BaseResponse() {
    }

    @JsonProperty("cod")
    private int mCode;

    @JsonProperty("cnt")
    private int resultCount;

    @JsonProperty("list")
    private List<WeatherData> mDataList;

    @JsonProperty("city")
    private City mCity;

    protected BaseResponse(Parcel in) {
        mCode = in.readInt();
        resultCount = in.readInt();
        mDataList = in.createTypedArrayList(WeatherData.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCode);
        dest.writeInt(resultCount);
        dest.writeTypedList(mDataList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final class ClassCreator implements Creator<BaseResponse>{
        @Override
        public BaseResponse createFromParcel(Parcel in) {
            return new BaseResponse(in);
        }

        @Override
        public BaseResponse[] newArray(int size) {
            return new BaseResponse[size];
        }
    };

    public int getResultCount() {
        return resultCount;
    }

    public List<WeatherData> getDataList() {
        return mDataList;
    }

    public int getCode() {
        return mCode;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponse that = (BaseResponse) o;
        return mCode == that.mCode &&
                resultCount == that.resultCount &&
                Objects.equal(mDataList, that.mDataList) &&
                Objects.equal(mCity, that.mCity);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mCode, resultCount, mDataList, mCity);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mCode", mCode)
                .add("resultCount", resultCount)
                .add("mDataList", mDataList)
                .add("mCity", mCity)
                .toString();
    }
}
