package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.title

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.R
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.ui.theme.PokemonSilhouetteQuizTheme

@Composable
fun TitleScene(modifier: Modifier = Modifier) {
    Surface (modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(vertical = 24.dp)

            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun TitleScenePreview() {
    PokemonSilhouetteQuizTheme {
        TitleScene(Modifier.fillMaxSize())
    }
}