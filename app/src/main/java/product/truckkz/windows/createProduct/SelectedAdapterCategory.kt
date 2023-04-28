package product.truckkz.windows.createProduct

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import product.truckkz.databinding.ItemSelectedCategoryBinding
import product.truckkz.`interface`.IClickListnearHomeCategory
import product.truckkz.models.category.Children
import kotlin.collections.ArrayList

class SelectedAdapterCategory(private val mIClickListnear: IClickListnearHomeCategory) :

    RecyclerView.Adapter<SelectedAdapterCategory.MyViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<Children>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemSelectedCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listTovar[position]

        holder.binding.textName.text = currentItem.name

//        holder.itemView.rowCostom.setOnClickListener {
//            mIClickListnear.clickListener(currentItem.categoryId, currentItem.name)
//        }

    }

    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Children>) {
        listTovar = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemSelectedCategoryBinding) : RecyclerView.ViewHolder(binding.root)


}
