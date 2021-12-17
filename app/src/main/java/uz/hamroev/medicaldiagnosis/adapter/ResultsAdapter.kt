package uz.hamroev.medicaldiagnosis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.medicaldiagnosis.R
import uz.hamroev.medicaldiagnosis.databinding.ItemResultsBinding
import uz.hamroev.medicaldiagnosis.room.entity.ResultEntity

class ResultsAdapter(
    var context: Context,
    var list: List<ResultEntity>,
    var onMyClickListener: OnMyClickListener
) :
    RecyclerView.Adapter<ResultsAdapter.VhResult>() {

    inner class VhResult(var itemResultsBinding: ItemResultsBinding) :
        RecyclerView.ViewHolder(itemResultsBinding.root) {

        fun onBind(resultEntity: ResultEntity, position: Int) {

            val anim = AnimationUtils.loadAnimation(context, R.anim.anim_natijalar)
            itemResultsBinding.numberId.text = resultEntity.id.toString()
            itemResultsBinding.variant.text = resultEntity.variant
            itemResultsBinding.diagnos.text = resultEntity.diagnos
            itemResultsBinding.date.text = resultEntity.date
            itemResultsBinding.fio.text = resultEntity.fio

            itemResultsBinding.share.setOnClickListener {
                onMyClickListener.onShare(resultEntity, position)
            }
            itemResultsBinding.root.setOnClickListener {
                onMyClickListener.onInfoResult(resultEntity, position)

            }
            if (position % 2 == 0) {
                itemResultsBinding.root.startAnimation(anim)
            } else {
                itemResultsBinding.root.startAnimation(anim)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhResult {
        return VhResult(
            ItemResultsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhResult, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnMyClickListener {
        fun onShare(resultEntity: ResultEntity, position: Int)

        fun onInfoResult(resultEntity: ResultEntity, position: Int)
    }
}