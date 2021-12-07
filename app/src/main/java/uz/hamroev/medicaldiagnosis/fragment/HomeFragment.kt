package uz.hamroev.medicaldiagnosis.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import uz.hamroev.medicaldiagnosis.cache.Cache
import uz.hamroev.medicaldiagnosis.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentHomeBinding
    var isOpen = false
    var isOpenA2 = false

    var isOpenB1 = false
    var isOpenB2 = false
    var isOpenB3 = false

    var isOpenC1 = false
    var isOpenC2 = false

    var isOpenD1 = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        Cache.init(binding.root.context)

        checkLanguage()

        binding.downToUpLottie.setOnClickListener {
            if (isOpen) {
                binding.downToUpLottie.setAnimation("down.json")
                binding.downToUpLottie.playAnimation()
                binding.downToUpLottie.setPadding(10)
                binding.bottomBody.visibility = View.GONE
                isOpen = false
            } else if (!isOpen) {
                binding.downToUpLottie.setAnimation("up.json")
                binding.downToUpLottie.playAnimation()
                binding.downToUpLottie.setPadding(0)
                binding.bottomBody.visibility = View.VISIBLE
                isOpen = true
            }


        }
        binding.downToUpLottieA2.setOnClickListener {
            if (isOpenA2) {
                binding.downToUpLottieA2.setAnimation("down.json")
                binding.downToUpLottieA2.playAnimation()
                binding.downToUpLottieA2.setPadding(10)
                binding.bottomBodyA2.visibility = View.GONE
                isOpenA2 = false
            } else if (!isOpenA2) {
                binding.downToUpLottieA2.setAnimation("up.json")
                binding.downToUpLottieA2.playAnimation()
                binding.downToUpLottieA2.setPadding(0)
                binding.bottomBodyA2.visibility = View.VISIBLE
                isOpenA2 = true
            }

        }
        binding.downToUpLottieB1.setOnClickListener {
            if (isOpenB1) {
                binding.downToUpLottieB1.setAnimation("down.json")
                binding.downToUpLottieB1.playAnimation()
                binding.downToUpLottieB1.setPadding(10)
                binding.bottomBodyB1.visibility = View.GONE
                isOpenB1 = false
            } else if (!isOpenB1) {
                binding.downToUpLottieB1.setAnimation("up.json")
                binding.downToUpLottieB1.playAnimation()
                binding.downToUpLottieB1.setPadding(0)
                binding.bottomBodyB1.visibility = View.VISIBLE
                isOpenB1 = true
            }

        }
        binding.downToUpLottieB2.setOnClickListener {
            if (isOpenB2) {
                binding.downToUpLottieB2.setAnimation("down.json")
                binding.downToUpLottieB2.playAnimation()
                binding.downToUpLottieB2.setPadding(10)
                binding.bottomBodyB2.visibility = View.GONE
                isOpenB2 = false
            } else if (!isOpenB2) {
                binding.downToUpLottieB2.setAnimation("up.json")
                binding.downToUpLottieB2.playAnimation()
                binding.downToUpLottieB2.setPadding(0)
                binding.bottomBodyB2.visibility = View.VISIBLE
                isOpenB2 = true
            }
        }
        binding.downToUpLottieB3.setOnClickListener {
            if (isOpenB3) {
                binding.downToUpLottieB3.setAnimation("down.json")
                binding.downToUpLottieB3.playAnimation()
                binding.downToUpLottieB3.setPadding(10)
                binding.bottomBodyB3.visibility = View.GONE
                isOpenB3 = false
            } else if (!isOpenB3) {
                binding.downToUpLottieB3.setAnimation("up.json")
                binding.downToUpLottieB3.playAnimation()
                binding.downToUpLottieB3.setPadding(0)
                binding.bottomBodyB3.visibility = View.VISIBLE
                isOpenB3 = true
            }
        }
        binding.downToUpLottieC1.setOnClickListener {
            if (isOpenC1) {
                binding.downToUpLottieC1.setAnimation("down.json")
                binding.downToUpLottieC1.playAnimation()
                binding.downToUpLottieC1.setPadding(10)
                binding.bottomBodyC1.visibility = View.GONE
                isOpenC1 = false
            } else if (!isOpenC1) {
                binding.downToUpLottieC1.setAnimation("up.json")
                binding.downToUpLottieC1.playAnimation()
                binding.downToUpLottieC1.setPadding(0)
                binding.bottomBodyC1.visibility = View.VISIBLE
                isOpenC1 = true
            }

        }
        binding.downToUpLottieC2.setOnClickListener {
            if (isOpenC2) {
                binding.downToUpLottieC2.setAnimation("down.json")
                binding.downToUpLottieC2.playAnimation()
                binding.downToUpLottieC2.setPadding(10)
                binding.bottomBodyC2.visibility = View.GONE
                isOpenC2 = false
            } else if (!isOpenC2) {
                binding.downToUpLottieC2.setAnimation("up.json")
                binding.downToUpLottieC2.playAnimation()
                binding.downToUpLottieC2.setPadding(0)
                binding.bottomBodyC2.visibility = View.VISIBLE
                isOpenC2 = true
            }
        }
        binding.downToUpLottieD1.setOnClickListener {
            if (isOpenD1) {
                binding.downToUpLottieD1.setAnimation("down.json")
                binding.downToUpLottieD1.playAnimation()
                binding.downToUpLottieD1.setPadding(10)
                binding.bottomBodyD1.visibility = View.GONE
                isOpenD1 = false
            } else if (!isOpenD1) {
                binding.downToUpLottieD1.setAnimation("up.json")
                binding.downToUpLottieD1.playAnimation()
                binding.downToUpLottieD1.setPadding(0)
                binding.bottomBodyD1.visibility = View.VISIBLE
                isOpenD1 = true
            }

        }







        return binding.root
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

    private fun loadRuData() {
        binding.titleMainHome.text = "Алгоритм ранней диагностики дисфункции почек и прогнозирования течения хронической сердечной недостаточности  в условиях первичного звена здравоохранения"

        binding.titleMainA.text = "А. Определите функциональный класс ХСН"
        binding.titleMainB.text = "В. Определите клинические признаки ХСН\n" + "\n" + "В. КЛИНИЧЕСКИЕ ПРИЗНАКИ ХРОНИЧЕСКОЙ СЕРДЕЧНОЙ НЕДОСТАТОЧНОСТИ"
        binding.titleMainC.text = "С. Определите клинические признаки Дисфункции Почек"
        binding.titleMainD.text = "D.  Определение тяжести течения дисфункции почек  по Скорости клубочковой фильтрации "

        binding.titleA1.text = "А1. По баллам Шкалы Оценки Клинического Состояния (от 1 до 9 балла):  V_ балл ШОКС  ( ФК I-≤3 балла, ФК II 4-6, ФК III 7-9,ФК IV>9)"
        binding.titleA2.text = "А2. по пройденной дистанции ТШХ (метр)  _Z__м\n" + "ТШХ"
        binding.titleB1.text = "В1. Клинические признаки недостаточности малого круга кровообращения \n" + "(не менее 3х признаков)"
        binding.titleB2.text = "В2.  Клинические признаки недостаточности большого круга кровообращения\n" + " (не менее 2х признаков)"
        binding.titleB3.text = "В3. Общие признаки Хронической сердечной недостаточности \n" + "(не менее 3х признаков)"
        binding.titleC1.text = "С1. Ранние признаки ДП (не менее 3х признаков)"
        binding.titleC2.text = "С2. Поздние признаки ДП (не менее 2х признаков)"
        binding.titleD1.text = "D.  Определение тяжести течения дисфункции почек  по Скорости клубочковой фильтрации"

        binding.A1question1.text = "1. Одышка: "
        binding.A1question2.text = "2. Изменился ли за последнюю неделю вес:"
        binding.A1question3.text = "3. Жалобы на перебои в работе сердца: "
        binding.A1question4.text = "4. В каком положении находится в постели: "
        binding.A1question5.text = "5. Набухшие шейные вены:"
        binding.A1question6.text = "6. Хрипы в легких: "
        binding.A1question7.text = "7. Наличие ритма галопа: "
        binding.A1question8.text = "8. Печень: "
        binding.A1question9.text = "9. Отеки: "
        binding.A1question10.text = "10. Уровень САД: "

        binding.questionTitleA2.text = "А2. по пройденной дистанции ТШХ (метр)  _Z__м\n" + "ТШХ "

        binding.a2RadioButton1.text = "I. ФК >551м"
        binding.a2RadioButton2.text = "II ФК 426-550м"
        binding.a2RadioButton3.text = "III ФК 301-425м"
        binding.a2RadioButton4.text = "IV ФК менее 300м"




    }

    private fun loadKrillData() {

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }
}
