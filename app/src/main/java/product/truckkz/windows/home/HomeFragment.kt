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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import product.truckkz.DataAllProducts.ALL_ID_PRODUCTS
import product.truckkz.R
import product.truckkz.UserDate.USER_TOKEN
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.`interface`.IClickListnearHomeTest
import product.truckkz.viewModels.HomeViewModels
import me.farahani.spaceitemdecoration.SpaceItemDecoration
import product.truckkz.MainActivity
import product.truckkz.MyUtils.uLogD
import product.truckkz.databinding.ActivityMainBinding
import product.truckkz.databinding.FragmentHomeBinding
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.models.category.Children
import product.truckkz.windows.home.adapter.TovarAdapterCategory
import product.truckkz.windows.home.paging.PagingAdapterCategory
import product.truckkz.windows.home.paging.PagingAdapterProducts
import java.util.HashMap

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var activityBinding: ActivityMainBinding? = null


    private lateinit var recyclerViewCategory: RecyclerView
    lateinit var recyclerViewProduct: RecyclerView
//    private lateinit var adapterCategory: TovarAdapterCategory
    private lateinit var adapterCategory: PagingAdapterCategory
//    private lateinit var adapterProduct: ProductAdapter
    private lateinit var adapterProduct: PagingAdapterProducts



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
        adapterCategory = PagingAdapterCategory(object : IClickListnearHomeTest {
            override fun clickListener(baseID: Int) {
                map.clear()
                if (baseID != 0) {
                    map["category"] = baseID.toString()
                } else {
                    map["category"] = ""
                }
                onResume()
//                recyclerViewCategory.removeAllViewsInLayout()
                recyclerViewProduct.removeAllViewsInLayout()
            }
        })
        recyclerViewCategory.adapter = adapterCategory
        recyclerViewCategory.setHasFixedSize(true)


        binding.tiRefreshLayout.setOnRefreshListener {
//            adapterProduct.refresh()
            CoroutineScope(Dispatchers.Main).launch {
                delay(700)
                binding.tiRefreshLayout.isRefreshing = false
            }

        }



        recyclerViewProduct = view.rvProduct
        recyclerViewProduct.addItemDecoration(SpaceItemDecoration(30, false))
        adapterProduct = PagingAdapterProducts(
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
                    if (!boolean) {
                        v.imgFavorite.setImageResource(R.drawable.ic_favorite2)
                    } else {
                        v.imgFavorite.setImageResource(R.drawable.ic_favorite)
                    }

                    viewModel.postLike("Bearer $USER_TOKEN", baseID.toString())

                }
            })

        recyclerViewProduct.adapter = adapterProduct
        recyclerViewProduct.setHasFixedSize(true)


//        uLogD("TEST -> onCreate")
//        viewModel.getCategory()
//        viewModel.myCategory.observe(viewLifecycleOwner) { list ->
//            if (list.isSuccessful) {
//                list.body()?.data!![0].children.let { adapterCategory.setList(it) }
//            }
//        }

        viewModel.getCategoryPagingLiveData().observe(viewLifecycleOwner) { pagingData ->
            adapterCategory.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }

        return view.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем ссылку на ViewBinding активити
        activityBinding = (requireActivity() as? MainActivity)?.binding
        // Используем ссылку на ViewBinding активити, чтобы получить доступ к View
        activityBinding?.bottomAppBar?.visibility = View.VISIBLE
        activityBinding?.floatBottom?.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCategoryProductLiveData("Bearer $USER_TOKEN", map).observe(viewLifecycleOwner) { pagingData ->
            adapterProduct.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activityBinding = null

    }


}