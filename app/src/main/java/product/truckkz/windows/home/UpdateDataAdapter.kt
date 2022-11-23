package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.R
import product.truckkz.`interface`.IClickListnearUpdateImage
import product.truckkz.models.get.productInfo.Images
import kotlinx.android.synthetic.main.item_update_image_array.view.*

class UpdateDataAdapter(private val mIClickListnear: IClickListnearUpdateImage) :
    RecyclerView.Adapter<UpdateDataAdapter.UpdateDataAdapterHolder>() {
    lateinit var context: Context
    private var focusedPosition = -1

    private var listImage = emptyList<Images>()

    class UpdateDataAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdateDataAdapterHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_update_image_array, parent, false)
        context = parent.context
        return UpdateDataAdapterHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(
        holder: UpdateDataAdapterHolder,
        @SuppressLint("RecyclerView") position: Int,
    ) {
        val currentItemImages = listImage[position]

        Glide.with(context).load(currentItemImages.imageUrl)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .fitCenter().into(holder.itemView.image_array_update)

        holder.itemView.image_array_update.setOnClickListener {
            mIClickListnear.clickListener(currentItemImages.imageUrl, position)
            holder.itemView.item_image_focus.visibility = View.VISIBLE
            if (focusedPosition != position) {
                notifyItemChanged(position)
                focusedPosition = position
                notifyDataSetChanged()
            }
        }

        if (focusedPosition == -1) {
            holder.itemView.item_image_focus.visibility = View.GONE
        } else {
            if (focusedPosition == position) {
                holder.itemView.item_image_focus.visibility = View.VISIBLE
            } else {
                holder.itemView.item_image_focus.visibility = View.GONE
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
}