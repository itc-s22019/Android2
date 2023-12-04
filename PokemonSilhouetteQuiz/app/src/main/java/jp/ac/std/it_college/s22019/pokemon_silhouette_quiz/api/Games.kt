package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api

import io.ktor.client.call.body
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api.model.Generation

object Games {
    /**
     * 世代情報を取る
     */
    suspend fun getGeneration(gen: Int): Generation {
        return Client.get("/generation/$gen/").body()
    }
}