package product.truckkz.windows.createProduct

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import product.truckkz.MyUtils
import product.truckkz.databinding.ItemImageBinding
import product.truckkz.`interface`.IClickListnearUpdateImage

class ProductCreateAdapter(private val mIClickListnearUpdateImage: IClickListnearUpdateImage) :
    RecyclerView.Adapter<ProductCreateAdapter.ProductCreateViewHolder>() {

    lateinit var context: Context

    private var listHome = ArrayList<Uri>()

    @SuppressLint("NotifyDataSetChanged")
    fun deleteMyEducations(position: Int) {
        listHome.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCreateViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ProductCreateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductCreateViewHolder, position: Int) {

        val currentItem = listHome[position]
        MyUtils.uGlide(context, holder.binding.ivMedia, currentItem)
        holder.binding.ivImageDelete.setOnClickListener {
            mIClickListnearUpdateImage.clickListener("n", position)
        }
    }

    override fun getItemCount(): Int {
        return listHome.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Uri>) {
        listHome = list
        notifyDataSetChanged()
    }

    inner class ProductCreateViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)
}
