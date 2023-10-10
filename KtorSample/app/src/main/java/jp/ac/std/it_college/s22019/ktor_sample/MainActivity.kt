package jp.ac.std.it_college.s22019.ktor_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.std.it_college.s22019.ktor_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val WEATHER_INFO_URL =
            "https://api.openweathermap.org/data/2.5/weather?lang=ja"
        private const val APP_ID = BuildConfig.APP_ID
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCityList.apply {
            adapter = CityAdapter {
                // 後でデータ取得の処理を実装したメソッドを呼び出す。
            }
            layoutManager = LinearLayoutManager(context)
        }
    }
}