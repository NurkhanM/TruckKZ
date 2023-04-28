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
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.`interface`.IClickListnearHomeTest
import product.truckkz.models.TestRecomendModel
import product.truckkz.viewModels.HomeViewModels
import me.farahani.spaceitemdecoration.SpaceItemDecoration
import product.truckkz.MainActivity
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
    private lateinit var recyclerViewProduct2: RecyclerView
    private lateinit var adapterCategory: TovarAdapterCategory
    private lateinit var adapterProduct: TovarAdapterProduct
    private lateinit var adapterProduct2: TovarAdapterProduct2
    private var arrayRecomend = ArrayList<TestRecomendModel>()
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




        arrayRecomend = arrayListOf(
            TestRecomendModel(R.drawable.test_image3),
            TestRecomendModel(R.drawable.test_image),
            TestRecomendModel(R.drawable.test_image2),
            TestRecomendModel(R.drawable.test_image4),
            TestRecomendModel(R.drawable.test_image3),
            TestRecomendModel(R.drawable.test_image),
            TestRecomendModel(R.drawable.test_image2),
            TestRecomendModel(R.drawable.test_image4),
            TestRecomendModel(R.drawable.test_image3),
            TestRecomendModel(R.drawable.test_image)
        )





        recyclerViewCategory = view.rvCategory
//        recyclerViewCategory.addItemDecoration(SpaceItemDecoration(50, true))
        adapterCategory = TovarAdapterCategory(object : IClickListnearHomeTest {
            override fun clickListener(baseID: Int) {
                map.clear()
                map["category"] = baseID.toString()
                rfCategory()
                recyclerViewProduct.removeAllViewsInLayout()
                adapterProduct.notifyDataSetChanged()
                view.rvProduct.visibility = View.VISIBLE
                view.rvProduct2.visibility = View.GONE
            }
        })
        recyclerViewCategory.adapter = adapterCategory
        recyclerViewCategory.setHasFixedSize(true)




        viewModel.getCategory()
        viewModel.myCategory.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                list.body()?.data!![0].children.let { adapterCategory.setList(it) }
            }

        }



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
        adapterProduct = TovarAdapterProduct(
            object : IClickListnearHomeFavorite {
                override fun clickListener(baseID: Int) {
//                    if (!USER_STATUS) {
//                        Navigation.findNavController(view)
//                            .navigate(R.id.action_homeFragment_to_authorizationFragment)
//                    } else {
                    ALL_ID_PRODUCTS = baseID
                    Navigation.findNavController(view.root)
                        .navigate(R.id.action_homeFragment_to_homeInfoFragment)
//                    }
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




        recyclerViewProduct2 = view.rvProduct2
        recyclerViewProduct2.addItemDecoration(SpaceItemDecoration(30, false))
        adapterProduct2 = TovarAdapterProduct2(
            object : IClickListnearHomeFavorite {
                override fun clickListener(baseID: Int) {
//                    if (!USER_STATUS) {
//                        Navigation.findNavController(view)
//                            .navigate(R.id.action_homeFragment_to_authorizationFragment)
//                    } else {
                    ALL_ID_PRODUCTS = baseID
                    Navigation.findNavController(view.root)
                        .navigate(R.id.action_homeFragment_to_homeInfoFragment)
//                    }
                }

                override fun clickListenerFavorite(
                    baseID: Int,
                    v: ItemTovarBinding,
                    boolean: Boolean,
                    pos: Int
                ) {

                }
            })

        recyclerViewProduct2.adapter = adapterProduct2
        recyclerViewProduct2.setHasFixedSize(true)
        rfProduct()


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


    private fun rfProduct() {
        viewModel.getProduct2("Bearer $TOKEN_USER")
        viewModel.myProduct2.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                list.body()?.data?.let { adapterProduct2.setList(it) }
            }
        }
//        viewModel.getProduct("Bearer $TOKEN_USER")
//        viewModel.myGetProduct.observe(viewLifecycleOwner) {
//            adapterProduct.submitData(viewLifecycleOwner.lifecycle, it)
//        }

    }

    private fun rfCategory() {
        viewModel.mySortProducts2(map)
        viewModel.mySortProducts.observe(viewLifecycleOwner) {
            adapterProduct.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activityBinding = null
    }


}