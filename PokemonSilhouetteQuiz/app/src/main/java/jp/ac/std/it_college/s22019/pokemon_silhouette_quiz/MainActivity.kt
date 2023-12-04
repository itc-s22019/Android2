package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.api.PokemonGroup
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.database.PokeRoomDatabase
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.database.entity.Poke
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.ui.theme.PokemonSilhouetteQuizTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Composable 内で使えるコルーチンスコープ
            val scope = rememberCoroutineScope()
            // 現在の処理を実施している Context を取得
            val context = LocalContext.current

            //テストのダミーデータ登録
            scope.launch {
//                testDataInitializeDatabase(context)
                val generation = GamesGroup.getGeneration(9)
                val pamo = PokemonGroup.getPokemonSpecies(generation.pokemonSpecies[0])
                Log.d("PokeAPI", PokemonGroup.getPokemon(pamo.varieties[0].pokemon).toString())

            }
            PokemonSilhouetteQuizTheme {
                PokeNavigation()
            }
        }
    }
}

private suspend fun testDataInitializeDatabase(context: Context) {
    withContext(Dispatchers.IO) {
        val dao = PokeRoomDatabase.getDatabase(context).pokeDao()
        // もし既にダミーデータが入っていれば何もしないで終了する
        if (dao.findByGeneration(9).isNotEmpty()) return@withContext

        // 以下はダミーデータの登録
        dao.insertAll(
            listOf(
                Poke(
                    906,
                    9,
                    "ニャオハ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/906.png"
                ),
                Poke(
                    909,
                    9,
                    "ホゲータ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/909.png"
                ),
                Poke(
                    912,
                    9,
                    "クワッス",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/912.png"
                ),
                Poke(
                    915,
                    9,
                    "グルトン",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/915.png"
                ),
                Poke(
                    921,
                    9,
                    "パモ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/921.png"
                ),
                Poke(
                    924,
                    9,
                    "ワッカネズミ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/924.png"
                ),
                Poke(
                    926,
                    9,
                    "パピモッチ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/926.png"
                ),
                Poke(
                    928,
                    9,
                    "ミニーブ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/928.png"
                ),
                Poke(
                    931,
                    9,
                    "イキリンコ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/931.png"
                ),
                Poke(
                    932,
                    9,
                    "コジオ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/932.png"
                ),
                Poke(
                    935,
                    9,
                    "カルボウ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/935.png"
                )
            )
        )
    }
}