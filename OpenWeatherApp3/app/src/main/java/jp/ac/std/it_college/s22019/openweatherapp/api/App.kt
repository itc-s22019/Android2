package jp.ac.std.it_college.s22019.openweatherapp.api

import io.ktor.client.call.body
import jp.ac.std.it_college.s22019.openweatherapp.model.WeatherResponse

object App {
    public suspend fun getWeather(q: String): WeatherResponse {
        return Client.get(q).body()
    }
}