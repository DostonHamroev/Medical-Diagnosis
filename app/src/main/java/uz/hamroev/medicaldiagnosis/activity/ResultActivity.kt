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

        //getCurrentDateAndTime()
        checkLanguage()


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

    private fun checkLanguage() {
        when (Cache.til) {
            "ru" -> {
                loadRuData()
            }
            "krill" -> {
                loadKrillData()
            }
        }
    }

    private fun loadKrillData() {
        binding.diagnosVariant.text = "2 - Вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = "XCH I ФК I"
        binding.diagnos2Tv.text = "Далее при этом"
        binding.diagnosTitleUpTable.text =
            "В1 (3 и БОЛЕЕ  пунктов)  +С0 (С1 и/или С2 менее 2х пунктов)  + Д1\n" +
                    "На экран выходит следующее "
        binding.diagnosResultTable1.text = "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\n" +
                "НИЗКИЙ РИСК ССО\n" +
                "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        binding.diagnosResultTable2.text = "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\n" +
                "НИЗКИЙ РИСК ССО\n" +
                "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        binding.diagnosResultTable3.text = "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\n" +
                "НИЗКИЙ РИСК ССО\n" +
                "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"

    }

    private fun loadRuData() {
        binding.diagnosVariant.text = "2 - Вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = "XCH I ФК I"
        binding.diagnos2Tv.text = "Далее при этом"
        binding.diagnosTitleUpTable.text =
            "В1 (3 и БОЛЕЕ  пунктов)  +С0 (С1 и/или С2 менее 2х пунктов)  + Д1\n" +
                    "На экран выходит следующее "
        binding.diagnosResultTable1.text = "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\n" +
                "НИЗКИЙ РИСК ССО\n" +
                "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        binding.diagnosResultTable2.text = "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\n" +
                "НИЗКИЙ РИСК ССО\n" +
                "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        binding.diagnosResultTable3.text = "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\n" +
                "НИЗКИЙ РИСК ССО\n" +
                "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"

    }
}