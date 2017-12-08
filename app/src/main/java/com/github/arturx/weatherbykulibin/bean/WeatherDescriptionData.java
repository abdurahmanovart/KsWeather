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
public class WeatherDescriptionData {

    public WeatherDescriptionData() {
        //empty constructor needed by jackson
    }

    @JsonProperty("description")
    private String mDescription;

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
