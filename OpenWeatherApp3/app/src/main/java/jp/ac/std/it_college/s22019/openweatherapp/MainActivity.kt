package jp.ac.std.it_college.s22019.openweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.std.it_college.s22019.openweatherapp.api.App
import jp.ac.std.it_college.s22019.openweatherapp.ui.theme.OpenWeatherAppTheme
import kotlinx.coroutines.launch

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    var result by remember { mutableStateOf("") }
    var temp by remember { mutableStateOf("") }
    var feels_like by remember { mutableStateOf("") }
    var grnd_level by remember { mutableStateOf("") }
    var humidity by remember { mutableStateOf("") }
    var weather by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            scope.launch {
                cityList.forEach { cityName ->
                    result = App.getWeather(cityName).city.name
                    temp = App.getWeather(cityName).forecast[0].main.temp.toString()
                    feels_like = App.getWeather(cityName).forecast[0].main.feels_like.toString()
                    grnd_level = App.getWeather(cityName).forecast[0].main.grnd_level.toString()
                    humidity = App.getWeather(cityName).forecast[0].main.humidity.toString()
                    weather = App.getWeather(cityName).forecast[0].weather[0].main
                    date = App.getWeather(cityName).forecast[0].dt_txt
                }
            }
        }
        ) {
            Text(text = "weather")

        }
        Column {

            Text(text = "都道府県:$result")
            Text(text = "温度:$temp")
            Text(text = "体感温度:$feels_like")
            Text(text = "気圧:$grnd_level")
            Text(text = "湿度:$humidity")
            Text(text = "天気:$weather")
            Text(text = "日付:$date")
        }
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenWeatherAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OpenWeatherAppTheme {
        Greeting("Weather")
    }
}


var cityList = listOf(
    "福岡県",
    "佐賀県",
    "長崎県",
    "熊本県",
    "大分県",
    "宮崎県",
    "鹿児島県",
    "沖縄県",
//    "北海道(札幌)",
//    "青森",
//    "岩手(盛岡)",
//    "宮城(仙台)",
//    "秋田",
//    "山形",
//    "福島",
//    "茨城(水戸)",
//    "栃木(宇都宮)",
//    "群馬(前橋)",
//    "埼玉(さいたま)",
//    "千葉",
//    "東京",
//    "神奈川(横浜)",
//    "新潟",
//    "富山",
//    "石川(金沢)",
//    "福井",
//    "山梨(甲府)",
//    "長野",
//    "岐阜",
//    "静岡",
//    "愛知(名古屋)",
//    "三重(津)",
//    "滋賀(大津)",
//    "京都",
//    "大阪",
//    "兵庫",
//    "奈良",
//    "和歌山",
//    "鳥取",
//    "島根(松江)",
//    "岡山",
//    "広島",
//    "山口",
//    "徳島",
//    "香川(高松)",
//    "愛媛(松山)",
//    "高知",
//    "福岡",
//    "佐賀",
//    "長崎",
//    "熊本",
//    "大分",
//    "宮崎",
//    "鹿児島",
//    "沖縄(那覇)",
    )