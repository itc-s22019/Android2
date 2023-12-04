package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api

import io.ktor.client.call.body
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api.model.NamedAPIResource
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api.model.PokemonSpecies
import java.lang.IllegalArgumentException

object PokemonGroup {
    /**
     * [id]の指定でポケモンの種族情報をとる
     */
    suspend fun getPokemonSpecies(id: Int): PokemonSpecies {
        return Client.get("/pokemon-species/$id/").body()
    }

    /**
     * [NamedAPIResource]の指定でポケモンの種族情報をとる
     */
    suspend fun getPokemonSpecies(res: NamedAPIResource): PokemonSpecies {
        if (!res.url.contains("/pokemon-species")) {
            throw IllegalArgumentException("ポケモンの種族情報用のURLではありません")
        }
        return getPokemonSpecies(res.url.split("/").last().toInt())
    }
}