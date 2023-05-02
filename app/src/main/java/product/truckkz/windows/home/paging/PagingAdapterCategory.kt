package product.truckkz.windows.home.paging

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.util.ToastUtil.context
import product.truckkz.R
import product.truckkz.databinding.ItemCategoryBinding
import product.truckkz.`interface`.IClickListnearHomeTest
import product.truckkz.models.category.Children

class PagingAdapterCategory(private val mIClickListnear: IClickListnearHomeTest) :
    PagingDataAdapter<Children, PagingAdapterCategory.MyViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Children>() {
            override fun areItemsTheSame(oldItem: Children, newItem: Children): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Children, newItem: Children): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (position == selectedPosition) {
            holder.binding.rowCostom.setBackgroundResource(R.drawable.button_background2)
        } else {
            holder.binding.rowCostom.setBackgroundResource(0)
        }

        Glide.with(context).load(R.drawable.test_svg_category2)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .fitCenter()
            .into(holder.binding.itemHomeImages)

        holder.binding.textName.text = currentItem!!.name

        // Изменяем цвет фона, если текущий элемент соответствует выбранному индексу
        holder.binding.rowCostom.setBackgroundResource(
            if (position == selectedPosition) {
                R.drawable.button_background2
            } else {
                R.drawable.fon_white
            }
        )


        holder.binding.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(currentItem.id)
            selectItem(position) // Вызываем метод для обновления выбранного индекса
        }
    }

    inner class MyViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var selectedPosition = 0

    @SuppressLint("NotifyDataSetChanged")
    fun selectItem(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

}
