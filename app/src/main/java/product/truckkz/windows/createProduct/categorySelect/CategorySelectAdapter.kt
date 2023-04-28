package product.truckkz.windows.createProduct.categorySelect

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import product.truckkz.databinding.CastomSelectCategoryBinding
import product.truckkz.`interface`.IClickListnearShops
import product.truckkz.models.category.Children

class CategorySelectAdapter(private val onClickListener: IClickListnearShops) :
    RecyclerView.Adapter<CategorySelectAdapter.MyViewHolder>() {


    private lateinit var context: Context

    private var userList = emptyList<Children>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CastomSelectCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(user: List<Children>) {
        this.userList = user
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.binding.txtSelectCa.text = currentItem.name

        if (currentItem.children?.isNotEmpty() == true) {
            holder.binding.rowCostomCaSelect.setOnClickListener {
                currentItem.id.let { it1 -> currentItem.name?.let { it2 ->
                    onClickListener.clickListener(it1,
                        it2, true)
                } }

            }
        } else {
            holder.binding.rowCostomCaSelect.setOnClickListener {
                currentItem.id.let { it1 -> currentItem.name?.let { it2 ->
                    onClickListener.clickListener(it1,
                        it2, false)
                } }

            }
        }


    }

    inner class MyViewHolder(val binding: CastomSelectCategoryBinding) : RecyclerView.ViewHolder(binding.root)

}