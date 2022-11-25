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
import kotlinx.android.synthetic.main.item_tovar.view.*
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.models.products.index.Data
import java.text.SimpleDateFormat
import java.util.*

class TovarAdapterProduct(private val mIClickListnear: IClickListnearHomeFavorite) :
    PagingDataAdapter<Data,
            TovarAdapterProduct.ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(
        binding: ItemTovarBinding,
    ) :
        RecyclerView.ViewHolder(binding.root)

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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemTovarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    @SuppressLint("NewApi", "SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = getItem(position)

        Glide.with(context).load(currentItem?.img)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
//            .fitCenter()
            .into(holder.itemView.item_home_images)



//        if (currentItem.favorite) {
//            holder.itemView.img_favorite?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_favorite2))
//        } else{
//            holder.itemView.img_favorite?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_favorite))
//        }


        holder.itemView.text_name.text = currentItem?.title
        holder.itemView.text_price.text = currentItem?.price + " $"

        holder.itemView.rowCostom.setOnClickListener {
            currentItem?.id?.let { it1 -> mIClickListnear.clickListener(it1) }
        }
//        holder.itemView.item_favorite.setOnClickListener {
//            mIClickListnear.clickListenerFavorite(currentItem.id, holder.itemView, currentItem.favorite, position)
//            currentItem.favorite = !currentItem.favorite
//            notifyItemChanged(position)
//        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDateTime(s: String): Boolean {
        //Сегодняшняя дата
        val currentTime: Date = Calendar.getInstance().time
        //Преобразование приходяшее дата
        val dateParse = SimpleDateFormat("dd.MM.yyyy HH:mm").parse(s) as Date

        return dateParse.time >= currentTime.time
    }

}
