package uz.hamroev.medicaldiagnosis.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import uz.hamroev.medicaldiagnosis.R
import uz.hamroev.medicaldiagnosis.activity.ResultActivity
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

    var a1Question1 = 0
    var a1Question2 = 0
    var a1Question3 = 0
    var a1Question4 = 0
    var a1Question5 = 0
    var a1Question6 = 0
    var a1Question7 = 0
    var a1Question8 = 0
    var a1Question9 = 0
    var a1Question10 = 0

    var a1QuestionSelect1 = 0
    var a1QuestionSelect2 = 0
    var a1QuestionSelect3 = 0
    var a1QuestionSelect4 = 0
    var a1QuestionSelect5 = 0
    var a1QuestionSelect6 = 0
    var a1QuestionSelect7 = 0
    var a1QuestionSelect8 = 0
    var a1QuestionSelect9 = 0
    var a1QuestionSelect10 = 0

    var a2Question = 0

    var b1CheckBox1 = 0
    var b1CheckBox2 = 0
    var b1CheckBox3 = 0
    var b1CheckBox4 = 0
    var b1CheckBox5 = 0
    var b1CheckBox6 = 0

    var b2CheckBox1 = 0
    var b2CheckBox2 = 0
    var b2CheckBox3 = 0
    var b2CheckBox4 = 0

    var b3CheckBox1 = 0
    var b3CheckBox2 = 0
    var b3CheckBox3 = 0
    var b3CheckBox4 = 0
    var b3CheckBox5 = 0
    var b3CheckBox6 = 0
    var b3CheckBox7 = 0
    var b3CheckBox8 = 0

    var c1CheckBox1 = 0
    var c1CheckBox2 = 0
    var c1CheckBox3 = 0
    var c1CheckBox4 = 0
    var c1CheckBox5 = 0
    var c1CheckBox6 = 0

    var c2CheckBox1 = 0
    var c2CheckBox2 = 0
    var c2CheckBox3 = 0
    var c2CheckBox4 = 0
    var c2CheckBox5 = 0

    var d1Question1 = 0

    var isA1Select = 0

    var sumA1Selected = 0

    var sumA1 = -1
    var sumA2 = -1

    var sumB1 = -1
    var sumB2 = -1
    var sumB3 = -1

    var sumC1 = -1
    var sumC2 = -1

    var sumD1 = -1

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        Cache.init(binding.root.context)

        checkLanguage()

        /* menu larni yigib qo'yish*/
        binding.downToUpLottie.setOnClickListener {
            if (isOpen) {
                binding.downToUpLottie.setAnimation("down.json")
                binding.downToUpLottie.playAnimation()
                binding.downToUpLottie.setPadding(10)
                binding.bottomBody.visibility = View.GONE
                isOpen = false
            } else if (!isOpen) {
                val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_open_menu)
                binding.downToUpLottie.setAnimation("up.json")
                binding.downToUpLottie.playAnimation()
                binding.downToUpLottie.setPadding(0)
                binding.bottomBody.visibility = View.VISIBLE
                binding.bottomBody.startAnimation(anim)
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
                val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_open_menu)
                binding.downToUpLottieA2.setAnimation("up.json")
                binding.downToUpLottieA2.playAnimation()
                binding.downToUpLottieA2.setPadding(0)
                binding.bottomBodyA2.visibility = View.VISIBLE
                binding.bottomBodyA2.startAnimation(anim)
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
                val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_open_menu)
                binding.downToUpLottieB1.setAnimation("up.json")
                binding.downToUpLottieB1.playAnimation()
                binding.downToUpLottieB1.setPadding(0)
                binding.bottomBodyB1.visibility = View.VISIBLE
                binding.bottomBodyB1.startAnimation(anim)
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
                val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_open_menu)
                binding.downToUpLottieB2.setAnimation("up.json")
                binding.downToUpLottieB2.playAnimation()
                binding.downToUpLottieB2.setPadding(0)
                binding.bottomBodyB2.visibility = View.VISIBLE
                binding.bottomBodyB2.startAnimation(anim)
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
                val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_open_menu)
                binding.downToUpLottieB3.setAnimation("up.json")
                binding.downToUpLottieB3.playAnimation()
                binding.downToUpLottieB3.setPadding(0)
                binding.bottomBodyB3.visibility = View.VISIBLE
                binding.bottomBodyB3.startAnimation(anim)
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
                val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_open_menu)
                binding.downToUpLottieC1.setAnimation("up.json")
                binding.downToUpLottieC1.playAnimation()
                binding.downToUpLottieC1.setPadding(0)
                binding.bottomBodyC1.visibility = View.VISIBLE
                binding.bottomBodyC1.startAnimation(anim)
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
                val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_open_menu)
                binding.downToUpLottieC2.setAnimation("up.json")
                binding.downToUpLottieC2.playAnimation()
                binding.downToUpLottieC2.setPadding(0)
                binding.bottomBodyC2.visibility = View.VISIBLE
                binding.bottomBodyC2.startAnimation(anim)
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
                val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_open_menu)
                binding.downToUpLottieD1.setAnimation("up.json")
                binding.downToUpLottieD1.playAnimation()
                binding.downToUpLottieD1.setPadding(0)
                binding.bottomBodyD1.visibility = View.VISIBLE
                binding.bottomBodyD1.startAnimation(anim)
                isOpenD1 = true
            }

        }

        /* check A1 bo'lim */
        binding.A1question1RadioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            val sId = radioGroup.checkedRadioButtonId
            val btn = binding.root.findViewById<RadioButton>(sId) as RadioButton
            when (checkedId) {
                R.id.A1question1_RadioButton1 -> {
                    a1QuestionSelect1 = 0
                    a1QuestionSelect1 = 10
                    binding.resultBtnBackground.setBackgroundResource(R.color.azure)
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1Question1 = 0
                }
                R.id.A1question1_RadioButton2 -> {
                    a1QuestionSelect1 = 0
                    a1QuestionSelect1 = 10
                    binding.resultBtnBackground.setBackgroundResource(R.color.azure)
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1Question1 = 0
                    a1Question1 = 1
                }
                R.id.A1question1_RadioButton3 -> {
                    a1QuestionSelect1 = 0
                    a1QuestionSelect1 = 10
                    binding.resultBtnBackground.setBackgroundResource(R.color.azure)
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1Question1 = 0
                    a1Question1 = 2
                }
            }
        }
        binding.A1question2RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question2_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1Question2 = 0
                    a1QuestionSelect2 = 0
                    a1QuestionSelect2 = 10
                }
                R.id.A1question2_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect2 = 0
                    a1QuestionSelect2 = 10
                    a1Question2 = 0
                    a1Question2 = 1

                }
            }
        }
        binding.A1question3RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question3_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1Question3 = 0
                    a1QuestionSelect3 = 0
                    a1QuestionSelect3 = 10
                }
                R.id.A1question3_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1Question3 = 0
                    a1Question3 = 1
                    a1QuestionSelect3 = 0
                    a1QuestionSelect3 = 10

                }
            }
        }
        binding.A1question4RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question4_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect4 = 0
                    a1QuestionSelect4 = 10
                    a1Question4 = 0
                }
                R.id.A1question4_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect4 = 0
                    a1QuestionSelect4 = 10
                    a1Question4 = 0
                    a1Question4 = 1
                }
                R.id.A1question4_RadioButton3 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect4 = 0
                    a1QuestionSelect4 = 10
                    a1Question4 = 0
                    a1Question4 = 2
                }
                R.id.A1question4_RadioButton4 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect4 = 0
                    a1QuestionSelect4 = 10
                    a1Question4 = 0
                    a1Question4 = 3
                }
            }
        }
        binding.A1question5RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question5_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect5 = 0
                    a1QuestionSelect5 = 10
                    a1Question5 = 0
                }
                R.id.A1question5_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect5 = 0
                    a1QuestionSelect5 = 10
                    a1Question5 = 0
                    a1Question5 = 1
                }
                R.id.A1question5_RadioButton3 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect5 = 0
                    a1QuestionSelect5 = 10
                    a1Question5 = 0
                    a1Question5 = 2
                }

            }
        }
        binding.A1question6RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question6_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect6 = 0
                    a1QuestionSelect6 = 10
                    a1Question6 = 0
                }
                R.id.A1question6_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect6 = 0
                    a1QuestionSelect6 = 10
                    a1Question6 = 0
                    a1Question6 = 1
                }
                R.id.A1question6_RadioButton3 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect6 = 0
                    a1QuestionSelect6 = 10
                    a1Question6 = 0
                    a1Question6 = 2
                }
                R.id.A1question6_RadioButton4 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect6 = 0
                    a1QuestionSelect6 = 10
                    a1Question6 = 0
                    a1Question6 = 3
                }

            }
        }
        binding.A1question7RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question7_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect7 = 0
                    a1QuestionSelect7 = 10
                    a1Question7 = 0
                }
                R.id.A1question7_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect7 = 0
                    a1QuestionSelect7 = 10
                    a1Question7 = 0
                    a1Question7 = 1
                }
            }
        }
        binding.A1question8RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question8_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect8 = 0
                    a1QuestionSelect8 = 10
                    a1Question8 = 0
                }
                R.id.A1question8_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect8 = 0
                    a1QuestionSelect8 = 10
                    a1Question8 = 0
                    a1Question8 = 1
                }
                R.id.A1question8_RadioButton3 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect8 = 0
                    a1QuestionSelect8 = 10
                    a1Question8 = 0
                    a1Question8 = 2
                }
            }
        }
        binding.A1question9RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question9_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect9 = 0
                    a1QuestionSelect9 = 10
                    a1Question9 = 0
                }
                R.id.A1question9_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect9 = 0
                    a1QuestionSelect9 = 10
                    a1Question9 = 0
                    a1Question9 = 1
                }
                R.id.A1question9_RadioButton3 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect9 = 0
                    a1QuestionSelect9 = 10
                    a1Question9 = 0
                    a1Question9 = 2
                }
                R.id.A1question9_RadioButton4 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect9 = 0
                    a1QuestionSelect9 = 10
                    a1Question9 = 0
                    a1Question9 = 3
                }
            }
        }
        binding.A1question10RadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.A1question10_RadioButton1 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect10 = 0
                    a1QuestionSelect10 = 10
                    a1Question10 = 0
                }
                R.id.A1question10_RadioButton2 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect10 = 0
                    a1QuestionSelect10 = 10
                    a1Question10 = 0
                    a1Question10 = 1
                }
                R.id.A1question10_RadioButton3 -> {
                    binding.bottomBodyA2.visibility = View.GONE
                    binding.topTitleMainA2.visibility = View.GONE
                    a1QuestionSelect10 = 0
                    a1QuestionSelect10 = 10
                    a1Question10 = 0
                    a1Question10 = 2
                }
            }
        }

        /* check A2 bo'lim */
        binding.a2RadioGroup.setOnCheckedChangeListener { radioGruop, i ->
            when (i) {
                R.id.a2_radioButton1 -> {
                    binding.resultBtnBackground.setBackgroundResource(R.color.azure)
                    binding.bottomBody.visibility = View.GONE
                    binding.topTitleMain.visibility = View.GONE
                    sumA1Selected = 100
                    a2Question = 0
                    sumA2 = a2Question
                }
                R.id.a2_radioButton2 -> {
                    binding.resultBtnBackground.setBackgroundResource(R.color.azure)
                    binding.bottomBody.visibility = View.GONE
                    binding.topTitleMain.visibility = View.GONE
                    sumA1Selected = 100
                    a2Question = 0
                    a2Question = 1
                    sumA2 = a2Question
                }
                R.id.a2_radioButton3 -> {
                    binding.resultBtnBackground.setBackgroundResource(R.color.azure)
                    binding.bottomBody.visibility = View.GONE
                    binding.topTitleMain.visibility = View.GONE
                    sumA1Selected = 100
                    a2Question = 0
                    a2Question = 2
                    sumA2 = a2Question
                }
                R.id.a2_radioButton4 -> {
                    binding.resultBtnBackground.setBackgroundResource(R.color.azure)
                    binding.bottomBody.visibility = View.GONE
                    binding.topTitleMain.visibility = View.GONE
                    sumA1Selected = 100
                    a2Question = 0
                    a2Question = 3
                    sumA2 = a2Question
                }
            }
        }

        /* check B1 bo'lim */
        binding.b1CheckBox1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b1CheckBox1 = 1
            } else {
                b1CheckBox1 = 0
            }
        }
        binding.b1CheckBox2.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b1CheckBox2 = 1
            } else {
                b1CheckBox2 = 0
            }
        }
        binding.b1CheckBox3.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b1CheckBox3 = 1
            } else {
                b1CheckBox3 = 0
            }
        }
        binding.b1CheckBox4.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b1CheckBox4 = 1
            } else {
                b1CheckBox4 = 0
            }
        }
        binding.b1CheckBox5.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b1CheckBox5 = 1
            } else {
                b1CheckBox5 = 0
            }
        }
        binding.b1CheckBox6.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b1CheckBox6 = 1
            } else {
                b1CheckBox6 = 0
            }
        }

        /* check B2 bo'lim */
        binding.b2CheckBox1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b2CheckBox1 = 1
            } else {
                b2CheckBox1 = 0
            }
        }
        binding.b2CheckBox2.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b2CheckBox2 = 1
            } else {
                b2CheckBox2 = 0
            }
        }
        binding.b2CheckBox3.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b2CheckBox3 = 1
            } else {
                b2CheckBox3 = 0
            }
        }
        binding.b2CheckBox4.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b2CheckBox4 = 1
            } else {
                b2CheckBox4 = 0
            }
        }

        /* check B3 bo'lim */
        binding.b3CheckBox1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b3CheckBox1 = 1
            } else {
                b3CheckBox1 = 0
            }
        }
        binding.b3CheckBox2.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b3CheckBox2 = 1
            } else {
                b3CheckBox2 = 0
            }
        }
        binding.b3CheckBox3.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b3CheckBox3 = 1
            } else {
                b3CheckBox3 = 0
            }
        }
        binding.b3CheckBox4.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b3CheckBox4 = 1
            } else {
                b3CheckBox4 = 0
            }
        }
        binding.b3CheckBox5.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b3CheckBox5 = 1
            } else {
                b3CheckBox5 = 0
            }
        }
        binding.b3CheckBox6.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b3CheckBox6 = 1
            } else {
                b3CheckBox6 = 0
            }
        }
        binding.b3CheckBox7.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b3CheckBox7 = 1
            } else {
                b3CheckBox7 = 0
            }
        }
        binding.b3CheckBox8.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                b3CheckBox8 = 1
            } else {
                b3CheckBox8 = 0
            }
        }

        /* check C1 bo'lim */
        binding.c1CheckBox1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c1CheckBox1 = 1
            } else {
                c1CheckBox1 = 0
            }
        }
        binding.c1CheckBox2.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c1CheckBox2 = 1
            } else {
                c1CheckBox2 = 0
            }
        }
        binding.c1CheckBox3.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c1CheckBox3 = 1
            } else {
                c1CheckBox3 = 0
            }
        }
        binding.c1CheckBox4.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c1CheckBox4 = 1
            } else {
                c1CheckBox4 = 0
            }
        }
        binding.c1CheckBox5.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c1CheckBox5 = 1
            } else {
                c1CheckBox5 = 0
            }
        }
        binding.c1CheckBox6.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c1CheckBox6 = 1
            } else {
                c1CheckBox6 = 0
            }
        }

        /* check C2 bo'lim */
        binding.c2CheckBox1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c2CheckBox1 = 1
            } else {
                c2CheckBox1 = 0
            }
        }
        binding.c2CheckBox2.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c2CheckBox2 = 1
            } else {
                c2CheckBox2 = 0
            }
        }
        binding.c2CheckBox3.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c2CheckBox3 = 1
            } else {
                c2CheckBox3 = 0
            }
        }
        binding.c2CheckBox4.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c2CheckBox4 = 1
            } else {
                c2CheckBox4 = 0
            }
        }
        binding.c2CheckBox5.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                c2CheckBox5 = 1
            } else {
                c2CheckBox5 = 0
            }
        }

        /* check D1 bo'lim */
        binding.D1questionRadioGroup.setOnCheckedChangeListener { radioGruop, i ->
            when (i) {
                R.id.D1question_RadioButton1 -> {
                    d1Question1 = 0
                    sumD1 = d1Question1
                }
                R.id.D1question_RadioButton2 -> {
                    d1Question1 = 0
                    d1Question1 = 1
                    sumD1 = d1Question1
                }
                R.id.D1question_RadioButton3 -> {
                    d1Question1 = 0
                    d1Question1 = 2
                    sumD1 = d1Question1
                }
            }
        }












        binding.resultBtn.setOnClickListener {
            var sumA1Selected2 =
                a1QuestionSelect1 + a1QuestionSelect2 + a1QuestionSelect3 + a1QuestionSelect4 + a1QuestionSelect5 + a1QuestionSelect6 + a1QuestionSelect7 + a1QuestionSelect8 + a1QuestionSelect9 + a1QuestionSelect10
            sumC1 =
                c1CheckBox1 + c1CheckBox2 + c1CheckBox3 + c1CheckBox4 + c1CheckBox5 + c1CheckBox6
            sumC2 = c2CheckBox1 + c2CheckBox2 + c2CheckBox3 + c2CheckBox4 + c2CheckBox5
            sumB3 =
                b3CheckBox1 + b3CheckBox2 + b3CheckBox3 + b3CheckBox4 + b3CheckBox5 + b3CheckBox6 + b3CheckBox7 + b3CheckBox8
            sumB2 = b2CheckBox1 + b2CheckBox2 + b2CheckBox3 + b2CheckBox4
            sumB1 =
                b1CheckBox1 + b1CheckBox2 + b1CheckBox3 + b1CheckBox4 + b1CheckBox5 + b1CheckBox6
            sumA1 =
                a1Question1 + a1Question2 + a1Question3 + a1Question4 + a1Question5 + a1Question6 + a1Question7 + a1Question8 + a1Question9 + a1Question10

//            Toast.makeText(
//                binding.root.context,
//                "Sum A1 Selected A1 = ${sumA1Selected}" + "\nA1=$sumA1" + "\nA2=${sumA2}" + "\nB1=${sumB1}" + "\nB2=${sumB2}" + "\nB3=${sumB3}" + "\nC1=${sumC1}" + "\nC2=${sumC2}" + "\nD1=${sumD1}",
//                Toast.LENGTH_SHORT
//            ).show()

            if (sumA1Selected == 100 || sumA1Selected2 == 100) {

                if (sumB1 >= 3) {

                    if (sumB2 >= 2) {
                        //startActivity(Intent(binding.root.context, ResultActivity::class.java))
                    } else if (sumB2 < 2) {
                    }

                    if (sumB3 >= 3) {
                       // startActivity(Intent(binding.root.context, ResultActivity::class.java))
                    } else if (sumB3 < 3) {
                    }

                    if (sumC1 >= 3) {
                       // startActivity(Intent(binding.root.context, ResultActivity::class.java))
                    } else if (sumC1 < 3) {
                    }

                    if (sumC2 >= 2) {
                       // startActivity(Intent(binding.root.context, ResultActivity::class.java))
                    } else if (sumC2 < 2) {
                    }

                    Cache.a1 = sumA1
                    Cache.a2 = sumA2

                    Cache.b1 = sumB1
                    Cache.b2 = sumB2
                    Cache.b3 = sumB3

                    Cache.c1 = sumC1
                    Cache.c2 = sumC2

                    Cache.d1 = sumD1



                    startActivity(Intent(binding.root.context, ResultActivity::class.java))
                } else if (sumB1 < 3) {
                    Toast.makeText(
                        binding.root.context,
                        "B1 bo'limni kamida 3 ta belgilang",
                        Toast.LENGTH_SHORT
                    ).show()
                }



            } else {
                Toast.makeText(
                    binding.root.context,
                    "A1 yoki A2 bo'limni belgilang",
                    Toast.LENGTH_SHORT
                ).show()
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
        binding.titleMainHome.text =
            "Алгоритм ранней диагностики дисфункции почек и прогнозирования течения хронической сердечной недостаточности  в условиях первичного звена здравоохранения"

        binding.titleMainA.text = "А. Определите функциональный класс ХСН"
        binding.titleMainB.text =
            "В. Определите клинические признаки ХСН\n" + "\n" + "В. КЛИНИЧЕСКИЕ ПРИЗНАКИ ХРОНИЧЕСКОЙ СЕРДЕЧНОЙ НЕДОСТАТОЧНОСТИ"
        binding.titleMainC.text = "С. Определите клинические признаки Дисфункции Почек"
        binding.titleMainD.text =
            "D.  Определение тяжести течения дисфункции почек  по Скорости клубочковой фильтрации "

        binding.titleA1.text =
            "А1. По баллам Шкалы Оценки Клинического Состояния (от 1 до 9 балла):  V_ балл ШОКС  ( ФК I-≤3 балла, ФК II 4-6, ФК III 7-9,ФК IV>9)"
        binding.titleA2.text = "А2. по пройденной дистанции ТШХ (метр)  _Z__м\n" + "ТШХ"
        binding.titleB1.text =
            "В1. Клинические признаки недостаточности малого круга кровообращения \n" + "(не менее 3х признаков)"
        binding.titleB2.text =
            "В2.  Клинические признаки недостаточности большого круга кровообращения\n" + " (не менее 2х признаков)"
        binding.titleB3.text =
            "В3. Общие признаки Хронической сердечной недостаточности \n" + "(не менее 3х признаков)"
        binding.titleC1.text = "С1. Ранние признаки ДП (не менее 3х признаков)"
        binding.titleC2.text = "С2. Поздние признаки ДП (не менее 2х признаков)"
        binding.titleD1.text =
            "D.  Определение тяжести течения дисфункции почек  по Скорости клубочковой фильтрации"



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

        // Radio gruoplarga text beramiz
        binding.A1question1RadioButton1.text = "0 – нет"
        binding.A1question1RadioButton2.text = "1 – при нагрузке"
        binding.A1question1RadioButton3.text = "2 – в покое"

        binding.A1question2RadioButton1.text = "0 – нет"
        binding.A1question2RadioButton2.text = "1 – увеличился"

        binding.A1question3RadioButton1.text = "0 – нет"
        binding.A1question3RadioButton2.text = "1 – есть"

        binding.A1question4RadioButton1.text = "0 – горизонтально"
        binding.A1question4RadioButton2.text = "1 – с приподнятым головным концом (2 подушки)"
        binding.A1question4RadioButton3.text = "2 – плюс просыпается от удушья"
        binding.A1question4RadioButton4.text = "3 – сидя"

        binding.A1question5RadioButton1.text = "0 – нет"
        binding.A1question5RadioButton2.text = "1 – лежа"
        binding.A1question5RadioButton3.text = "2 – стоя"

        binding.A1question6RadioButton1.text = "0 – нет"
        binding.A1question6RadioButton2.text = "1 – нижние отделы (до 1/3)"
        binding.A1question6RadioButton3.text = "2 – до лопаток (до 2/3)"
        binding.A1question6RadioButton4.text = "3 – над всей поверхностью легких"

        binding.A1question7RadioButton1.text = "0 – нет"
        binding.A1question7RadioButton2.text = "1 – есть"

        binding.A1question8RadioButton1.text = "0 – не увеличена"
        binding.A1question8RadioButton2.text = "1 – до 5 см"
        binding.A1question8RadioButton3.text = "2 – более 5 см"

        binding.A1question9RadioButton1.text = "0 – нет"
        binding.A1question9RadioButton2.text = "1 – пастозность"
        binding.A1question9RadioButton3.text = "2 – отеки"
        binding.A1question9RadioButton4.text = "3 – анасарка"

        binding.A1question10RadioButton1.text = "0 – > 120"
        binding.A1question10RadioButton2.text = "1 – 100-120"
        binding.A1question10RadioButton3.text = "2 – < 100 мм рт.ст."




        binding.a2RadioButton1.text = "I. ФК >551м"
        binding.a2RadioButton2.text = "II ФК 426-550м"
        binding.a2RadioButton3.text = "III ФК 301-425м"
        binding.a2RadioButton4.text = "IV ФК менее 300м"

        /*  har bir bo'lim savol nomi B1 B2 B3 C1 C2 D bo'lim savol nomalri bo'ladi checkbox ni tepasidagi savol titlelar */
        binding.titleQuestionB1.text =
            "В1. Клинические признаки недостаточности малого круга кровообращения \n" +
                    "(не менее 3х признаков)"
        binding.titleQuestionB2.text =
            "В2.  Клинические признаки недостаточности большого круга кровообращения\n" +
                    " (не менее 2х признаков)"
        binding.titleQuestionB3.text =
            "В3. Общие признаки Хронической сердечной недостаточности \n" +
                    "(не менее 3х признаков)"

        binding.titleQuestionC1.text = "С1. Ранние признаки ДП (не менее 3х признаков):"
        binding.titleQuestionC2.text = "С2. Поздние признаки ДП (не менее 2х признаков):"

        binding.D1question.text =
            "D.  Определение тяжести течения дисфункции почек  по Скорости клубочковой фильтрации"


        binding.b1CheckBox1.text = "Одышка"
        binding.b1CheckBox2.text = "Ортопноэ"
        binding.b1CheckBox3.text = "Хрипы в легких"
        binding.b1CheckBox4.text = "Тахикардия"
        binding.b1CheckBox5.text = "Тахипное"
        binding.b1CheckBox6.text = "Сухой кашель"

        binding.b2CheckBox1.text = "Тяжесть в нижних конечностях"
        binding.b2CheckBox2.text = "Тяжесть в правом подреберье"
        binding.b2CheckBox3.text = "Гепатомегалия"
        binding.b2CheckBox4.text = "Асцит"

        binding.b3CheckBox1.text = "Утомляемость"
        binding.b3CheckBox2.text = "Слабость"
        binding.b3CheckBox3.text = "Снижение памяти"
        binding.b3CheckBox4.text = "Снижение аппетита"
        binding.b3CheckBox5.text = "Сухость и бледность кожных покровов"
        binding.b3CheckBox6.text = "Снижение массы тела"
        binding.b3CheckBox7.text = "Тошнота "
        binding.b3CheckBox8.text = "Нарушение сна"

        binding.c1CheckBox1.text = "Никтурия"
        binding.c1CheckBox2.text = "Олигоурия"
        binding.c1CheckBox3.text = "Отеки в нижних конечностях, лица и рук"
        binding.c1CheckBox4.text = "Апатия"
        binding.c1CheckBox5.text = "Слабость"
        binding.c1CheckBox6.text = "Жажда"

        binding.c2CheckBox1.text = "Постоянное чувство тошноты"
        binding.c2CheckBox2.text = "Судорги"
        binding.c2CheckBox3.text = "Чувство холода"
        binding.c2CheckBox4.text = "Извращение вкуса"
        binding.c2CheckBox5.text = "Снижение либидо"

        binding.D1questionRadioButton1.text = "Д1 = рСКФ  более 90 мл/мин/1,73 м²"
        binding.D1questionRadioButton2.text = "Д2  = рСКФ  90-60 мл/мин/1,73 м²"
        binding.D1questionRadioButton3.text = "Д3 =  рСКФ  менеее 60 мл/мин/1,73 м²"


    }

    private fun loadKrillData() {
        binding.titleMainHome.text =
            "SOG‘LIQNI SAQLAShNING BIRLAMChI BO‘G‘INI ShAROITIDA SURUNKALI YuRAK YeTIShMOVChILIGI KEChIShINI PROGNOZLASh VA BUYRAK DISFUNKSIYaSI ERTA TAShXISINING ALGORITMI "
        binding.titleMainA.text =
            "A. Surunkali yurak yetishmovchiligining funksional sinfini aniqlang"
        binding.titleMainB.text = "V. SYUE klinik belgilarini aniqlash\n" +
                "\n" +
                "V. SURUNKALI YuRAK YeTIShMOVChILIGINING KLINIK BELGILARI\n"
        binding.titleMainC.text = "C. Buyraklar faoliyati disfunksiyasining belgilarini belgilang "
        binding.titleMainD.text =
            "D.  Buyraklar faoliyati disfunksiyasining og‘irlik darajasini aniqlash (Koptokchalar filtratsiyasi tezligiga ko‘ra):"

        binding.titleA1.text =
            "A1. Surunkali yurak yetishmovchiligining funksional sinfini Klinik Holatni Baholash Shkalasi bo‘yicha (1dan 9gacha ball) aniqlash:  \n" +
                    "KHBSh  ( FS I-≤3 ball, FS II 4-6, FS III 7-9,FS IV>9)"
        binding.titleA2.text =
            "A2. 6 daqiqalik yurish sinamasi natijalariga ko‘ra SYUE FSni aniqlash (metr) ____ m"
        binding.titleB1.text =
            "V1. Kichik qon aylanish doirasidagi yurak yetishmovchiligining klinik belgilari (3ta belgidan kam bo‘lmagan)"
        binding.titleB2.text =
            "V2.  Katta qon aylanish doirasidagi yurak yetishmovchiligining klinik belgilari (2ta belgidan kam bo‘lmagan)"
        binding.titleB3.text = "V3. Surunkali yurak yetishmovchiligining umumiy belgilari \n" +
                "(3ta belgidan kam bo‘lmagan)"
        binding.titleC1.text = "C1. Buyraklar faoliyati disfunksiyasining erta belgilari\n" +
                "(3ta belgidan kam bo‘lmagan):"
        binding.titleC2.text = "С2. Buyraklar faoliyati disfunksiyasining kechki belgilari\n" +
                "(2ta belgidan kam bo‘lmagan):"
        binding.titleD1.text =
            "D.  Buyraklar faoliyati disfunksiyasining og‘irlik darajasini aniqlash (Koptokchalar filtratsiyasi tezligiga ko‘ra):"



        binding.A1question1.text = "1. Hansirash: "
        binding.A1question2.text = "2. So‘nggi haftada vazn o‘zgardimi?"
        binding.A1question3.text = "3. Yurak urib ketishiga shikoyatlar: "
        binding.A1question4.text = "4. Bemor yotgandagi holati:"
        binding.A1question5.text = "5. Bo‘yin venalarining bo‘rtishi:"
        binding.A1question6.text = "6. O‘pkadagi xirillashlar: "
        binding.A1question7.text = "7. Ot dupuri ritmi: "
        binding.A1question8.text = "8. Jigar:"
        binding.A1question9.text = "9. Oyoqdagi shishlar: "
        binding.A1question10.text = "10. SAQB darajasi: "

        binding.questionTitleA2.text =
            "A2. 6 daqiqalik yurish sinamasi natijalariga ko‘ra SYUE FSni aniqlash (metr) ____ m"

        // Radio gruoplarga text beramiz
        binding.A1question1RadioButton1.text = "0 – yo‘q"
        binding.A1question1RadioButton2.text = "1 – jismoniy yuklamada"
        binding.A1question1RadioButton3.text = "2 – tinch holatda"

        binding.A1question2RadioButton1.text = "0 – yo‘q"
        binding.A1question2RadioButton2.text = "1 – ko‘paydi"

        binding.A1question3RadioButton1.text = "0 – yo‘q"
        binding.A1question3RadioButton2.text = "1 – bor"

        binding.A1question4RadioButton1.text = "0 – gorizontal"
        binding.A1question4RadioButton2.text = "1 – boshi ko‘tarilgan holatda (2 ta yostiq)"
        binding.A1question4RadioButton3.text = "2 – nafas siqishidan uyg‘onadi"
        binding.A1question4RadioButton4.text = "3 – o‘tirgan holatda"

        binding.A1question5RadioButton1.text = "0 – yo‘q"
        binding.A1question5RadioButton2.text = "1 – o‘tirgan holatda"
        binding.A1question5RadioButton3.text = "2 – turgan holatda"

        binding.A1question6RadioButton1.text = "0 – yo‘q"
        binding.A1question6RadioButton2.text = "1 – pastki qismlarda (1/3 gacha)"
        binding.A1question6RadioButton3.text = "2 – kurakgacha (2/3gacha)"
        binding.A1question6RadioButton4.text = "3 – butun o‘pka yuzasida"

        binding.A1question7RadioButton1.text = "0 – yo‘q"
        binding.A1question7RadioButton2.text = "1 – bor"

        binding.A1question8RadioButton1.text = "0 – kattalashmagan"
        binding.A1question8RadioButton2.text = "1 – 5 sm gacha"
        binding.A1question8RadioButton3.text = "2 – 5 sm dan ko‘p"

        binding.A1question9RadioButton1.text = "0 – yo‘q"
        binding.A1question9RadioButton2.text = "1 – ozgina bor"
        binding.A1question9RadioButton3.text = "2 – shishlar yaqqol"
        binding.A1question9RadioButton4.text = "3 – anasarka"

        binding.A1question10RadioButton1.text = "0 – > 120"
        binding.A1question10RadioButton2.text = "1 – 100-120"
        binding.A1question10RadioButton3.text = "2 – < 100 mm s.ust"




        binding.a2RadioButton1.text = "I FS 551m dan ortiq masofa"
        binding.a2RadioButton2.text = "II FS 426-550m"
        binding.a2RadioButton3.text = "III FS 301-425m"
        binding.a2RadioButton4.text = "IV FS 300m dan kam masofa"

        /*  har bir bo'lim savol nomi B1 B2 B3 C1 C2 D bo'lim savol nomalri bo'ladi checkbox ni tepasidagi savol titlelar */
        binding.titleQuestionB1.text =
            "V1. Kichik qon aylanish doirasidagi yurak yetishmovchiligining klinik belgilari (3ta belgidan kam bo‘lmagan)"
        binding.titleQuestionB2.text =
            "V2.  Katta qon aylanish doirasidagi yurak yetishmovchiligining klinik belgilari (2ta belgidan kam bo‘lmagan)"
        binding.titleQuestionB3.text =
            "V3. Surunkali yurak yetishmovchiligining umumiy belgilari \n" +
                    "(3ta belgidan kam bo‘lmagan)"

        binding.titleQuestionC1.text =
            "C1. Buyraklar faoliyati disfunksiyasining erta belgilari\n" +
                    "(3ta belgidan kam bo‘lmagan):"
        binding.titleQuestionC2.text =
            "С2. Buyraklar faoliyati disfunksiyasining kechki belgilari\n" +
                    "(2ta belgidan kam bo‘lmagan):"

        binding.D1question.text =
            "D.  Buyraklar faoliyati disfunksiyasining og‘irlik darajasini aniqlash (Koptokchalar filtratsiyasi tezligiga ko‘ra):"


        binding.b1CheckBox1.text = "Hansirash"
        binding.b1CheckBox2.text = "Ortopnoe holati"
        binding.b1CheckBox3.text = "O‘pkadagi xirillashlar"
        binding.b1CheckBox4.text = "Taxikardiya"
        binding.b1CheckBox5.text = "Taxipnoe"
        binding.b1CheckBox6.text = "Quruq yo‘tal"

        binding.b2CheckBox1.text = "Oyoqlardagi og‘irlik hisi"
        binding.b2CheckBox2.text = "O‘ng qovurg‘a ostidagi og‘irlik"
        binding.b2CheckBox3.text = "Gepatomegaliya"
        binding.b2CheckBox4.text = "Assit"

        binding.b3CheckBox1.text = "Tez charchash"
        binding.b3CheckBox2.text = "Holsizlik "
        binding.b3CheckBox3.text = "Hotira susayishi"
        binding.b3CheckBox4.text = "Ishtahaning buzilishi"
        binding.b3CheckBox5.text = "Teri qoplamlarining rangparligi va quruqligi"
        binding.b3CheckBox6.text = "Tana vaznining kamayishi"
        binding.b3CheckBox7.text = "Ko‘ngil aynishi "
        binding.b3CheckBox8.text = "Uyquning buzilishi"

        binding.c1CheckBox1.text = "Nikturiya"
        binding.c1CheckBox2.text = "Oligouriya"
        binding.c1CheckBox3.text = "Oyoq, qo‘l va yuzdagi shishlar"
        binding.c1CheckBox4.text = "Apatiya"
        binding.c1CheckBox5.text = "Holsizlik"
        binding.c1CheckBox6.text = "Chanqoq"

        binding.c2CheckBox1.text = "Doimiy ko‘ngil aynish hisi"
        binding.c2CheckBox2.text = "Tirishishlar"
        binding.c2CheckBox3.text = "Sovuq qotish hisi"
        binding.c2CheckBox4.text = "Ta'm sezishni o‘zgarishi"
        binding.c2CheckBox5.text = "Jinsiy mayilni susayishi"

        binding.D1questionRadioButton1.text = "D1 = KFT  90 ml/daqiqa/1,73 m²  dan ortiq"
        binding.D1questionRadioButton2.text = "D2  = KFT  90-60 ml/daqiqa/1,73 m²"
        binding.D1questionRadioButton3.text = "D3 =  KFT  60 ml/daqiqa/1,73 m²   dan kam"


    }

    override fun onResume() {
        super.onResume()
        clearA1Block()
        clearA2Block()
        clearB1Block()
        clearB2Block()
        clearB3Block()
        clearC1Block()
        clearC2Block()
        clearD1Block()
    }

    private fun clearA1Block() {
       binding.A1question1RadioButton1.isChecked = false
       binding.A1question1RadioButton2.isChecked = false
       binding.A1question1RadioButton3.isChecked = false

        binding.A1question2RadioButton1.isChecked = false
        binding.A1question2RadioButton2.isChecked = false

        binding.A1question3RadioButton1.isChecked = false
        binding.A1question3RadioButton2.isChecked = false

        binding.A1question4RadioButton1.isChecked = false
        binding.A1question4RadioButton2.isChecked = false
        binding.A1question4RadioButton3.isChecked = false
        binding.A1question4RadioButton4.isChecked = false

        binding.A1question5RadioButton1.isChecked = false
        binding.A1question5RadioButton2.isChecked = false
        binding.A1question5RadioButton3.isChecked = false

        binding.A1question6RadioButton1.isChecked = false
        binding.A1question6RadioButton2.isChecked = false
        binding.A1question6RadioButton3.isChecked = false
        binding.A1question6RadioButton4.isChecked = false

        binding.A1question7RadioButton1.isChecked = false
        binding.A1question7RadioButton2.isChecked = false

        binding.A1question8RadioButton1.isChecked = false
        binding.A1question8RadioButton2.isChecked = false
        binding.A1question8RadioButton3.isChecked = false

        binding.A1question9RadioButton1.isChecked = false
        binding.A1question9RadioButton2.isChecked = false
        binding.A1question9RadioButton3.isChecked = false
        binding.A1question9RadioButton4.isChecked = false

        binding.A1question10RadioButton1.isChecked = false
        binding.A1question10RadioButton2.isChecked = false
        binding.A1question10RadioButton3.isChecked = false
    }

    private fun clearA2Block() {
        binding.a2RadioButton1.isChecked = false
        binding.a2RadioButton2.isChecked = false
        binding.a2RadioButton3.isChecked = false
        binding.a2RadioButton4.isChecked = false
    }

    private fun clearB1Block() {
        binding.b1CheckBox1.isChecked = false
        binding.b1CheckBox2.isChecked = false
        binding.b1CheckBox3.isChecked = false
        binding.b1CheckBox4.isChecked = false
        binding.b1CheckBox5.isChecked = false
        binding.b1CheckBox6.isChecked = false
    }

    private fun clearB2Block() {
        binding.b2CheckBox1.isChecked = false
        binding.b2CheckBox2.isChecked = false
        binding.b2CheckBox3.isChecked = false
        binding.b2CheckBox4.isChecked = false

    }

    private fun clearB3Block() {
        binding.b3CheckBox1.isChecked = false
        binding.b3CheckBox2.isChecked = false
        binding.b3CheckBox3.isChecked = false
        binding.b3CheckBox4.isChecked = false
        binding.b3CheckBox5.isChecked = false
        binding.b3CheckBox6.isChecked = false
        binding.b3CheckBox7.isChecked = false
        binding.b3CheckBox8.isChecked = false
    }

    private fun clearC1Block() {
        binding.c1CheckBox1.isChecked = false
        binding.c1CheckBox2.isChecked = false
        binding.c1CheckBox3.isChecked = false
        binding.c1CheckBox4.isChecked = false
        binding.c1CheckBox5.isChecked = false
        binding.c1CheckBox6.isChecked = false

    }

    private fun clearC2Block() {
        binding.c2CheckBox1.isChecked = false
        binding.c2CheckBox2.isChecked = false
        binding.c2CheckBox3.isChecked = false
        binding.c2CheckBox4.isChecked = false
        binding.c2CheckBox5.isChecked = false
    }

    private fun clearD1Block() {
        binding.D1questionRadioButton1.isChecked = false
        binding.D1questionRadioButton2.isChecked = false
        binding.D1questionRadioButton3.isChecked = false
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

