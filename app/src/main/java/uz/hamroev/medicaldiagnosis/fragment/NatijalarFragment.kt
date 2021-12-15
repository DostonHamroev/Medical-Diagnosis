package uz.hamroev.medicaldiagnosis.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.hamroev.medicaldiagnosis.R
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
    private  val TAG = "NatijalarFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNatijalarBinding.inflate(layoutInflater, container, false)

        resultDatabase = ResultDatabase.getInstance(binding.root.context)
        list = resultDatabase.resultDao().getAllResults() as ArrayList
        for (entity in list) {
            Log.d(TAG, "onCreateView: ${entity.date}")
        }


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