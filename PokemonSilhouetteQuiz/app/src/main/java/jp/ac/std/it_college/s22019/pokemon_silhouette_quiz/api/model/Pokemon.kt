package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val sprites: PokemonSprites
)
