package com.github.arturx.weatherbykulibin.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by arturx on 07.12.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    public BaseResponse() {
    }

    @JsonProperty("cnt")
    private int resultCount;

    @JsonProperty("list")
    private List<WeatherData> mDataList;


}
