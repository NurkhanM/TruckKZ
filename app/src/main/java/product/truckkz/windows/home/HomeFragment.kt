package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import product.truckkz.DataAllProducts.ALL_ID_PRODUCTS
import product.truckkz.R
import product.truckkz.UserDate.APP_PREFERENCES
import product.truckkz.UserDate.KEY_USER_STATUS
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.UserDate.USER_STATUS
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.`interface`.IClickListnearHomeTest
import product.truckkz.models.TestRecomendModel
import product.truckkz.viewModels.HomeViewModels
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_full_registration2.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_tovar.view.*
import me.farahani.spaceitemdecoration.SpaceItemDecoration
import product.truckkz.models.category.Data
import java.util.HashMap
import kotlin.math.log

class HomeFragment : Fragment() {

    lateinit var recyclerViewRecomend: RecyclerView
    lateinit var recyclerViewCategory: RecyclerView
    lateinit var recyclerViewProduct: RecyclerView
    lateinit var recyclerViewProduct2: RecyclerView
    private lateinit var adapterRecomend: TovarAdapterRecomend
    private lateinit var adapterCategory: TovarAdapterCategory
    private lateinit var adapterProduct: TovarAdapterProduct
    private lateinit var adapterProduct2: TovarAdapterProduct2
    private var arrayRecomend = ArrayList<TestRecomendModel>()
    private val map = HashMap<String, String>()

    private lateinit var viewModel: HomeViewModels

    private lateinit var preferencesUSERSTATUS: SharedPreferences


    @SuppressLint("UseCompatLoadingForDrawables", "NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as AppCompatActivity).bottomAppBar.visibility = View.VISIBLE
        (activity as AppCompatActivity).floatBottom.visibility = View.VISIBLE
//        (activity as AppCompatActivity).mainConst.setBackgroundColor(resources.getColor(R.color.white))

        preferencesUSERSTATUS = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        USER_STATUS = preferencesUSERSTATUS.getBoolean(KEY_USER_STATUS, false)


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

        recyclerViewRecomend = view.rv_recomend
//        recyclerViewRecomend.addItemDecoration(SpaceItemDecoration(50, true))
        adapterRecomend = TovarAdapterRecomend(object : IClickListnearHomeTest {
            override fun clickListener(baseID: Int) {
                if (!USER_STATUS) {
                    Navigation.findNavController(view)
                        .navigate(R.id.action_homeFragment_to_authorizationFragment)
                } else {
                    ALL_ID_PRODUCTS = baseID
                    Navigation.findNavController(view)
                        .navigate(R.id.action_homeFragment_to_homeInfoFragment)
                }
            }
        })
        recyclerViewRecomend.adapter = adapterRecomend
        recyclerViewRecomend.setHasFixedSize(true)
        adapterRecomend.setList(arrayRecomend)






        recyclerViewCategory = view.rv_category
//        recyclerViewCategory.addItemDecoration(SpaceItemDecoration(50, true))
        adapterCategory = TovarAdapterCategory(object : IClickListnearHomeTest {
            override fun clickListener(baseID: Int) {
                map.clear()
                map["category"] = baseID.toString()
                rfCategory()
                recyclerViewProduct.removeAllViewsInLayout()
                adapterProduct.notifyDataSetChanged()
                view.rv_product.visibility = View.VISIBLE
                view.rv_product2.visibility = View.GONE
            }
        })
        recyclerViewCategory.adapter = adapterCategory
        recyclerViewCategory.setHasFixedSize(true)




        viewModel.getCategory()
        viewModel.myCategory.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                list.body()?.data!![0].children.let {  adapterCategory.setList(it) }
            }

        }



        view.tiRefreshLayout.setOnRefreshListener {
            rfCategory()
            adapterRecomend.setList(arrayRecomend)
            recyclerViewRecomend.removeAllViewsInLayout()
            recyclerViewCategory.removeAllViewsInLayout()
            recyclerViewProduct.removeAllViewsInLayout()

            adapterProduct.notifyDataSetChanged()
            adapterCategory.notifyDataSetChanged()
            adapterRecomend.notifyDataSetChanged()
            view.tiRefreshLayout.isRefreshing = false
        }



        recyclerViewProduct = view.rv_product
        recyclerViewProduct.addItemDecoration(SpaceItemDecoration(30, false))
        adapterProduct = TovarAdapterProduct(
            object : IClickListnearHomeFavorite {
                override fun clickListener(baseID: Int) {
//                    if (!USER_STATUS) {
//                        Navigation.findNavController(view)
//                            .navigate(R.id.action_homeFragment_to_authorizationFragment)
//                    } else {
                        ALL_ID_PRODUCTS = baseID
                        Navigation.findNavController(view)
                            .navigate(R.id.action_homeFragment_to_homeInfoFragment)
//                    }
                }

                override fun clickListenerFavorite(baseID: Int, v: View, boolean: Boolean, pos: Int) {

                }
            })

        recyclerViewProduct.adapter = adapterProduct
        recyclerViewProduct.setHasFixedSize(true)




        recyclerViewProduct2 = view.rv_product2
        recyclerViewProduct2.addItemDecoration(SpaceItemDecoration(30, false))
        adapterProduct2 = TovarAdapterProduct2(
            object : IClickListnearHomeFavorite {
                override fun clickListener(baseID: Int) {
//                    if (!USER_STATUS) {
//                        Navigation.findNavController(view)
//                            .navigate(R.id.action_homeFragment_to_authorizationFragment)
//                    } else {
                        ALL_ID_PRODUCTS = baseID
                        Navigation.findNavController(view)
                            .navigate(R.id.action_homeFragment_to_homeInfoFragment)
//                    }
                }

                override fun clickListenerFavorite(baseID: Int, v: View, boolean: Boolean, pos: Int) {
                    if (!USER_STATUS) {
                        Navigation.findNavController(view)
                            .navigate(R.id.action_homeFragment_to_authorizationFragment)
                    } else {
                        if (!boolean) {
                            viewModel.addFavorite("Bearer $TOKEN_USER", baseID)
                            v.img_favorite?.setImageDrawable(
                                requireContext().resources.getDrawable(
                                    R.drawable.ic_favorite2
                                )
                            )
                        } else {
                            viewModel.deleteFavorite("Bearer $TOKEN_USER", baseID)
                            v.img_favorite?.setImageDrawable(
                                requireContext().resources.getDrawable(
                                    R.drawable.ic_favorite
                                )
                            )
                        }
                    }
                }
            })

        recyclerViewProduct2.adapter = adapterProduct2
        recyclerViewProduct2.setHasFixedSize(true)
        rfProduct()


        return view
    }


    private fun rfProduct(){
        viewModel.getProduct2("Bearer $TOKEN_USER")
        viewModel.myProduct2.observe(viewLifecycleOwner){ list ->
            if (list.isSuccessful){
                list.body()?.data?.let { adapterProduct2.setList(it) }
            }
        }
//        viewModel.getProduct("Bearer $TOKEN_USER")
//        viewModel.myGetProduct.observe(viewLifecycleOwner) {
//            adapterProduct.submitData(viewLifecycleOwner.lifecycle, it)
//        }

    }

    private fun rfCategory(){
        viewModel.mySortProducts2(map)
        viewModel.mySortProducts.observe(viewLifecycleOwner) {
            adapterProduct.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }



}