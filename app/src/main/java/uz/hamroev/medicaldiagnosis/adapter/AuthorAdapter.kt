package uz.hamroev.medicaldiagnosis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.medicaldiagnosis.databinding.ItemAuthorBinding
import uz.hamroev.medicaldiagnosis.model.Author

class AuthorAdapter(var context: Context, var list: ArrayList<Author>) :
    RecyclerView.Adapter<AuthorAdapter.VhAuthor>() {

    inner class VhAuthor(var itemAuthorBinding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(itemAuthorBinding.root) {


        fun onBind(author: Author) {
            itemAuthorBinding.authorName.text = author.author_name
            itemAuthorBinding.authorProf.text = author.author_prof
            author.author_image?.let { itemAuthorBinding.authorImage.setImageResource(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhAuthor {
        return VhAuthor(
            ItemAuthorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhAuthor, position: Int) {
        return holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}