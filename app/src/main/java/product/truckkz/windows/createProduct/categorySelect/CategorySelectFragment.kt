package product.truckkz.windows.createProduct.categorySelect

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import product.truckkz.R
import product.truckkz.UserDate.GET_CATEGORY_ID
import product.truckkz.databinding.FragmentCategorySelectBinding
import product.truckkz.`interface`.IClickListnearShops
import product.truckkz.models.category.Children
import product.truckkz.viewModels.HomeViewModels

class CategorySelectFragment : BottomSheetDialogFragment() {


    private var _binding: FragmentCategorySelectBinding? = null
    private val binding get() = _binding!!


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CategorySelectAdapter

    val intent = Intent()

    private lateinit var mHomeViewModel: HomeViewModels

    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentCategorySelectBinding.inflate(inflater, container, false)
        val view = binding

        GET_CATEGORY_ID = -1

        // Определите радиус скругления краев
        val radius = resources.getDimension(R.dimen.corner_radius)

        // Создайте объект ShapeAppearanceModel с радиусом скругления
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(CornerFamily.ROUNDED, radius)
            .build()

        // Получите ссылку на корневую View и установите для нее фон с использованием ShapeAppearanceModel
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.background = MaterialShapeDrawable(shapeAppearanceModel)
            .apply {
                setTint(ContextCompat.getColor(requireContext(), R.color.white))
            }

        val adapter = CategorySelectAdapter(object : IClickListnearShops {
            @SuppressLint("InflateParams", "SyntheticAccessor")
            override fun clickListener(int: Int, name: String, boolean: Boolean) {
                    GET_CATEGORY_ID = int
                    intent.putExtra("result", name)
                    targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
                    dismiss()
            }
        })

        recyclerView = view.rvCategorySelect
        recyclerView.adapter = adapter


        mHomeViewModel.getCategory()




        mHomeViewModel.myCategory.observe(viewLifecycleOwner) { user ->

            view.progressNewCreatePro.visibility = View.GONE

            val childrenList = ArrayList<Children>()

            user.body()?.data?.let { categoryModels ->

                categoryModels.forEach { data ->
                    data.children.let { childrenList.addAll(it) }
                }

                adapter.setData(childrenList)
            }


            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }


                @SuppressLint("NotifyDataSetChanged")
                override fun onQueryTextChange(newText: String?): Boolean {
                    // Фильтруем список и передаем отфильтрованные данные в адаптер
                    val filteredList = childrenList.filter { it.name.contains(newText.orEmpty(), ignoreCase = true) }
                    adapter.setData(filteredList)

                    // Обновляем адаптер, чтобы он показал только отфильтрованные элементы
                    adapter.notifyDataSetChanged()

                    return true
                }
            })



        }


        view.textHeader.setOnClickListener {
                dismiss()
        }
        binding.cancel.setOnClickListener { dismiss() }

        return view.root
    }


    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog, null)
        dialog.setContentView(view)
        dialog.behavior.isHideable = true
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        return dialog
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}