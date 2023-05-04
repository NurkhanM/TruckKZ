package product.truckkz.windows.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.util.ToastUtil
import product.truckkz.R
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.databinding.ItemTovarOrdinaryBinding
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.models.products.index.Data
import kotlin.collections.ArrayList

class ProductAdapter(private val mIClickListnear: IClickListnearHomeFavorite) :

    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<Data>()

    @SuppressLint("NotifyDataSetChanged")
    fun deleteMyEducations(position: Int) {
        listTovar.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, listTovar.size)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTovarOrdinaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listTovar[position]

        Glide.with(context).load(currentItem.img)
            .thumbnail(Glide.with(ToastUtil.context).load(R.drawable.loader2))
            .into(holder.binding.itemHomeImages)

        if (currentItem.isLike) {
            holder.binding.imgFavorite.setImageResource(R.drawable.ic_favorite2)
        } else {
            holder.binding.imgFavorite.setImageResource(R.drawable.ic_favorite)
        }

        holder.binding.textName.text = currentItem.title
        holder.binding.textPrice.text = currentItem.price + " $"

        holder.binding.rowCostom.setOnClickListener {
            currentItem.id.let { it1 -> mIClickListnear.clickListener(it1) }
        }

        holder.binding.itemFavorite.setOnClickListener {
            mIClickListnear.clickListenerFavorite(
                currentItem.id, holder.binding, currentItem.isLike, position
            )

            currentItem.isLike = !currentItem.isLike
            notifyItemChanged(position)

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

    inner class MyViewHolder(val binding: ItemTovarOrdinaryBinding) : RecyclerView.ViewHolder(binding.root)



}
