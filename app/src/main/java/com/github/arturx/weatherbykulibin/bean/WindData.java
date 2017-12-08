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
class WindData {

    @JsonProperty("speed")
    private double mSpeed;

    @JsonProperty("deg")
    private double mDegree;

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
}
