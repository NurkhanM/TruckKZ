package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.R
import product.truckkz.databinding.ItemCategoryBinding
import product.truckkz.`interface`.IClickListnearHomeTest
import product.truckkz.models.category.Children
import kotlin.collections.ArrayList

class TovarAdapterCategory(private val mIClickListnear: IClickListnearHomeTest) :

    RecyclerView.Adapter<TovarAdapterCategory.MyViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<Children>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }
    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listTovar[position]


        Glide.with(context).load(R.drawable.test_svg_category2)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .fitCenter()
            .into(holder.binding.itemHomeImages)

        holder.binding.textName.text = currentItem.name


        holder.binding.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(currentItem.id)
        }
    }

    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Children>) {
        listTovar = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)



}
