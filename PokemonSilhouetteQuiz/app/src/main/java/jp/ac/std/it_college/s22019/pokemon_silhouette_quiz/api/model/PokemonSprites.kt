package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSprites(
    @SerialName("front_default") val frontDefault: String,
    val other: PokemonSpritesOther
)

@Serializable
data class PokemonSpritesOther(
    @SerialName("official-artwork") val officialArtwork: SpriteResource,
)

@Serializable
data class SpriteResource(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
)
