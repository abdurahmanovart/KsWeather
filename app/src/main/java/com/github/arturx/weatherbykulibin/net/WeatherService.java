package com.github.arturx.weatherbykulibin.net;

import com.github.arturx.weatherbykulibin.bean.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by arturx on 06.12.17.
 */

public interface WeatherService {

    @GET("forecast")
    Call<BaseResponse> getWeatherData(@Query("q") String city,
                                            @Query("type") String accuracy,
                                            @Query("units")String units,
                                            @Query("appid")String apiKey);

}
