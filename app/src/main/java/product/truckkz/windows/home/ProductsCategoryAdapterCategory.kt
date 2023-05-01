package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.util.ToastUtil
import product.truckkz.R
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.models.products.index.Data
import kotlin.collections.ArrayList

class ProductsCategoryAdapterCategory(private val mIClickListnear: IClickListnearHomeFavorite) :

    RecyclerView.Adapter<ProductsCategoryAdapterCategory.MyViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTovarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listTovar[position]

        Glide.with(ToastUtil.context).load(currentItem.img)
            .thumbnail(Glide.with(ToastUtil.context).load(R.drawable.loader2))
            .into(holder.binding.itemHomeImages)

        holder.binding.textName.text = currentItem.title
        holder.binding.textPrice.text = currentItem.price + " $"

        holder.binding.rowCostom.setOnClickListener {
            currentItem.id.let { it1 -> mIClickListnear.clickListener(it1) }
        }
    }


    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Data>) {
        listTovar = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemTovarBinding) : RecyclerView.ViewHolder(binding.root)



}
