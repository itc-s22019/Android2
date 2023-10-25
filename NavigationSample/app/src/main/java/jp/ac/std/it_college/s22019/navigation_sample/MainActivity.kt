package jp.ac.std.it_college.s22019.navigation_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.std.it_college.s22019.navigation_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}