package jp.ac.std.it_college.s22019.openweatherapp.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json
import jp.ac.std.it_college.s22019.openweatherapp.BuildConfig
import kotlinx.serialization.json.Json

object Client {
    private const val KEY = BuildConfig.API_KEY
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/forecast?lang=ja&units=metric"

    private val ktor = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
        engine {
            endpoint {
                connectTimeout = 5000
                requestTimeout = 5000
                socketTimeout = 5000
            }
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
    }

    suspend fun get(q: String) =
        ktor.get { url("$BASE_URL&q=$q&appid=$KEY") }
}
