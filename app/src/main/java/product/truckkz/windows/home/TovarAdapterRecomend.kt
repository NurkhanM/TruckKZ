package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.R
import product.truckkz.`interface`.IClickListnearHomeTest
import product.truckkz.models.TestRecomendModel
import kotlinx.android.synthetic.main.item_recomend.view.*
import kotlin.collections.ArrayList

class TovarAdapterRecomend(private val mIClickListnear: IClickListnearHomeTest) :

    RecyclerView.Adapter<TovarAdapterRecomend.TovarViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<TestRecomendModel>()

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
            LayoutInflater.from(parent.context).inflate(R.layout.item_recomend, parent, false)
        context = parent.context
        return TovarViewHolder(view)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: TovarViewHolder, position: Int) {
        val currentItem = listTovar[position]


        Glide.with(context).load(currentItem.img)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .fitCenter()
            .into(holder.itemView.item_home_images)

        holder.itemView.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<TestRecomendModel>) {
        listTovar = list
        notifyDataSetChanged()
    }

}
