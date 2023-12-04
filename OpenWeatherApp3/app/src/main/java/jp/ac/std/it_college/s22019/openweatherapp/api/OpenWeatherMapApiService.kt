package jp.ac.std.it_college.s22019.openweatherapp.api

import jp.ac.std.it_college.s22019.openweatherapp.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") location: String,
        @Query("appid") apiKey: String
    ): WeatherResponse
}