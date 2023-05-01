package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import product.truckkz.DataAllProducts.ALL_ID_PRODUCTS
import product.truckkz.R
import product.truckkz.UserDate.USER_TOKEN
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.`interface`.IClickListnearHomeTest
import product.truckkz.viewModels.HomeViewModels
import me.farahani.spaceitemdecoration.SpaceItemDecoration
import product.truckkz.MainActivity
import product.truckkz.MyUtils.uToast
import product.truckkz.databinding.ActivityMainBinding
import product.truckkz.databinding.FragmentHomeBinding
import product.truckkz.databinding.ItemTovarBinding
import java.util.HashMap

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var activityBinding: ActivityMainBinding? = null


    private lateinit var recyclerViewCategory: RecyclerView
    lateinit var recyclerViewProduct: RecyclerView
    private lateinit var adapterCategory: TovarAdapterCategory
    private lateinit var adapterProduct: ProductsCategoryAdapterCategory
    private val map = HashMap<String, String>()
    private lateinit var viewModel: HomeViewModels

    @SuppressLint("UseCompatLoadingForDrawables", "NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding

        recyclerViewCategory = view.rvCategory
        adapterCategory = TovarAdapterCategory(object : IClickListnearHomeTest {
            override fun clickListener(baseID: Int) {
                map.clear()
                if (baseID != 0){
                    map["category"] = baseID.toString()
                }else{
                    map["category"] = ""
                }
                rfCategory()
                adapterProduct.notifyDataSetChanged()
                recyclerViewProduct.removeAllViewsInLayout()
            }
        })
        recyclerViewCategory.adapter = adapterCategory
        recyclerViewCategory.setHasFixedSize(true)


        view.tiRefreshLayout.setOnRefreshListener {
            rfCategory()
            recyclerViewCategory.removeAllViewsInLayout()
            recyclerViewProduct.removeAllViewsInLayout()

            adapterProduct.notifyDataSetChanged()
            adapterCategory.notifyDataSetChanged()
            view.tiRefreshLayout.isRefreshing = false
        }



        recyclerViewProduct = view.rvProduct
        recyclerViewProduct.addItemDecoration(SpaceItemDecoration(30, false))
        adapterProduct = ProductsCategoryAdapterCategory(
            object : IClickListnearHomeFavorite {
                override fun clickListener(baseID: Int) {
                    ALL_ID_PRODUCTS = baseID
                    Navigation.findNavController(view.root)
                        .navigate(R.id.action_homeFragment_to_homeInfoFragment)
                }

                override fun clickListenerFavorite(
                    baseID: Int,
                    v: ItemTovarBinding,
                    boolean: Boolean,
                    pos: Int
                ) {

                }
            })

        recyclerViewProduct.adapter = adapterProduct
        recyclerViewProduct.setHasFixedSize(true)
        rfProduct()





        viewModel.getCategory()
        viewModel.myCategory.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                list.body()?.data!![0].children.let { adapterCategory.setList(it) }
            }
        }

        return view.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем ссылку на ViewBinding активити
        activityBinding = (requireActivity() as? MainActivity)?.binding
        // Используем ссылку на ViewBinding активити, чтобы получить доступ к View
        activityBinding?.bottomAppBar?.visibility = View.VISIBLE
        activityBinding?.floatBottom?.visibility = View.VISIBLE


    }


    @SuppressLint("NotifyDataSetChanged")
    private fun rfProduct() {
        map["category"] = ""
        viewModel.getProductsCategory("Bearer $USER_TOKEN", map)
        viewModel.myProductsCategory.observe(viewLifecycleOwner) { list ->

            if (list.isSuccessful){
                list.body()?.data?.let { adapterProduct.setList(it) }
            }else {
                uToast(requireContext(), "NULL")
            }
        }
    }

    private fun rfCategory() {
        viewModel.getProductsCategory("Bearer $USER_TOKEN", map)
        viewModel.myProductsCategory.observe(viewLifecycleOwner) { list ->

            if (list.isSuccessful){
                list.body()?.data?.let { adapterProduct.setList(it) }
            }else {
                uToast(requireContext(), "NULL")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activityBinding = null
    }


}