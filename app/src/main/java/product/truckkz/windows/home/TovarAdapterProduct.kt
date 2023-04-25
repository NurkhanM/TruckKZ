package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.util.ToastUtil.context
import product.truckkz.R
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.models.products.index.Data

class TovarAdapterProduct(private val mIClickListnear: IClickListnearHomeFavorite) :
    PagingDataAdapter<Data,
            TovarAdapterProduct.MyViewHolder>(diffCallback) {


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTovarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }


    @SuppressLint("NewApi", "SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        Glide.with(context).load(currentItem?.img)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
//            .fitCenter()
            .into(holder.binding.itemHomeImages)



//        if (currentItem.favorite) {
//            holder.itemView.img_favorite?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_favorite2))
//        } else{
//            holder.itemView.img_favorite?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_favorite))
//        }


        holder.binding.textName.text = currentItem?.title
        holder.binding.textPrice.text = currentItem?.price + " $"

        holder.binding.rowCostom.setOnClickListener {
            currentItem?.id?.let { it1 -> mIClickListnear.clickListener(it1) }
        }
//        holder.itemView.item_favorite.setOnClickListener {
//            mIClickListnear.clickListenerFavorite(currentItem.id, holder.itemView, currentItem.favorite, position)
//            currentItem.favorite = !currentItem.favorite
//            notifyItemChanged(position)
//        }
    }


    inner class MyViewHolder(val binding: ItemTovarBinding) : RecyclerView.ViewHolder(binding.root)



}
