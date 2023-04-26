package product.truckkz.windows.home.showImage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.R
import product.truckkz.databinding.ItemShowImageBinding
import product.truckkz.models.products.productInfo.Images

class ShowImageAdapterAdvert(private var images: List<Images>) :
    RecyclerView.Adapter<ShowImageAdapterAdvert.MyViewHolder>() {
    lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemShowImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(context).load(images[position].imageUrl)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .fitCenter().into(holder.binding.imageShow)

    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class MyViewHolder(val binding: ItemShowImageBinding) : RecyclerView.ViewHolder(binding.root)

}