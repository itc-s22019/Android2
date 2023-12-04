package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.R
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.ui.theme.PokemonSilhouetteQuizTheme

@Composable
fun ResultScene(
    result: Int,
    modifier: Modifier = Modifier
) {
    Surface (modifier) {
        Column {
            Text(text = stringResource(id = R.string.score))
            Text(text = stringResource(id = R.string.point, result))
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun ResultScenePreview() {
    PokemonSilhouetteQuizTheme {
        ResultScene(
            result = 0,
            modifier = Modifier.fillMaxSize()
        )
    }
}