package uz.hamroev.medicaldiagnosis

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import uz.hamroev.medicaldiagnosis.activity.HomeActivity
import uz.hamroev.medicaldiagnosis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        startAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 3650)
    }


    private fun startAnimation() {
        binding.lottieIntro.setAnimation("heartbeatline.json")
        binding.typeWriter.setCharacterDeley(60)
        binding.typeWriter.animateText("Medical \nDiagnosis")
        val animIntroVersion = AnimationUtils.loadAnimation(this, R.anim.anim_intro_version)
        val animIntroTeamName = AnimationUtils.loadAnimation(this, R.anim.anim_intro_team_name)
        binding.versionTV.startAnimation(animIntroVersion)
        binding.teamNameTV.startAnimation(animIntroTeamName)
    }
}