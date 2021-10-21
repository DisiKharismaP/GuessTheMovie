package disiiy.khaper.guessthemovie

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.*
import androidx.navigation.ui.R

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(disiiy.khaper.guessthemovie.R.layout.activity_main)

        drawerLayout=findViewById(disiiy.khaper.guessthemovie.R.id.drawer_layout)
        val navController = this.findNavController(disiiy.khaper.guessthemovie.R.id.nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(disiiy.khaper.guessthemovie.R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}