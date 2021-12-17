package uz.hamroev.medicaldiagnosis.activity

import android.os.Bundle
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

    var a1 = Cache.a1
    var a2 = Cache.a2

    var b1 = Cache.b1
    var b2 = Cache.b2
    var b3 = Cache.b3

    var c1 = Cache.c1
    var c2 = Cache.c2

    var d1 = Cache.d1

    var diagnosMessage = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Cache.init(this)
        resultDatabase = ResultDatabase.getInstance(this)

        findVariant()
        checkLanguage()
        //   Toast.makeText(this, "\nA1=$a1\nA2=$a2\nB1=$b1\nB2=$b2\nB3=$b3\nC1=$c1\nC2=$c2\nD1=$d1", Toast.LENGTH_LONG).show()
        //Toast.makeText(this, "${Cache.variant}", Toast.LENGTH_SHORT).show()


    }

    private fun findVariant() {

        if (a1 == 0) {
            Cache.variant = "1"
        }

        /* 2-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2 == 0 && b3 == 0 && c1 == 0 && c2 == 0 && d1 == -1) {
            Cache.variant = "2"
        }
        /* 2-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2 == 0 && b3 == 0 && c1!! < 3 && c2!! < 2 && d1 == -1) {
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
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3 == 0 && c1 == 0 && c2 == 0 && d1 == -1) {
            Cache.variant = "5"
        }

        /* 6-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1 == -1) {
            Cache.variant = "6"
        }

        /* 7-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3!! == 0 && c1!! >= 3 && c2!! >= 2 && d1 == -1) {
            Cache.variant = "7"
        }

        /* 8-variant */
        if (b1!! >= 3 && (a1!! > 0 || a2!! != 0) && b2!! >= 2 && b3!! >= 3 && c1!! >= 3 && c2!! >= 2 && d1!! > -1) {
            Cache.variant = "8"
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


        binding.diagnosVariant.text = "1 вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = "нет ХСН "
        binding.card1.visibility = View.GONE
        binding.card2.visibility = View.GONE
        binding.card3.visibility = View.GONE
    }

    private fun loadRUVariant2() {

        // Toast.makeText(binding.root.context, "$a1", Toast.LENGTH_SHORT).show()
        //  Toast.makeText(binding.root.context, "$a2", Toast.LENGTH_SHORT).show()

        if (a1!! >= 1 || a1!! <= 3) {
            diagnosMessage = "XCH I FK I"
            binding.diagnosResult.text = diagnosMessage
        } else if (a1!! >= 4 || a1!! <= 6) {
            diagnosMessage = "XCH I FK II"
            binding.diagnosResult.text = diagnosMessage
        } else if (a1!! >= 7 || a1!! <= 9) {
            diagnosMessage = "XCH I FK III"
            binding.diagnosResult.text = diagnosMessage
        } else if (a1!! > 9) {
            diagnosMessage = "XCH I FK IV"
            binding.diagnosResult.text = diagnosMessage
        }

        if (a2!! == 0) {
            diagnosMessage = "XCH I FK I"
            binding.diagnosResult.text = diagnosMessage
        } else if (a2!! == 1) {
            diagnosMessage = "XCH I FK II"
            binding.diagnosResult.text = diagnosMessage
        } else if (a2!! == 2) {
            diagnosMessage = "XCH I FK III"
            binding.diagnosResult.text = diagnosMessage
        } else if (a2!! == 3) {
            diagnosMessage = "XCH I FK IV"
            binding.diagnosResult.text = diagnosMessage
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
        result.variant = "2-вариант"
        result.diagnos = diagnosMessage
        result.diagnos1 = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n"
        result.diagnos2 =
            "ПРОГНОЗ БЛАГОПРИЯТНЫЙ,\\n\" + \"НИЗКИЙ РИСК ССО\\n\" + \"ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)


    }

    private fun loadRUVariant3() {
        binding.diagnosVariant.text = "3-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n"
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "БЛАГОПРИЯТНЫЙ,\n" + "Умеренный  РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "3-вариант"
        result.diagnos = ""
        result.diagnos1 = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n"
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"БЛАГОПРИЯТНЫЙ,\\n\" + \"Умеренный  РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant4() {
        binding.diagnosVariant.text = "4-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n"
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "+ короткие курсы диуретиков\n" + "Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "4-вариант"
        result.diagnos = ""
        result.diagnos1 = "КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n"
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"+ короткие курсы диуретиков\\n\" + \"Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant5() {
        binding.diagnosVariant.text = "5-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text =
            "необходимо КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n" + "Консультация нефролога\n" + ""
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "(исключить хаболевания почек не связанных с ХСН)\n" + "Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "5-вариант"
        result.diagnos = ""
        result.diagnos1 =
            "необходимо КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n\" + \"Консультация нефролога\n"
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"(исключить хаболевания почек не связанных с ХСН)\\n\" + \"Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant6() {
        binding.diagnosVariant.text = "6-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text =
            "1. КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n" + "2. КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "\n" + ""
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "(исключить хаболевания почек не связанных с ХСН)\n" + "Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "6-вариант"
        result.diagnos = ""
        result.diagnos1 =
            "1. КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n\" + \"2. КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"\\n\""
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"(исключить хаболевания почек не связанных с ХСН)\\n\" + \"Дополнительное исследование альбуминурии, креатинина крови, расчет СКФ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant7() {
        binding.diagnosVariant.text = "7-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text =
            "необходимо КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n" + "Консультация нефролога\n" + ""
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "(исключить хаболевания почек не связанных с ХСН)\n" + " РЕШИТЬ ВОПРОС О ГЕМОДИАЛИЗЕ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "7-вариант"
        result.diagnos = ""
        result.diagnos1 =
            "необходимо КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n\" + \"Консультация нефролога\\n\" "
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"(исключить хаболевания почек не связанных с ХСН)\\n\" + \" РЕШИТЬ ВОПРОС О ГЕМОДИАЛИЗЕ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadRUVariant8() {
        binding.diagnosVariant.text = "8-вариант"
        binding.diagnosTv.text = "Диагноз"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text =
            "1. КОНСУЛЬТАЦИЯ КАРДИОЛОГА\n" + "ЭКГ+ ЭХОКГ\n" + "2. КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + ""
        binding.diagnosResultTable2.text =
            "ПРОГНОЗ \n" + "НЕБЛАГОПРИЯТНЫЙ,\n" + "Высокий и Очень высокий РИСК ССО\n" + "КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\n" + "КОНСУЛЬТАЦИЯ НЕФРОЛОГА\n" + "(исключить хаболевания почек не связанных с ХСН)\n" + "РЕШИТЬ ВОПРОС О ГЕМОДИАЛИЗЕ"
        binding.diagnosResultTable3.text =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \n" + "Контроль своевременного  приема ЛС"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "8-вариант"
        result.diagnos = ""
        result.diagnos1 =
            "1. КОНСУЛЬТАЦИЯ КАРДИОЛОГА\\n\" + \"ЭКГ+ ЭХОКГ\\n\" + \"2. КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\""
        result.diagnos2 =
            "ПРОГНОЗ \\n\" + \"НЕБЛАГОПРИЯТНЫЙ,\\n\" + \"Высокий и Очень высокий РИСК ССО\\n\" + \"КОНСУЛЬТАЦИЯ КАРДИОЛОГА ВЕДЕНИЕ БОЛЬНЫХ НА ФОНЕ ОПТИМАЛЬНОЙ МЕДИКАМЕНТОЗНОЙ ТЕРАПИИ ХСН (иАПФ, БАБ, АМКР)\\n\" + \"КОНСУЛЬТАЦИЯ НЕФРОЛОГА\\n\" + \"(исключить хаболевания почек не связанных с ХСН)\\n\" + \"РЕШИТЬ ВОПРОС О ГЕМОДИАЛИЗЕ"
        result.diagnos3 =
            "Контроль употребляемой жидкости, употребляемой пищевой соли,  контроль диуреза, \\n\" + \"Контроль своевременного  приема ЛС"
        resultDatabase.resultDao().addResult(result)
    }


    /* variants for language KRILL*/

    private fun loadKRILLVariant1() {
        binding.diagnosVariant.text = "1-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = "SURUNKALI YuRAK YeTIShMOVChILIGI ANIQLANMADI"
        binding.card1.visibility = View.GONE
        binding.card2.visibility = View.GONE
        binding.card3.visibility = View.GONE

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "1-Variant"
        result.diagnos = "XFC"
        result.diagnos1 = "1"
        result.diagnos2 = "2"
        result.diagnos3 = "3"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant2() {
        binding.diagnosVariant.text = "2-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text = "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG"
        binding.diagnosResultTable2.text =
            "Ijobiy prognoz\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish xavfi past darajada\n" + "SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish"
        binding.diagnosResultTable3.text =
            "    • Ichilayotgan suyuqlik nazorati\n" + "    • •\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "    • •\tdiurez nazorati. \n" + "    • •\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "2-Variant"
        result.diagnos = ""
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG"
        result.diagnos2 =
            "Ijobiy prognoz\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish xavfi past darajada\\n\" + \"SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish"
        result.diagnos3 =
            "• Ichilayotgan suyuqlik nazorati\\n\" + \"    • •\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"    • •\\tdiurez nazorati. \\n\" + \"    • •\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant3() {
        binding.diagnosVariant.text = "3-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text = "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n"
        binding.diagnosResultTable2.text =
            "Ijobiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi o‘rta darajada\n" + "KARDIOLOG KO‘RIGI\n" + "SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish\n"
        binding.diagnosResultTable3.text =
            "• Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "3-Variant"
        result.diagnos = ""
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n"
        result.diagnos2 =
            "Ijobiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi o‘rta darajada\\n\" + \"KARDIOLOG KO‘RIGI\\n\" + \"SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish\\n"
        result.diagnos3 =
            "• Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant4() {
        binding.diagnosVariant.text = "4-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text = "  KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n"
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori\n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        binding.diagnosResultTable3.text =
            "    • Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "4-Variant"
        result.diagnos = ""
        result.diagnos1 = "  KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n"
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori\\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        result.diagnos3 =
            "    • Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant5() {
        binding.diagnosVariant.text = "5-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text =
            "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n" + "NEFROLOG KO‘RIGI\n" + ""
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori\n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "NEFROLOGNING KONSULTASIYaSI\n" + "(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        binding.diagnosResultTable3.text =
            "    • Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "5-Variant"
        result.diagnos = ""
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n\" + \"NEFROLOG KO‘RIGI\\n\""
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori\\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"NEFROLOGNING KONSULTASIYaSI\\n\" + \"(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        result.diagnos3 =
            "    • Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant6() {
        binding.diagnosVariant.text = "6-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text =
            "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n" + "NEFROLOG KO‘RIGI\n" + ""
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada\n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "NEFROLOGNING KONSULTASIYaSI\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        binding.diagnosResultTable3.text =
            "Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "6-Variant"
        result.diagnos = ""
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n\" + \"NEFROLOG KO‘RIGI\\n\""
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada\\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"NEFROLOGNING KONSULTASIYaSI\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash"
        result.diagnos3 =
            "Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant7() {
        binding.diagnosVariant.text = "7-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text =
            "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n" + "NEFROLOG KO‘RIGI"
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada \n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "NEFROLOGNING KONSULTASIYaSI\n" + "(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash\n" + "GEMODIALIZ MASALASINI HAL QILISh"
        binding.diagnosResultTable3.text =
            "Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "7-Variant"
        result.diagnos = ""
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n\" + \"NEFROLOG KO‘RIGI"
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada \\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"NEFROLOGNING KONSULTASIYaSI\\n\" + \"(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash\\n\" + \"GEMODIALIZ MASALASINI HAL QILISh"
        result.diagnos3 =
            "Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }

    private fun loadKRILLVariant8() {
        binding.diagnosVariant.text = "8-Variant"
        binding.diagnosTv.text = "Tashxis"
        binding.diagnosResult.text = ""
        binding.diagnosResultTable1.text =
            "KARDIOLOG KO‘RIGI\n" + "EKG+ EXOKG\n" + "NEFROLOG KO‘RIGI"
        binding.diagnosResultTable2.text =
            "Salbiy prognoz,\n" + "Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada\n" + "Qayta Kardiolog ko‘rigiga muhtoj\n" + " SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \n" + "+ diuretiklarning qiska kursi\n" + "NEFROLOGNING KONSULTASIYaSI\n" + "(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\n" + "+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash\n" + "GEMODIALIZ MASALASINI HAL QILISh"
        binding.diagnosResultTable3.text =
            "Ichilayotgan suyuqlik nazorati\n" + "•\tQabul qilayotgan osh tuzi miqdorining nazorati\n" + "•\tdiurez nazorati. \n" + "•\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"

        var result = ResultEntity()
        result.date = getCurrentDateAndTime()
        result.variant = "8-Variant"
        result.diagnos = ""
        result.diagnos1 = "KARDIOLOG KO‘RIGI\\n\" + \"EKG+ EXOKG\\n\" + \"NEFROLOG KO‘RIGI"
        result.diagnos2 =
            "Salbiy prognoz,\\n\" + \"Yurak qon tomir kasalliklar asoratlarining rivojlanish havfi yuqori va juda yuqori darajada\\n\" + \"Qayta Kardiolog ko‘rigiga muhtoj\\n\" + \" SYuEni optimal medikamentoz  davolash (AAF ingibitorlari, beta adrenoblokatorlar va mineral kortikoid reseptorlar antagonistlari) fonida olib borish \\n\" + \"+ diuretiklarning qiska kursi\\n\" + \"NEFROLOGNING KONSULTASIYaSI\\n\" + \"(SYuE bilan bog‘liq bo‘lmagan buyraklar kasalliklarini inkor qilish)\\n\" + \"+ al'buminuriya, qondagi kreatininning qo‘shimcha tekshiruvi, KFT hisoblash\\n\" + \"GEMODIALIZ MASALASINI HAL QILISh"
        result.diagnos3 =
            "Ichilayotgan suyuqlik nazorati\\n\" + \"•\\tQabul qilayotgan osh tuzi miqdorining nazorati\\n\" + \"•\\tdiurez nazorati. \\n\" + \"•\\tShifokor tomonidan buyurilgan dori vositalarning o‘z vaqtida qabul qilinishining nazorati"
        resultDatabase.resultDao().addResult(result)
    }


}