package product.truckkz.windows.profile.myAds

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import me.farahani.spaceitemdecoration.SpaceItemDecoration
import product.truckkz.DataAllProducts
import product.truckkz.MyUtils
import product.truckkz.R
import product.truckkz.UserDate.USER_TOKEN
import product.truckkz.databinding.FragmentMyAdsBinding
import product.truckkz.databinding.ItemTovarBinding
import product.truckkz.databinding.ItemTovarOrdinaryBinding
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.viewModels.HomeViewModels
import product.truckkz.windows.home.adapter.ProductAdapter

class MyAdsFragment : Fragment() {

    private var _binding: FragmentMyAdsBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: HomeViewModels
    lateinit var recyclerViewProduct: RecyclerView
    private lateinit var adapterProduct: ProductAdapter
    var idUser = ""

    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentMyAdsBinding.inflate(inflater, container, false)
        val view = binding

        val args = arguments
        idUser = args?.getString("User_id").toString()


        recyclerViewProduct = view.rvMyAds
        recyclerViewProduct.addItemDecoration(SpaceItemDecoration(30, false))
        adapterProduct = ProductAdapter(
            object : IClickListnearHomeFavorite {
                override fun clickListener(baseID: Int) {
                    DataAllProducts.ALL_ID_PRODUCTS = baseID
                    Navigation.findNavController(view.root)
                        .navigate(R.id.action_myAdsFragment_to_homeInfoFragment)
                }

                @SuppressLint("UseCompatLoadingForDrawables", "NotifyDataSetChanged")
                override fun clickListenerFavorite(
                    baseID: Int,
                    v: Any,
                    boolean: Boolean,
                    pos: Int
                ) {

                    if (!boolean) {
                        (v as ItemTovarOrdinaryBinding).imgFavorite.setImageResource(R.drawable.ic_favorite2)
                    } else {
                        (v as ItemTovarOrdinaryBinding).imgFavorite.setImageResource(R.drawable.ic_favorite)
                    }

                    viewModel.postLike("Bearer $USER_TOKEN", baseID.toString())

                }
            })

        recyclerViewProduct.adapter = adapterProduct
        recyclerViewProduct.setHasFixedSize(true)


        binding.ochBackCard.setOnClickListener {
            activity?.onBackPressed()
        }


        return view.root
    }


    override fun onResume() {
        super.onResume()

        if (idUser.toIntOrNull() != null){
            viewModel.getMyProducts("Bearer $USER_TOKEN", idUser)
            viewModel.myGetMyProducts.observe(viewLifecycleOwner) { list ->
                if (list.isSuccessful) {
                    list.body()?.data?.let { adapterProduct.setList(it) }
                } else {
                    MyUtils.uToast(requireContext(), "Server error")
                }
            }
        }else{
            MyUtils.uToast(requireContext(), "Sorry is null")
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}