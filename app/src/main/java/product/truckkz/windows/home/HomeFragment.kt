package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
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
import product.truckkz.databinding.ActivityMainBinding
import product.truckkz.databinding.FragmentHomeBinding
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.windows.home.paging.PagingAdapterCategory
import product.truckkz.windows.home.paging.PagingAdapterProducts
import product.truckkz.windows.homeInfo.HomeInfoActivity
import java.util.HashMap

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var activityBinding: ActivityMainBinding? = null

    private lateinit var recyclerViewCategory: RecyclerView
    lateinit var recyclerViewProduct: RecyclerView

    private lateinit var adapterCategory: PagingAdapterCategory
    private lateinit var adapterProduct: PagingAdapterProducts

    private val map = HashMap<String, String>()
    private val viewModel by viewModels<HomeViewModels>()


    @SuppressLint("UseCompatLoadingForDrawables", "NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
                isLoad()
                recyclerViewProduct.removeAllViewsInLayout()
            }
        })
        recyclerViewCategory.adapter = adapterCategory
        recyclerViewCategory.setHasFixedSize(true)


        recyclerViewProduct = view.rvProduct
        recyclerViewProduct.addItemDecoration(SpaceItemDecoration(30, false))
        adapterProduct = PagingAdapterProducts(
            object : IClickListnearHomeFavorite {

                override fun clickListener(baseID: Int) {

                    ALL_ID_PRODUCTS = baseID
                    val intent = Intent(requireActivity(), HomeInfoActivity::class.java)
                    myActivityResult.launch(intent)
                    activity?.overridePendingTransition(
                        R.anim.zoom_enter,
                        R.anim.zoom_exit
                    )

                }

                override fun clickListenerFavorite(
                    baseID: Int,
                    v: Any,
                    boolean: Boolean,
                    pos: Int
                ) {
                    if (!boolean) {
                        (v as ItemTovarBinding).imgFavorite.setImageResource(R.drawable.ic_favorite2)
                    } else {
                        (v as ItemTovarBinding).imgFavorite.setImageResource(R.drawable.ic_favorite)
                    }

                    viewModel.postLike("Bearer $USER_TOKEN", baseID.toString())

                }
            })

        recyclerViewProduct.adapter = adapterProduct
        recyclerViewProduct.setHasFixedSize(true)

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

        viewModel.getCategoryPagingLiveData().observe(viewLifecycleOwner) { pagingData ->
            adapterCategory.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }

        isLoad()

        // Обновляем данные и адаптер при обновлении фрагмента
        binding.tiRefreshLayout.setOnRefreshListener {
            isLoad()
//            adapterProduct.refresh()
            CoroutineScope(Dispatchers.Main).launch {
                delay(700)
                binding.tiRefreshLayout.isRefreshing = false
            }
        }
    }


    private fun isLoad() {

        viewModel.getCategoryProductLiveData("Bearer $USER_TOKEN", map)
            .observe(viewLifecycleOwner) { pagingData ->
                adapterProduct.submitData(viewLifecycleOwner.lifecycle, pagingData)
                adapterProduct.showLoading()
            }

       adapterProduct.addLoadStateListener { loadState ->
            when (loadState.refresh) {
                is LoadState.Loading -> {
                    // состояние загрузки страницы обновления

                    adapterProduct.showLoading()

                }

                is LoadState.Error -> {
                    // состояние ошибки при загрузке страницы обновления
                    // обработка ошибки
                    // val errorMessage = (loadState.refresh as LoadState.Error).error.message
                    // uLogD("TEST ->  $errorMessage")
                }

                else -> {
                    // состояние успешной загрузки страницы обновления

                    binding.rvProduct.visibility = View.VISIBLE
                    binding.loaderItem.visibility = View.GONE
                    adapterProduct.hideLoading()

                }
            }
        }
    }


    private val myActivityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                //val data: Intent? = result.data
                isLoad()
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activityBinding = null
    }

}