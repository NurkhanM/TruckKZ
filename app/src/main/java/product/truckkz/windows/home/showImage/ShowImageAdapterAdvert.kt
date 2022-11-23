package product.truckkz.windows.home.showImage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.R
import product.truckkz.models.get.productInfo.Images
import kotlinx.android.synthetic.main.item_show_image.view.*

class ShowImageAdapterAdvert(private var images: List<Images>) :
    RecyclerView.Adapter<ShowImageAdapterAdvert.AdvertViewHolder>() {
    lateinit var context: Context

    inner class AdvertViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "You clicked on Item #${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AdvertViewHolder {


        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_show_image, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        context = parent.context
        return AdvertViewHolder(view)

    }

    override fun onBindViewHolder(holder: AdvertViewHolder, position: Int) {

        Glide.with(context).load(images[position].imageUrl)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .fitCenter().into(holder.itemView.image_show)

    }

    override fun getItemCount(): Int {
        return images.size
    }
}