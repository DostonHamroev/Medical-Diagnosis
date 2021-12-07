package uz.hamroev.medicaldiagnosis.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import uz.hamroev.medicaldiagnosis.R
import uz.hamroev.medicaldiagnosis.cache.Cache
import uz.hamroev.medicaldiagnosis.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        Cache.init(this)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        checkLanguage()


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Medical - Diagnostic"
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_share -> Toast.makeText(applicationContext, "Share", Toast.LENGTH_SHORT)
                    .show()
                R.id.nav_rate -> Toast.makeText(applicationContext, "Rate us", Toast.LENGTH_SHORT)
                    .show()
                R.id.nav_about -> Toast.makeText(
                    applicationContext,
                    "About App",
                    Toast.LENGTH_SHORT
                ).show()

            }

            true
        }


    }

    private fun checkLanguage() {
        when (Cache.til) {
            "uz" -> {
                loadUzData()
            }
            "krill" -> {
                loadKrillData()
            }
            "ru" -> {
                loadRuData()
            }
        }
    }

    private fun loadRuData() {

    }

    private fun loadKrillData() {

    }

    private fun loadUzData() {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {

            return true
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment_container).navigateUp()
    }
}