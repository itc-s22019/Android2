package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Client {
    /** ベースURL */
    private const val BASE_URL = "https://pokeapi.co/api/v2/"
    /** Ktor Client */
    private val ktor = HttpClient(CIO) {
        engine {
            endpoint {

            }
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
    }

    suspend fun get(endpoint: String) =
        ktor.get { url( "$BASE_URL$endpoint")}
}