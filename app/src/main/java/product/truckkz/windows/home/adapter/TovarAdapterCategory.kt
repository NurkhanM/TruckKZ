package product.truckkz.windows.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.R
import product.truckkz.databinding.ItemCategoryBinding
import product.truckkz.`interface`.IClickListnearHomeTest
import product.truckkz.models.category.Children
import kotlin.collections.ArrayList

class TovarAdapterCategory(private val mIClickListnear: IClickListnearHomeTest) :

    RecyclerView.Adapter<TovarAdapterCategory.MyViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<Children>()

    // Переменная, хранящая индекс элемента для закрашивания
    var selectedPosition = 0

    // Метод для обновления индекса выбранного элемента
    @SuppressLint("NotifyDataSetChanged")
    fun selectItem(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listTovar[position]

        if (position == selectedPosition) {
            holder.binding.rowCostom.setBackgroundResource(R.drawable.button_background2)
        } else {
            holder.binding.rowCostom.setBackgroundResource(0)
        }

        Glide.with(context).load(R.drawable.test_svg_category2)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .fitCenter()
            .into(holder.binding.itemHomeImages)

        holder.binding.textName.text = currentItem.name

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


    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Children>) {
        val newItem = Children(
            children = emptyList(),
            created_at = "",
            description = "",
            id = 0,
            img = "",
            name = "Все категории",
            parent_id = -1,
            slug = ""
        )
        listTovar.add(0, newItem)

        // Добавляем элементы из переданного списка
        listTovar.addAll(list)

        // Уведомляем адаптер об изменениях в списке
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)



}
