package jp.ac.std.it_college.s22019.openweatherapp.data

import jp.ac.std.it_college.s22019.openweatherapp.BuildConfig.API_KEY
import jp.ac.std.it_college.s22019.openweatherapp.api.OpenWeatherMapApiClient
import jp.ac.std.it_college.s22019.openweatherapp.model.WeatherResponse

class WeatherRepository {
    suspend fun getWeatherData(location: String): WeatherResponse {

        return OpenWeatherMapApiClient.apiService.getWeather(location, API_KEY)
    }
}