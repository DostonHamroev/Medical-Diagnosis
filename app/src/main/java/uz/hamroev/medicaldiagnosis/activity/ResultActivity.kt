package uz.hamroev.medicaldiagnosis.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import uz.hamroev.medicaldiagnosis.cache.Cache
import uz.hamroev.medicaldiagnosis.databinding.ActivityResultBinding
import uz.hamroev.medicaldiagnosis.room.database.ResultDatabase
import uz.hamroev.medicaldiagnosis.room.entity.ResultEntity
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    lateinit var resultDatabase: ResultDatabase
    lateinit var binding: ActivityResultBinding
    lateinit var dateAndTime: Date
    private val TAG = "TTTT"

    var a1 = Cache.a1
    var a2 = Cache.a2

    var b1 = Cache.b1
    var b2 = Cache.b2
    var b3 = Cache.b3

    var c1 = Cache.c1
    var c2 = Cache.c2

    var d1 = Cache.d1

    var diagnosMessageRu1 = ""
    var diagnosMessageRu2 = ""
    var diagnosMessageRu3 = ""
    var diagnosMessageRu4 = ""
    var diagnosMessageRu5 = ""
    var diagnosMessageRu6 = ""
    var diagnosMessageRu7 = ""
    var diagnosMessageRu8 = ""

    var diagnosMessageKrill1 = ""
    var diagnosMessageKrill2 = ""
    var diagnosMessageKrill3 = ""
    var diagnosMessageKrill4 = ""
    var diagnosMessageKrill5 = ""
    var diagnosMessageKrill6 = ""
    var diagnosMessageKrill7 = ""
    var diagnosMessageKrill8 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Cache.init(this)
        resultDatabase = ResultDatabase.getInstance(this)

        findVariant()
        checkLanguage()
        //   Toast.makeText(this, "\nA1=$a1\nA2=$a2\nB1=$b1\nB2=$b2\nB3=$b3\nC1=$c1\nC2=$c2\nD1=$d1", Toast.LENGTH_LONG).show()

        Log.d(TAG, "onCreate: \nA1=$a1\nA2=$a2\nB1=$b1\nB2=$b2\nB3=$b3\nC1=$c1\nC2=$c2\nD1=$d1")

    }

    private fun findVariant() {

        // Toast.makeText(this, "Result oyna: ${Cache.sumAnol}", Toast.LENGTH_SHORT).show()

        /* 1 - Variant */
        if (a1 == 0) {
            Cache.variant = "1"
        }

        /* 2-variant */
        if (
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && d1!! == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && (b2!! < 2 || b3!! < 3) && (c1!! < 2 || c2!! < 2) && d1!! == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && (c1!! < 2 || c2!! < 2) && d1!! == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && (b2!! < 2 || b3!! < 3) && d1!! == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && d1!! == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && (b1!! < 3 || b3!! < 3) && (c1!! < 2 || c2!! < 2) && d1!! == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && (c1!! < 2 || c2!! < 2) && d1!! == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && (b1!! < 3 || b3!! < 3) && d1!! == 0)
        ) {
            Cache.variant = "2"
        }


        /* 3-variant */
        if (
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && d1 == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && d1 == 0 && (b1!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && d1 == 0 && (b1!! < 3) && (c1!! < 2 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && d1 == 0 && (c1!! < 2 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && d1 == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && d1 == 0 && (b2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && d1 == 0 && (b2!! < 2) && (c1!! < 2 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && d1 == 0 && (c1!! < 2 || c2!! < 2))

        ) {
            Cache.variant = "3"
        }

        /* 4-variant */
        if (
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && d1 == 0) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && d1 == 0 && (c1!! < 2 || c2!! < 2))
        ) {
            Cache.variant = "4"
        }

        /* 5-variant */
        if (
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && d1 == 0 || (b2!! < 2 || b3!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && c1!! >= 3 && d1 == 0 || (b1!! < 3 || b3!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && d1 == 0 || (b1!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && c1!! >= 3 && d1 == 0 || (b2!! < 2 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && d1 == 0 || (c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 0 || (b2!! < 2 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && c1!! >= 3 && c2!! >= 2 && d1 == 0 || (b1!! < 3 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 0 || (b1!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 0 || (b2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && c1!! >= 3 && c2!! >= 2 && d1 == 0 || (b3!! < 3))
        ) {
            Cache.variant = "5"
        }


        /* 6-variant */
        if (
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && d1 == 1 || (b2!! < 2 || b3!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && c1!! >= 3 && d1 == 1 || (b1!! < 3 || b3!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && d1 == 1 || (b1!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && c1!! >= 3 && d1 == 1 || (b2!! < 2 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && d1 == 1 || (c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 1 || (b2!! < 2 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && c1!! >= 3 && c2!! >= 2 && d1 == 1 || (b1!! < 3 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 1 || (b1!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 1 || (b2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && c1!! >= 3 && c2!! >= 2 && d1 == 1 || (b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 0)
        ) {
            Cache.variant = "6"
        }


        /* 7-variant */
        if (
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && d1 == 1 || (b2!! < 2 || b3!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && c1!! >= 3 && d1 == 1 || (b1!! < 3 || b3!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && d1 == 1 || (b1!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && c1!! >= 3 && d1 == 1 || (b2!! < 2 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && d1 == 1 || (c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 1 || (b2!! < 2 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && d1 == 1 || (c1!! >= 3 || b2!! < 2 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && d1 == 1 || (c1!! >= 3 || b1!! < 3 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && d1 == 1 || (c1!! >= 3 || b1!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && d1 == 1 || (c1!! >= 3 || b2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && c1!! >= 3 && c2!! >= 2 && d1 == 1 || (b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && d1 == 1 || (c1!! >= 3 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && d1 == 2 || (b2!! < 2 || b3!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && c1!! >= 3 && d1 == 2 || (b1!! < 3 || b3!! < 3 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && d1 == 2 || (b1!! < 3 || c2!! < 2)) ||
            //pastdagi qatorda TZ 34 bet 57 var da berilishicha d1 deb berilgan adashilgan bo'lishi mjumkin d3 bo'lishi kerak manimcha
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && c1!! >= 3 && d1 == 0 || (b2!! < 2 || c2!! < 2)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && c1!! >= 3 && d1 == 2 || (b2!! < 2 || c2!! < 2)) ||
            // bu yerda ham shunaqa holat TZ 35 bet 62 variant d1 bo'lgani uchun d1=0 qildim !
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 0 || (b2!! < 2 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 2 || (b2!! < 2 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && c1!! >= 3 && c2!! >= 2 && d1 == 2 || (b1!! < 3 || b3!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 2 || (b1!! < 3)) ||
            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 2 || (b2!! < 2))
        ) {
            Cache.variant = "7"
        }

        /* 8-variant */
//        if (
//            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 1) ||
//            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && d1 == 2 || (c2!! < 2)) ||
//            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && c1!! >= 3 && c2!! >= 2 && d1 == 2 || (b3!! < 3)) ||
//            ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 2)
//        ) {
//            Cache.variant = "8"
//        }

        if ((a1!! > 0 || a2!! >= 0) && b1!! >= 3 && b2!! >= 2) {
            if (
                (b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 1) ||
                (b3!! >= 3 && c1!! >= 3 && d1 == 2 || (c2!! < 2)) ||
                (c1!! >= 3 && c2!! >= 2 && d1 == 2 || (b3!! < 3)) ||
                (b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == 2)
            ){
                Cache.variant = "8"
            }
        }


    }

    private fun getCurrentDateAndTime(): String {
        dateAndTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val date = dateFormat.format(dateAndTime)
        val time = timeFormat.format(dateAndTime)
        val vaqt: String = "$date - $time"
        //Toast.makeText(this, "$vaqt", Toast.LENGTH_SHORT).show()
        return vaqt

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
        binding.resultTv.text = "Tashxis"
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

        binding.resultTv.text = "Результат"
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

        binding.diagnosVariant.text = "1-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = "нет ХСН "
        binding.card1.visibility = View.GONE
        binding.card2.visibility = View.GONE
        binding.card3.visibility = View.GONE

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "1-вариант"
        result.diagnos = "нет ХСН"
        result.diagnos1 = ""
        result.diagnos2 = ""
        result.diagnos3 = ""
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant2() {

        // Toast.makeText(binding.root.context, "$a1", Toast.LENGTH_SHORT).show()
        //  Toast.makeText(binding.root.context, "$a2", Toast.LENGTH_SHORT).show()

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageRu2 = "ХСН I ФК I"
            binding.diagnosResult.text = diagnosMessageRu2
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageRu2 = "ХСН I ФК II"
            binding.diagnosResult.text = diagnosMessageRu2
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageRu2 = "ХСН I ФК III"
            binding.diagnosResult.text = diagnosMessageRu2
        } else if (a1!! > 9) {
            diagnosMessageRu2 = "ХСН I ФК IV"
            binding.diagnosResult.text = diagnosMessageRu2
        }

        if (a2!! == 0) {
            diagnosMessageRu2 = "ХСН I ФК I"
            binding.diagnosResult.text = diagnosMessageRu2
        } else if (a2!! == 1) {
            diagnosMessageRu2 = "ХСН I ФК II"
            binding.diagnosResult.text = diagnosMessageRu2
        } else if (a2!! == 2) {
            diagnosMessageRu2 = "ХСН I ФК III"
            binding.diagnosResult.text = diagnosMessageRu2
        } else if (a2!! == 3) {
            diagnosMessageRu2 = "ХСН I ФК IV"
            binding.diagnosResult.text = diagnosMessageRu2
        }



        binding.diagnosVariant.text = "2-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResultTable1.text = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n"
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\n" + "НИЗКИЙ РИСК ССО\n" + "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"


        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "2-вариант"
        result.diagnos = diagnosMessageRu2
        result.diagnos1 = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n"
        result.diagnos2 =
            "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\\n\" + \"НИЗКИЙ РИСК ССО\\n\" + \"ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)


    }

    private fun loadRUVariant3() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageRu3 = "ХСН IIА ФК I"
            binding.diagnosResult.text = diagnosMessageRu3
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageRu3 = "ХСН IIА ФК II"
            binding.diagnosResult.text = diagnosMessageRu3
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageRu3 = "ХСН IIА ФК III"
            binding.diagnosResult.text = diagnosMessageRu3
        } else if (a1!! > 9) {
            diagnosMessageRu3 = "ХСН IIА ФК IV"
            binding.diagnosResult.text = diagnosMessageRu3
        }

        if (a2!! == 0) {
            diagnosMessageRu3 = "ХСН IIА ФК I"
            binding.diagnosResult.text = diagnosMessageRu3
        } else if (a2!! == 1) {
            diagnosMessageRu3 = "ХСН IIА ФК II"
            binding.diagnosResult.text = diagnosMessageRu3
        } else if (a2!! == 2) {
            diagnosMessageRu3 = "ХСН IIА ФК III"
            binding.diagnosResult.text = diagnosMessageRu3
        } else if (a2!! == 3) {
            diagnosMessageRu3 = "ХСН IIА ФК IV"
            binding.diagnosResult.text = diagnosMessageRu3
        }

        binding.diagnosVariant.text = "3-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResultTable1.text = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n"
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "БЛАГОПРИЯТНЫЙ,\n" + "Умеренный  РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "3-вариант"
        result.diagnos = diagnosMessageRu3
        result.diagnos1 = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n"
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"БЛАГОПРИЯТНЫЙ,\\n\" + \"Умеренный  РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant4() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageRu4 = "ХСН IIБ ФК I"
            binding.diagnosResult.text = diagnosMessageRu4
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageRu4 = "ХСН IIБ ФК II"
            binding.diagnosResult.text = diagnosMessageRu4
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageRu4 = "ХСН IIБ ФК III"
            binding.diagnosResult.text = diagnosMessageRu4
        } else if (a1!! > 9) {
            diagnosMessageRu4 = "ХСН IIБ ФК IV"
            binding.diagnosResult.text = diagnosMessageRu4
        }

        if (a2!! == 0) {
            diagnosMessageRu4 = "ХСН IIБ ФК I"
            binding.diagnosResult.text = diagnosMessageRu4
        } else if (a2!! == 1) {
            diagnosMessageRu4 = "ХСН IIБ ФК II"
            binding.diagnosResult.text = diagnosMessageRu4
        } else if (a2!! == 2) {
            diagnosMessageRu4 = "ХСН IIБ ФК III"
            binding.diagnosResult.text = diagnosMessageRu4
        } else if (a2!! == 3) {
            diagnosMessageRu4 = "ХСН IIБ ФК IV"
            binding.diagnosResult.text = diagnosMessageRu4
        }

        binding.diagnosVariant.text = "4-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResultTable1.text = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n"
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "+ короткие курсы диуретиков\n" + "Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "4-вариант"
        result.diagnos = diagnosMessageRu4
        result.diagnos1 = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n"
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"+ короткие курсы диуретиков\\n\" + \"Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant5() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageRu5 = "ХСН IIБ ФК I"
            binding.diagnosResult.text = diagnosMessageRu5
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageRu5 = "ХСН IIБ ФК II"
            binding.diagnosResult.text = diagnosMessageRu5
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageRu5 = "ХСН IIБ ФК III"
            binding.diagnosResult.text = diagnosMessageRu5
        } else if (a1!! > 9) {
            diagnosMessageRu5 = "ХСН IIБ ФК IV"
            binding.diagnosResult.text = diagnosMessageRu5
        }

        if (a2!! == 0) {
            diagnosMessageRu5 = "ХСН IIБ ФК I"
            binding.diagnosResult.text = diagnosMessageRu5
        } else if (a2!! == 1) {
            diagnosMessageRu5 = "ХСН IIБ ФК II"
            binding.diagnosResult.text = diagnosMessageRu5
        } else if (a2!! == 2) {
            diagnosMessageRu5 = "ХСН IIБ ФК III"
            binding.diagnosResult.text = diagnosMessageRu5
        } else if (a2!! == 3) {
            diagnosMessageRu5 = "ХСН IIБ ФК IV"
            binding.diagnosResult.text = diagnosMessageRu5
        }

        binding.diagnosVariant.text = "5-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResultTable1.text =
            "необходимо КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n" + "Консультация нефролога\n" + ""
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "(исключить заболевания почек не связанных с ХСН)\n" + "Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "5-вариант"
        result.diagnos = diagnosMessageRu5
        result.diagnos1 =
            "необходимо КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n\" + \"Консультация нефролога\n"
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"(исключить заболевания почек не связанных с ХСН)\\n\" + \"Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant6() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageRu6 = "ХСН III ФК I"
            binding.diagnosResult.text = diagnosMessageRu6
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageRu6 = "ХСН III ФК II"
            binding.diagnosResult.text = diagnosMessageRu6
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageRu6 = "ХСН III ФК III"
            binding.diagnosResult.text = diagnosMessageRu6
        } else if (a1!! > 9) {
            diagnosMessageRu6 = "ХСН III ФК IV"
            binding.diagnosResult.text = diagnosMessageRu6
        }

        if (a2!! == 0) {
            diagnosMessageRu6 = "ХСН III ФК I"
            binding.diagnosResult.text = diagnosMessageRu6
        } else if (a2!! == 1) {
            diagnosMessageRu6 = "ХСН III ФК II"
            binding.diagnosResult.text = diagnosMessageRu6
        } else if (a2!! == 2) {
            diagnosMessageRu6 = "ХСН III ФК III"
            binding.diagnosResult.text = diagnosMessageRu6
        } else if (a2!! == 3) {
            diagnosMessageRu6 = "ХСН III ФК IV"
            binding.diagnosResult.text = diagnosMessageRu6
        }

        binding.diagnosVariant.text = "6-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResultTable1.text =
            "1. КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n" + "2. КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "\n" + ""
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "(исключить заболевания почек не связанных с ХСН)\n" + "Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "6-вариант"
        result.diagnos = diagnosMessageRu6
        result.diagnos1 =
            "1. КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n\" + \"2. КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"\\n\""
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"(исключить заболевания почек не связанных с ХСН)\\n\" + \"Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant7() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageRu7 = "ХСН IIБ ФК I"
            binding.diagnosResult.text = diagnosMessageRu7
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageRu7 = "ХСН IIБ ФК II"
            binding.diagnosResult.text = diagnosMessageRu7
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageRu7 = "ХСН IIБ ФК III"
            binding.diagnosResult.text = diagnosMessageRu7
        } else if (a1!! > 9) {
            diagnosMessageRu7 = "ХСН IIБ ФК IV"
            binding.diagnosResult.text = diagnosMessageRu7
        }

        if (a2!! == 0) {
            diagnosMessageRu7 = "ХСН IIБ ФК I"
            binding.diagnosResult.text = diagnosMessageRu7
        } else if (a2!! == 1) {
            diagnosMessageRu7 = "ХСН IIБ ФК II"
            binding.diagnosResult.text = diagnosMessageRu7
        } else if (a2!! == 2) {
            diagnosMessageRu7 = "ХСН IIБ ФК III"
            binding.diagnosResult.text = diagnosMessageRu7
        } else if (a2!! == 3) {
            diagnosMessageRu7 = "ХСН IIБ ФК IV"
            binding.diagnosResult.text = diagnosMessageRu7
        }

        binding.diagnosVariant.text = "7-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResultTable1.text =
            "необходимо КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n" + "Консультация нефролога\n" + ""
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "(исключить заболевания почек не связанных с ХСН)\n" + " РЕШИТЬ ВОПРОС О ГЕМОДИАЛИЗЕ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "7-вариант"
        result.diagnos = diagnosMessageRu7
        result.diagnos1 =
            "необходимо КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n\" + \"Консультация нефролога\\n\" "
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"(исключить заболевания почек не связанных с ХСН)\\n\" + \" РЕШИТЬ ВОПРОС О ГЕМОДИАЛИЗЕ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant8() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageRu8 = "ХСН III ФК I"
            binding.diagnosResult.text = diagnosMessageRu8
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageRu8 = "ХСН III ФК II"
            binding.diagnosResult.text = diagnosMessageRu8
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageRu8 = "ХСН III ФК III"
            binding.diagnosResult.text = diagnosMessageRu8
        } else if (a1!! > 9) {
            diagnosMessageRu8 = "ХСН III ФК IV"
            binding.diagnosResult.text = diagnosMessageRu8
        }

        if (a2!! == 0) {
            diagnosMessageRu8 = "ХСН III ФК I"
            binding.diagnosResult.text = diagnosMessageRu8
        } else if (a2!! == 1) {
            diagnosMessageRu8 = "ХСН III ФК II"
            binding.diagnosResult.text = diagnosMessageRu8
        } else if (a2!! == 2) {
            diagnosMessageRu8 = "ХСН III ФК III"
            binding.diagnosResult.text = diagnosMessageRu8
        } else if (a2!! == 3) {
            diagnosMessageRu8 = "ХСН III ФК IV"
            binding.diagnosResult.text = diagnosMessageRu8
        }

        binding.diagnosVariant.text = "8-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResultTable1.text =
            "1. КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n" + "2. КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + ""
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "(исключить заболевания почек не связанных с ХСН)\n" + "РЕШИТЬ ВОПРОС О ГЕМОДИАЛИЗЕ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "8-вариант"
        result.diagnos = diagnosMessageRu8
        result.diagnos1 =
            "1. КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n\" + \"2. КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\""
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"(исключить заболевания почек не связанных с ХСН)\\n\" + \"РЕШИТЬ ВОПРОС О ГЕМОДИАЛИЗЕ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }


    /* variants for language KRILL*/

    private fun loadKRILLVariant1() {
        binding.diagnosVariant.text = "1-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = "Surunkali Yurak Yetishmovchiligi Aniqlanmadi"
        binding.card1.visibility = View.GONE
        binding.card2.visibility = View.GONE
        binding.card3.visibility = View.GONE

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "1-Variant"
        result.diagnos = "Surunkali Yurak Yetishmovchiligi Aniqlanmadi"
        result.diagnos1 = ""
        result.diagnos2 = ""
        result.diagnos3 = ""
        resultDatabase.resultDao().addResult(result)


    }

    private fun loadKRILLVariant2() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageKrill2 = "SYUE I FS I"
            binding.diagnosResult.text = diagnosMessageKrill2
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageKrill2 = "SYUE I FS II"
            binding.diagnosResult.text = diagnosMessageKrill2
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageKrill2 = "SYUE I FS III"
            binding.diagnosResult.text = diagnosMessageKrill2
        } else if (a1!! > 9) {
            diagnosMessageKrill2 = "SYUE I FS IV"
            binding.diagnosResult.text = diagnosMessageKrill2
        }

        if (a2!! == 0) {
            diagnosMessageKrill2 = "SYUE I FS I"
            binding.diagnosResult.text = diagnosMessageKrill2
        } else if (a2!! == 1) {
            diagnosMessageKrill2 = "SYUE I FS II"
            binding.diagnosResult.text = diagnosMessageKrill2
        } else if (a2!! == 2) {
            diagnosMessageKrill2 = "SYUE I FS III"
            binding.diagnosResult.text = diagnosMessageKrill2
        } else if (a2!! == 3) {
            diagnosMessageKrill2 = "SYUE I FS IV"
            binding.diagnosResult.text = diagnosMessageKrill2
        }

        binding.diagnosVariant.text = "2-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResultTable1.text = "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG"
        binding.diagnosResultTable2.text =
            "Ijobiy prognoz\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish xavfi past darajada\n" + "SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish"
        binding.diagnosResultTable3.text =
            "    • Ichilayotgan suyuqlik nazorati\n" + "    • •\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "    • •\tdiurez nazorati. \n" + "    • •\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "2-Variant"
        result.diagnos = diagnosMessageKrill2
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG"
        result.diagnos2 = ""
        "Ijobiy prognoz\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish xavfi past darajada\\n\" + \"SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish"
        result.diagnos3 =
            "• Ichilayotgan suyuqlik nazorati\\n\" + \"    • •\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"    • •\\tdiurez nazorati. \\n\" + \"    • •\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant3() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageKrill3 = "SYUE IIА FS I"
            binding.diagnosResult.text = diagnosMessageKrill3
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageKrill3 = "SYUE IIА FS II"
            binding.diagnosResult.text = diagnosMessageKrill3
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageKrill3 = "SYUE IIА FS III"
            binding.diagnosResult.text = diagnosMessageKrill3
        } else if (a1!! > 9) {
            diagnosMessageKrill3 = "SYUE IIА FS IV"
            binding.diagnosResult.text = diagnosMessageKrill3
        }

        if (a2!! == 0) {
            diagnosMessageKrill3 = "SYUE IIА FS I"
            binding.diagnosResult.text = diagnosMessageKrill3
        } else if (a2!! == 1) {
            diagnosMessageKrill3 = "SYUE IIА FS II"
            binding.diagnosResult.text = diagnosMessageKrill3
        } else if (a2!! == 2) {
            diagnosMessageKrill3 = "SYUE IIА FS III"
            binding.diagnosResult.text = diagnosMessageKrill3
        } else if (a2!! == 3) {
            diagnosMessageKrill3 = "SYUE IIА FS IV"
            binding.diagnosResult.text = diagnosMessageKrill3
        }

        binding.diagnosVariant.text = "3-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResultTable1.text = "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n"
        binding.diagnosResultTable2.text =
            "Ijobiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi o‘rta darajada\n" + "KARDIOLOG KO‘RIGI\n" + "SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish\n"
        binding.diagnosResultTable3.text =
            "• Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "3-Variant"
        result.diagnos = diagnosMessageKrill3
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n"
        result.diagnos2 =
            "Ijobiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi o‘rta darajada\\n\" + \"KARDIOLOG KO‘RIGI\\n\" + \"SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish\\n"
        result.diagnos3 =
            "• Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant4() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageKrill4 = "SYUE IIБ FS I"
            binding.diagnosResult.text = diagnosMessageKrill4
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageKrill4 = "SYUE IIБ FS II"
            binding.diagnosResult.text = diagnosMessageKrill4
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageKrill4 = "SYUE IIБ FS III"
            binding.diagnosResult.text = diagnosMessageKrill4
        } else if (a1!! > 9) {
            diagnosMessageKrill4 = "SYUE IIБ FS IV"
            binding.diagnosResult.text = diagnosMessageKrill4
        }

        if (a2!! == 0) {
            diagnosMessageKrill4 = "SYUE IIБ FS I"
            binding.diagnosResult.text = diagnosMessageKrill4
        } else if (a2!! == 1) {
            diagnosMessageKrill4 = "SYUE IIБ FS II"
            binding.diagnosResult.text = diagnosMessageKrill4
        } else if (a2!! == 2) {
            diagnosMessageKrill4 = "SYUE IIБ FS III"
            binding.diagnosResult.text = diagnosMessageKrill4
        } else if (a2!! == 3) {
            diagnosMessageKrill4 = "SYUE IIБ FS IV"
            binding.diagnosResult.text = diagnosMessageKrill4
        }

        binding.diagnosVariant.text = "4-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResultTable1.text = "  KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n"
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori\n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        binding.diagnosResultTable3.text =
            "    • Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "4-Variant"
        result.diagnos = diagnosMessageKrill4
        result.diagnos1 = "  KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n"
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori\\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        result.diagnos3 =
            "    • Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant5() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageKrill5 = "SYUE IIБ FS I"
            binding.diagnosResult.text = diagnosMessageKrill5
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageKrill5 = "SYUE IIБ FS II"
            binding.diagnosResult.text = diagnosMessageKrill5
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageKrill5 = "SYUE IIБ FS III"
            binding.diagnosResult.text = diagnosMessageKrill5
        } else if (a1!! > 9) {
            diagnosMessageKrill5 = "SYUE IIБ FS IV"
            binding.diagnosResult.text = diagnosMessageKrill5
        }

        if (a2!! == 0) {
            diagnosMessageKrill5 = "SYUE IIБ FS I"
            binding.diagnosResult.text = diagnosMessageKrill5
        } else if (a2!! == 1) {
            diagnosMessageKrill5 = "SYUE IIБ FS II"
            binding.diagnosResult.text = diagnosMessageKrill5
        } else if (a2!! == 2) {
            diagnosMessageKrill5 = "SYUE IIБ FS III"
            binding.diagnosResult.text = diagnosMessageKrill5
        } else if (a2!! == 3) {
            diagnosMessageKrill5 = "SYUE IIБ FS IV"
            binding.diagnosResult.text = diagnosMessageKrill5
        }

        binding.diagnosVariant.text = "5-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResultTable1.text =
            "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n" + "NEFROLOG KO‘RIGI\n" + ""
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori\n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "NEFROLOGNING KONSULTASIYaSI\n" + "(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        binding.diagnosResultTable3.text =
            "    • Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "5-Variant"
        result.diagnos = diagnosMessageKrill5
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n\" + \"NEFROLOG KO‘RIGI\\n\""
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori\\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"NEFROLOGNING KONSULTASIYaSI\\n\" + \"(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        result.diagnos3 =
            "    • Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant6() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageKrill6 = "SYUE III FS I"
            binding.diagnosResult.text = diagnosMessageKrill6
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageKrill6 = "SYUE III FS II"
            binding.diagnosResult.text = diagnosMessageKrill6
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageKrill6 = "SYUE III FS III"
            binding.diagnosResult.text = diagnosMessageKrill6
        } else if (a1!! > 9) {
            diagnosMessageKrill6 = "SYUE III FS IV"
            binding.diagnosResult.text = diagnosMessageKrill6
        }

        if (a2!! == 0) {
            diagnosMessageKrill6 = "SYUE III FS I"
            binding.diagnosResult.text = diagnosMessageKrill6
        } else if (a2!! == 1) {
            diagnosMessageKrill6 = "SYUE III FS II"
            binding.diagnosResult.text = diagnosMessageKrill6
        } else if (a2!! == 2) {
            diagnosMessageKrill6 = "SYUE III FS III"
            binding.diagnosResult.text = diagnosMessageKrill6
        } else if (a2!! == 3) {
            diagnosMessageKrill6 = "SYUE III FS IV"
            binding.diagnosResult.text = diagnosMessageKrill6
        }

        binding.diagnosVariant.text = "6-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResultTable1.text =
            "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n" + "NEFROLOG KO‘RIGI\n" + ""
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada\n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "NEFROLOGNING KONSULTASIYaSI\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        binding.diagnosResultTable3.text =
            "Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "6-Variant"
        result.diagnos = diagnosMessageKrill6
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n\" + \"NEFROLOG KO‘RIGI\\n\""
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada\\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"NEFROLOGNING KONSULTASIYaSI\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        result.diagnos3 =
            "Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant7() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageKrill7 = "SYUE IIБ FS I"
            binding.diagnosResult.text = diagnosMessageKrill7
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageKrill7 = "SYUE IIБ FS II"
            binding.diagnosResult.text = diagnosMessageKrill7
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageKrill7 = "SYUE IIБ FS III"
            binding.diagnosResult.text = diagnosMessageKrill7
        } else if (a1!! > 9) {
            diagnosMessageKrill7 = "SYUE IIБ FS IV"
            binding.diagnosResult.text = diagnosMessageKrill7
        }

        if (a2!! == 0) {
            diagnosMessageKrill7 = "SYUE IIБ FS I"
            binding.diagnosResult.text = diagnosMessageKrill7
        } else if (a2!! == 1) {
            diagnosMessageKrill7 = "SYUE IIБ FS II"
            binding.diagnosResult.text = diagnosMessageKrill7
        } else if (a2!! == 2) {
            diagnosMessageKrill7 = "SYUE IIБ FS III"
            binding.diagnosResult.text = diagnosMessageKrill7
        } else if (a2!! == 3) {
            diagnosMessageKrill7 = "SYUE IIБ FS IV"
            binding.diagnosResult.text = diagnosMessageKrill7
        }

        binding.diagnosVariant.text = "7-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResultTable1.text =
            "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n" + "NEFROLOG KO‘RIGI"
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada \n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "NEFROLOGNING KONSULTASIYaSI\n" + "(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash\n" + "GEMODIALIZ MASALASINI HAL QILISh"
        binding.diagnosResultTable3.text =
            "Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "7-Variant"
        result.diagnos = diagnosMessageKrill7
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n\" + \"NEFROLOG KO‘RIGI"
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada \\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"NEFROLOGNING KONSULTASIYaSI\\n\" + \"(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash\\n\" + \"GEMODIALIZ MASALASINI HAL QILISh"
        result.diagnos3 =
            "Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant8() {

        if (a1!! >= 1 && a1!! <= 3) {
            diagnosMessageKrill8 = "SYUE III FS I"
            binding.diagnosResult.text = diagnosMessageKrill8
        } else if (a1!! >= 4 && a1!! <= 6) {
            diagnosMessageKrill8 = "SYUE III FS II"
            binding.diagnosResult.text = diagnosMessageKrill8
        } else if (a1!! >= 7 && a1!! <= 9) {
            diagnosMessageKrill8 = "SYUE III FS III"
            binding.diagnosResult.text = diagnosMessageKrill8
        } else if (a1!! > 9) {
            diagnosMessageKrill8 = "SYUE III FS IV"
            binding.diagnosResult.text = diagnosMessageKrill8
        }

        if (a2!! == 0) {
            diagnosMessageKrill8 = "SYUE III FS I"
            binding.diagnosResult.text = diagnosMessageKrill8
        } else if (a2!! == 1) {
            diagnosMessageKrill8 = "SYUE III FS II"
            binding.diagnosResult.text = diagnosMessageKrill8
        } else if (a2!! == 2) {
            diagnosMessageKrill8 = "SYUE III FS III"
            binding.diagnosResult.text = diagnosMessageKrill8
        } else if (a2!! == 3) {
            diagnosMessageKrill8 = "SYUE III FS IV"
            binding.diagnosResult.text = diagnosMessageKrill8
        }

        binding.diagnosVariant.text = "8-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResultTable1.text =
            "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n" + "NEFROLOG KO‘RIGI"
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada\n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "NEFROLOGNING KONSULTASIYaSI\n" + "(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash\n" + "GEMODIALIZ MASALASINI HAL QILISh"
        binding.diagnosResultTable3.text =
            "Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.fio = Cache.fio
        result.variant = "8-Variant"
        result.diagnos = diagnosMessageKrill8
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n\" + \"NEFROLOG KO‘RIGI"
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada\\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"NEFROLOGNING KONSULTASIYaSI\\n\" + \"(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash\\n\" + \"GEMODIALIZ MASALASINI HAL QILISh"
        result.diagnos3 =
            "Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }


}