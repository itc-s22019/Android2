package jp.ac.std.it_college.s22019.openweatherapp2.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherSpecies(
    val cod: Int,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherApiResource>
)

@Serializable
data class WeatherApiResource(
    val main: MainResource
)

@Serializable
data class MainResource(
    val temp: Int,
    val feels_like: Int,
    val presure: Int,
    val humidity: Int,
    val list: List<Weather>
)

@Serializable
data class Weather(
    val main: String,
    val icon: Int,
    val clouds: Int,
    val list: List<Wind>
)

@Serializable
data class Wind(
    val speed: Int,
)



