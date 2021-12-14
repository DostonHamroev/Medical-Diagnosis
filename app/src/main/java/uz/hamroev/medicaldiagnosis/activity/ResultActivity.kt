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
    var a1 = Cache.a1
    var a2 = Cache.a2

    var b1 = Cache.b1
    var b2 = Cache.b2
    var b3 = Cache.b3

    var c1 = Cache.c1
    var c2 = Cache.c2

    var d1 = Cache.d1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Cache.init(this)

        //getCurrentDateAndTime()
        checkLanguage()
        //   Toast.makeText(this, "\nA1=$a1\nA2=$a2\nB1=$b1\nB2=$b2\nB3=$b3\nC1=$c1\nC2=$c2\nD1=$d1", Toast.LENGTH_LONG).show()
        findVariant()
        Toast.makeText(this, "${Cache.variant}", Toast.LENGTH_SHORT).show()


    }

    private fun findVariant() {

        if (a1 == 0) {
            Cache.variant = "1"
        }

        /* 2-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2 == 0 && b3 == 0 && c1 == 0 && c2 == 0 && d1 == -1) {
            Cache.variant = "2"
        }

        /* 3-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2 == 0 && b3!! >= 3 && c1 == 0 && c2 == 0 && d1 == -1) {
            Cache.variant = "3"
        }

        /* 4-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3!! >= 3 && c1 == 0 && c2 == 0 && d1 == -1) {
            Cache.variant = "4"
        }

        /* 5-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3==0 && c1 == 0 && c2 == 0 && d1 == -1) {
            Cache.variant = "5"
        }

        /* 6-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3!! >=3 && c1!! >=3 && c2!! >=2 && d1 == -1) {
            Cache.variant = "6"
        }

        /* 7-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3!! ==0 && c1!! >=3 && c2!! >=2 && d1 == -1) {
            Cache.variant = "7"
        }

        /* 8-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3!! >=3 && c1!! >=3 && c2!! >=2 && d1!! > -1) {
            Cache.variant = "8"
        }

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
        when (Cache.variant) {
            "1" -> {
                loadKRILLVariant1()
            }
            "2" -> {
                loadKRILLVariant2()
            }
            "3" -> {
                loadKRILLVariant3()
            }
            "4" -> {
                loadKRILLVariant4()
            }
            "5" -> {
                loadKRILLVariant5()
            }
            "6" -> {
                loadKRILLVariant6()
            }
            "7" -> {
                loadKRILLVariant7()
            }
            "8" -> {
                loadKRILLVariant8()
            }
        }
    }

    private fun loadRuData() {
        when (Cache.variant) {
            "1" -> {
                loadRUVariant1()
            }
            "2" -> {
                loadRUVariant2()
            }
            "3" -> {
                loadRUVariant3()
            }
            "4" -> {
                loadRUVariant4()
            }
            "5" -> {
                loadRUVariant5()
            }
            "6" -> {
                loadRUVariant6()
            }
            "7" -> {
                loadRUVariant7()
            }
            "8" -> {
                loadRUVariant8()
            }
        }
    }



    /* variants for language RUSSIAN */

    private fun loadRUVariant1() {
        binding.diagnosVariant.text = "1 - Вариант akaxon"
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

    private fun loadRUVariant2() {}

    private fun loadRUVariant3() {}

    private fun loadRUVariant4() {}

    private fun loadRUVariant5() {}

    private fun loadRUVariant6() {}

    private fun loadRUVariant7() {}

    private fun loadRUVariant8() {}

    /* variants for language KRILL*/

    private fun loadKRILLVariant1() {}

    private fun loadKRILLVariant2() {}

    private fun loadKRILLVariant3() {}

    private fun loadKRILLVariant4() {}

    private fun loadKRILLVariant5() {}

    private fun loadKRILLVariant6() {}

    private fun loadKRILLVariant7() {}

    private fun loadKRILLVariant8() {}

}