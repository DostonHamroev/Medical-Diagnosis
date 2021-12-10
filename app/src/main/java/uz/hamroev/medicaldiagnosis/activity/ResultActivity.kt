package uz.hamroev.medicaldiagnosis.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.hamroev.medicaldiagnosis.cache.Cache
import uz.hamroev.medicaldiagnosis.databinding.ActivityResultBinding
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    lateinit var dateAndTime: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Cache.init(this)

       // getCurrentDateAndTime()
        checkResult()

    }

    private fun getCurrentDateAndTime() {
        dateAndTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("hh:mm:ss", Locale.getDefault())
        val date = dateFormat.format(dateAndTime)
        val time = timeFormat.format(dateAndTime)
        val vaqt = "$date - $time"
        Toast.makeText(this, "$vaqt", Toast.LENGTH_SHORT).show()

    }

    private fun checkResult() {

    }
}