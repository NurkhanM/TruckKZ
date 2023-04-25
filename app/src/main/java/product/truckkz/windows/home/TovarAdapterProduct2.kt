package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.util.ToastUtil
import product.truckkz.R
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.models.products.index.Data
import java.text.SimpleDateFormat
import java.util.*

class TovarAdapterProduct2(private val mIClickListnear: IClickListnearHomeFavorite) :

    RecyclerView.Adapter<TovarAdapterProduct2.MyViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<Data>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTovarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    @SuppressLint("NewApi", "SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listTovar[position]

        Glide.with(context).load(currentItem.img)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
//            .fitCenter()
            .into(holder.binding.itemHomeImages)

//        if (currentItem.favorite) {
//            holder.itemView.img_favorite?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_favorite2))
//        } else{
//            holder.itemView.img_favorite?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_favorite))
//        }


        holder.binding.textName.text = currentItem.title
        holder.binding.textPrice.text = currentItem.price + " $"

        holder.binding.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(currentItem.id)
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
