package product.truckkz.windows.newCreateProduct

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import product.truckkz.R
import product.truckkz.`interface`.IClickListnearHomeCategory
import kotlinx.android.synthetic.main.item_selected_category.view.*
import product.truckkz.models.category.Children
import kotlin.collections.ArrayList

class SelectedAdapterCategory(private val mIClickListnear: IClickListnearHomeCategory) :

    RecyclerView.Adapter<SelectedAdapterCategory.TovarViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<Children>()

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
            LayoutInflater.from(parent.context).inflate(R.layout.item_selected_category, parent, false)
        context = parent.context
        return TovarViewHolder(view)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: TovarViewHolder, position: Int) {
        val currentItem = listTovar[position]

        holder.itemView.text_name.text = currentItem.name

//        holder.itemView.rowCostom.setOnClickListener {
//            mIClickListnear.clickListener(currentItem.categoryId, currentItem.name)
//        }
    }

    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Children>) {
        listTovar = list
        notifyDataSetChanged()
    }

}
