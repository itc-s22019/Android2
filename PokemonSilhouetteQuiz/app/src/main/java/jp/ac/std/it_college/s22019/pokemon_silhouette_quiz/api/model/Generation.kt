package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Generation(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("pokemon_species") val pokemonSeries: List<NamedAPIResource>
)
