package jp.ac.std.it_college.s22019.navigation_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import jp.ac.std.it_college.s22019.navigation_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar を ActionBarとして使用
        setSupportActionBar(binding.toolbar)

        // Navigation 関連のコンポーネント取得
        val navHost = binding.fragmentContainerView.getFragment<NavHostFragment>()
        val navController = navHost.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        // ToolbarとNavigation連携
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return binding.fragmentContainerView.findNavController().navigateUp(appBarConfiguration)
    }
}