package uz.hamroev.medicaldiagnosis.fragment

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import uz.hamroev.medicaldiagnosis.R
import uz.hamroev.medicaldiagnosis.adapter.ResultsAdapter
import uz.hamroev.medicaldiagnosis.databinding.FragmentNatijalarBinding
import uz.hamroev.medicaldiagnosis.room.database.ResultDatabase
import uz.hamroev.medicaldiagnosis.room.entity.ResultEntity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NatijalarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NatijalarFragment : Fragment() {
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

    lateinit var binding: FragmentNatijalarBinding
    lateinit var resultDatabase: ResultDatabase
    lateinit var list: ArrayList<ResultEntity>
    lateinit var resultsAdapter: ResultsAdapter
    var message: String = ""
    var shareMessage: String =
        "https://play.google.com/store/apps/details?id="

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNatijalarBinding.inflate(layoutInflater, container, false)

        shareMessage = "https://play.google.com/store/apps/details?id=" + activity?.packageName
        resultDatabase = ResultDatabase.getInstance(binding.root.context)
        list = resultDatabase.resultDao().getAllResults().reversed() as ArrayList

//        for (entity in list) {
//            Log.d(TAG, "onCreateView: ${entity.date}")
//        }

        resultsAdapter =
            ResultsAdapter(binding.root.context, list, object : ResultsAdapter.OnMyClickListener {
                override fun onShare(resultEntity: ResultEntity, position: Int) {
                    val name = "Medical - Diagnosis"
                    message = "$name\n\n" +
                            "* * * * * * *\n" +
                            "Диагностический номер: ${list[position].id}\n" +
                            "Вариант: ${list[position].variant}\n" +
                            "Диагноз: ${list[position].diagnos}\n" +
                            "Время: ${list[position].date}" +
                            "\n" +
                            "\n* * * * * * *\n" +
                            "$shareMessage"

                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    val chooser = Intent.createChooser(intent, "Share using...")
                    startActivity(chooser)

                }

                override fun onInfoResult(resultEntity: ResultEntity, position: Int) {
                    val alertDialog = AlertDialog.Builder(binding.root.context)
                    val dialog = alertDialog.create()
                    val dialogView =
                        layoutInflater.inflate(R.layout.dialog_info_result, null, false)
                    dialog.setView(dialogView)
                    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    dialog.setCancelable(true)

                    val diagnos_variant_dialog =
                        dialogView.findViewById<TextView>(R.id.diagnos_variant_dialog)
                    val diagnos_result_dialog =
                        dialogView.findViewById<TextView>(R.id.diagnos_result_dialog)
                    val diagnos_result_table1_dialog =
                        dialogView.findViewById<TextView>(R.id.diagnos_result_table1_dialog)
                    val diagnos_result_table2_dialog =
                        dialogView.findViewById<TextView>(R.id.diagnos_result_table2_dialog)
                    val diagnos_result_table3_dialog =
                        dialogView.findViewById<TextView>(R.id.diagnos_result_table3_dialog)
                    val diagnos_date_dialog =
                        dialogView.findViewById<TextView>(R.id.diagnos_date_dialog)

                    diagnos_date_dialog.text = list[position].date

                    diagnos_variant_dialog.text = list[position].variant
                    diagnos_result_dialog.text = list[position].diagnos

                    diagnos_result_table1_dialog.text = list[position].diagnos1
                    diagnos_result_table2_dialog.text = list[position].diagnos2
                    diagnos_result_table3_dialog.text = list[position].diagnos3

                    dialog.show()
                }

                private fun send() {
                    var name = "Medical - Diagnosis"
//                    var ss = SpannableString(name)
//                    var boldSpan = StyleSpan(Typeface.BOLD)
//                    var appNameBold = ss.setSpan(boldSpan, 0, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


                }
            })

        binding.rvResults.adapter = resultsAdapter



        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NatijalarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NatijalarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}