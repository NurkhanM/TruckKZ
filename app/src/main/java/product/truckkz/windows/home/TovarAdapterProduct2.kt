package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.R
import product.truckkz.`interface`.IClickListnearHomeFavorite
import kotlinx.android.synthetic.main.item_tovar.view.*
import product.truckkz.models.products.index.Data
import java.text.SimpleDateFormat
import java.util.*

class TovarAdapterProduct2(private val mIClickListnear: IClickListnearHomeFavorite) :

    RecyclerView.Adapter<TovarAdapterProduct2.TovarViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<Data>()

    class TovarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    @SuppressLint("NotifyDataSetChanged")
    fun deleteMyEducations(position: Int) {
        listTovar.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, listTovar.size)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TovarViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tovar, parent, false)
        context = parent.context
        return TovarViewHolder(view)
    }

    @SuppressLint("NewApi", "SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: TovarViewHolder, position: Int) {
        val currentItem = listTovar[position]

        Glide.with(context).load(currentItem.img)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
//            .fitCenter()
            .into(holder.itemView.item_home_images)



//        if (currentItem.favorite) {
//            holder.itemView.img_favorite?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_favorite2))
//        } else{
//            holder.itemView.img_favorite?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_favorite))
//        }


        holder.itemView.text_name.text = currentItem.title
        holder.itemView.text_price.text = currentItem.price + " $"

        holder.itemView.rowCostom.setOnClickListener {
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


}
