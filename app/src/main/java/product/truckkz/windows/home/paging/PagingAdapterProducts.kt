package product.truckkz.windows.home.paging

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.util.ToastUtil.context
import product.truckkz.R
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.models.products.index.Data


class PagingAdapterProducts(private val mIClickListnear: IClickListnearHomeFavorite) :
    PagingDataAdapter<Data, PagingAdapterProducts.MyViewHolder>(diffCallback) {

    private var isLoading = false

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

        if (isLoading) {
            //Показать прогресс-бар
            holder.binding.progressBar.visibility = View.VISIBLE
            holder.binding.itemHomeImages.visibility = View.GONE
            holder.binding.textName.visibility = View.GONE
            holder.binding.textPrice.visibility = View.GONE
            holder.binding.itemFavorite.visibility = View.GONE
            holder.binding.rowCostom.setOnClickListener(null)
            return
        } else {
            holder.binding.progressBar.visibility = View.GONE
            holder.binding.itemHomeImages.visibility = View.VISIBLE
            holder.binding.textName.visibility = View.VISIBLE
            holder.binding.textPrice.visibility = View.VISIBLE
            holder.binding.itemFavorite.visibility = View.VISIBLE
        }


        Glide.with(context).load(currentItem!!.img)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
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


    inner class MyViewHolder(val binding: ItemTovarBinding) : RecyclerView.ViewHolder(binding.root)


    @SuppressLint("NotifyDataSetChanged")
    fun showLoading() {
        isLoading = true
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun hideLoading() {
        isLoading = false
        notifyDataSetChanged()
    }

}