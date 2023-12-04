package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.generation.SelectGenerationScene
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.quiz.QuizScene
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.result.ResultScene
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.title.TitleScene

object Destinations {
    const val TITLE = "title"
    const val GENERATION = "generation_select"
    const val QUIZ = "quiz/{order}"
    const val RESULT = "result"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeNavigation(
    navController: NavController = rememberNavController(),
) {
    Scaffold (
        topBar = {
            TopAppBar(title = { /*TODO*/ })
        }
    ){
        NavHost(
            navController = navController,
            startDestination = Destinations.TITLE,
            modifier = Modifier.padding(it)
        ) {
            composable(Destinations.TITLE) {
                TitleScene(
                    onTitleClick = {
                        navController.navigate(Destinations.GENERATION)
                    }
                )
            }

            composable(Destinations.GENERATION) {

                titleText = stringResource(id = R.string.please_select_generation)
                SelectGenerationScene(onGenerationSelected = { gen ->
                    quizData = generateQuizData(gen)
                    navController.navigate("quiz/0")
                })
            }

            composable(Destinations.QUIZ) {
                QuizScene(imageUrl = "", choices = listOf())
            }

            composable(Destinations.RESULT) {
                ResultScene(result = 0)
            }
        }

    }
}

fun generateQuizData(generation: Int): List<PokeQuiz>