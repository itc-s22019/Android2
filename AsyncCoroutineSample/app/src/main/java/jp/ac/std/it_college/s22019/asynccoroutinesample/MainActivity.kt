package jp.ac.std.it_college.s22019.asynccoroutinesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.std.it_college.s22019.asynccoroutinesample.databinding.ActivityMainBinding
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.SocketTimeoutException

class MainActivity : AppCompatActivity() {
    companion object {
        private const val DEBUG_TAG = "AsyncSample"
        private const val WEATHER_INFO_URL = "https://api.openweathermap.org/data/2.5/weather?lang=ja"
        private const val APP_ID = BuildConfig.APP_ID
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.rvCityList.apply {
            adapter = CityAdapter {
                receiveWeatherInfo(it.q)
            }
            layoutManager = LinearLayoutManager(context)
        }
    }

    @UiThread
    private fun receiveWeatherInfo(q: String) {
        lifecycleScope.launch {
            val url = "$WEATHER_INFO_URL&q=$q&appid=$APP_ID"
            val result = weatherInfoBackgroundRunner(url)
            showWeatherInfo(result)
        }
    }

    @WorkerThread
    private fun weatherInfoBackgroundRunner(urlString: String): String {
        val url = (urlString)
        val con = url.openConnection() as HttpURLConnection
        con.apply {
            connectTimeout = 1000
            readTimeout = 1000
            requestMethod = "GET"
        }
        try {
            con.connect()
            val result = con.inputStream.reader().readText()
            con.disconnect()
            result
        } catch (ex: SocketTimeoutException) {
            Log.w("DEBUG_TAG", "通信タイムアウト", ex)
            ""
        }
    }
    @UiThread
    private fun showWeatherInfo(result: String) {
        val root = JSONObject(result)
        val cityName = root.getString("name")
        val coord = root.getJSONObject("coord")
        val latitude = coord.getDouble("lat")
        val longitude = coord.getDouble("lon")
        val weatherArray = root.getJSONArray("weather")
        val current = weatherArray.getJSONObject(0)
        val weather = current.getString("description")
        // 以下、表示処理
        binding.tvWeatherTelop.text = "{CityName}の天気"
        binding.tvWeatherDesc.text = "現在は{weather}です。緯度は{latitude}度で経度は{logitude}度です。"

    }
}