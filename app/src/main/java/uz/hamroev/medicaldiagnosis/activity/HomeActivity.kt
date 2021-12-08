package uz.hamroev.medicaldiagnosis.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatButton
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import uz.hamroev.medicaldiagnosis.R
import uz.hamroev.medicaldiagnosis.cache.Cache
import uz.hamroev.medicaldiagnosis.databinding.ActivityHomeBinding
import uz.hamroev.medicaldiagnosis.fragment.AuthorFragment
import uz.hamroev.medicaldiagnosis.fragment.HomeFragment
import uz.hamroev.medicaldiagnosis.fragment.NatijalarFragment
import xyz.teamgravity.checkinternet.CheckInternet

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        Cache.init(this)
        drawerLayout = findViewById(R.id.drawerLayout)
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

                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    supportActionBar?.title = "Medical - Diagnostic"
                    binding.drawerLayout.closeDrawers()
                }

                R.id.nav_result -> {
                    replaceFragment(NatijalarFragment())
                    supportActionBar?.title = "Результаты"
                    binding.drawerLayout.closeDrawers()
                }

                R.id.nav_settings -> {
                    val alertDialog = AlertDialog.Builder(binding.root.context)
                    val dialog = alertDialog.create()
                    val dialogView = layoutInflater.inflate(R.layout.dialog_language, null, false)
                    dialog.setView(dialogView)
                    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    dialog.setCancelable(false)

                    val rus = dialogView.findViewById<LinearLayout>(R.id.linear_rus)
                    rus.setOnClickListener {
                        Cache.til = "ru"
                        replaceFragment(HomeFragment())
                        mediaPlayer = MediaPlayer.create(this, R.raw.rus)
                        mediaPlayer.start()
                        dialog.dismiss()
                    }

                    val uzb = dialogView.findViewById<LinearLayout>(R.id.linear_uzb)
                    uzb.setOnClickListener {
                        Cache.til = "krill"
                        mediaPlayer = MediaPlayer.create(this, R.raw.krill)
                        mediaPlayer.start()
                        replaceFragment(HomeFragment())
                        dialog.dismiss()
                    }

                    dialog.show()
                    supportActionBar?.title = "Medical - Diagnosis"
                    binding.drawerLayout.closeDrawers()


                }

                R.id.nav_share -> {
                    try {
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.setType("text/plain")
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Share Medical-Diagnosis")
                        val shareMessage: String =
                            "https://play.google.com/store/apps/details?id=" + packageName
                        intent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                        startActivity(Intent.createChooser(intent, "share by"))
                    } catch (e: Exception) {
                        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                    }

                    binding.drawerLayout.closeDrawers()
                }

                R.id.nav_rate -> {
                    try {
                        val uri: Uri = Uri.parse("market://details?id=$packageName")
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        val uri: Uri =
                            Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }

                    binding.drawerLayout.closeDrawers()
                }

                R.id.nav_opinion -> {
                    val alertDialog = AlertDialog.Builder(binding.root.context)
                    val dialog = alertDialog.create()
                    val dialogView = layoutInflater.inflate(R.layout.dialog_opinion, null, false)
                    dialog.setView(dialogView)
                    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    dialog.setCancelable(true)


                    val opinionTitleEt = dialogView.findViewById<EditText>(R.id.opinion_title_et)
                    val opinionMessageEt =
                        dialogView.findViewById<EditText>(R.id.opinion_message_et)
                    val opinionTelegram = dialogView.findViewById<ImageView>(R.id.opinion_telegram)
                    val opinionGmail = dialogView.findViewById<ImageView>(R.id.opinion_gmail)
                    val send = dialogView.findViewById<AppCompatButton>(R.id.send_btn)

                    send.setOnClickListener {
                        CheckInternet().check { connected ->
                            if (connected) {
                                try {
                                    val myGmail = "dos400dos400@gmail.com"
                                    var title = opinionTitleEt.text.toString().trim()
                                    var message = opinionMessageEt.text.toString().trim()

                                    if (title == "" || message == "") {
                                        Toast.makeText(
                                            this,
                                            "Сообщение не написано",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        val intent = Intent(Intent.ACTION_SEND)
                                        intent.setData(Uri.parse("mailto:"))
                                        intent.setType("text/plain")
                                        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("${myGmail}"))
                                        intent.putExtra(Intent.EXTRA_SUBJECT, title)
                                        intent.putExtra(Intent.EXTRA_TEXT, message)
                                        startActivity(
                                            Intent.createChooser(
                                                intent,
                                                "Choose an Email Client"
                                            )
                                        )
                                        dialog.dismiss()
                                    }
                                } catch (e: Exception) {
                                    /* if error to be , this is be | Agar error bersa shu yerga tushadi*/
                                }

                            } else {
                                dialog.dismiss()
                                val alertDialogInter = AlertDialog.Builder(binding.root.context)
                                val dialogInter = alertDialogInter.create()
                                val dialogViewInter = layoutInflater.inflate(
                                    R.layout.dialog_not_internet,
                                    null,
                                    false
                                )
                                dialogInter.setView(dialogViewInter)
                                dialogInter.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                                dialogInter.setCancelable(true)
                                dialogInter.show()
                                Handler(Looper.getMainLooper()).postDelayed({
                                    dialogInter.dismiss()
                                    dialog.show()
                                }, 3500)

                            }
                        }

                    }

                    opinionTelegram.setOnClickListener {
                        gotoUrl("http://t.me/Doston_Hamroyev")
                        dialog.dismiss()
                    }
                    opinionGmail.setOnClickListener {
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.type = "text/plain"
                        intent.putExtra(Intent.EXTRA_SUBJECT,"")
                        intent.putExtra(Intent.EXTRA_TEXT,"")
                        startActivity(intent)
                        dialog.dismiss()
                    }



                    dialog.show()
                    supportActionBar?.title = "Medical - Diagnosis"
                    binding.drawerLayout.closeDrawers()
                }

                R.id.nav_about -> {
                    replaceFragment(AuthorFragment())
                    supportActionBar?.title = "Авторы"
                    binding.drawerLayout.closeDrawers()
                }


            }

            true
        }


    }

    private fun gotoUrl(urlSocial: String) {
        val uri = Uri.parse(urlSocial)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    private fun checkLanguage() {
        when (Cache.til) {
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



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {

            return true
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment_container).navigateUp()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.linerFrag, fragment)
        fragmentTransaction.commit()
    }
}