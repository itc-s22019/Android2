package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.model

data class PokeQuiz(
    val imageUrl: String,
    val choices: List<String>,
    val correct: String
)