package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.util.ToastUtil
import product.truckkz.R
import product.truckkz.databinding.ItemUpdateImageArrayBinding
import product.truckkz.`interface`.IClickListnearUpdateImage
import product.truckkz.models.get.productInfo.Images

class UpdateDataAdapter(private val mIClickListnear: IClickListnearUpdateImage) :
    RecyclerView.Adapter<UpdateDataAdapter.MyViewHolder>() {
    lateinit var context: Context
    private var focusedPosition = -1

    private var listImage = emptyList<Images>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUpdateImageArrayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int,
    ) {
        val currentItemImages = listImage[position]

        Glide.with(context).load(currentItemImages.imageUrl)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .fitCenter().into(holder.binding.imageArrayUpdate)

        holder.binding.imageArrayUpdate.setOnClickListener {
            mIClickListnear.clickListener(currentItemImages.imageUrl, position)
            holder.binding.itemImageFocus.visibility = View.VISIBLE
            if (focusedPosition != position) {
                notifyItemChanged(position)
                focusedPosition = position
                notifyDataSetChanged()
            }
        }

        if (focusedPosition == -1) {
            holder.binding.itemImageFocus.visibility = View.GONE
        } else {
            if (focusedPosition == position) {
                holder.binding.itemImageFocus.visibility = View.VISIBLE
            } else {
                holder.binding.itemImageFocus.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListImage(list: List<Images>) {
        listImage = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemUpdateImageArrayBinding) : RecyclerView.ViewHolder(binding.root)

}