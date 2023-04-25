package product.truckkz.windows.favorite

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import product.truckkz.DataAllProducts.ALL_ID_PRODUCTS
import me.farahani.spaceitemdecoration.SpaceItemDecoration
import product.truckkz.R
import product.truckkz.UserDate
import product.truckkz.databinding.FragmentFavoriteBinding
import product.truckkz.`interface`.IClickListnearHomeFavorite
import product.truckkz.viewModels.HomeViewModels
import product.truckkz.windows.home.TovarAdapterProduct

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModels
    lateinit var recyclerViewProduct: RecyclerView
    private lateinit var adapterProduct: TovarAdapterProduct

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding

        recyclerViewProduct = view.rvFavorite
        recyclerViewProduct.addItemDecoration(SpaceItemDecoration(30, false))
        adapterProduct = TovarAdapterProduct(
            object : IClickListnearHomeFavorite {
                override fun clickListener(baseID: Int) {
                    ALL_ID_PRODUCTS = baseID
                    Navigation.findNavController(view.root)
                        .navigate(R.id.action_homeFragment_to_homeInfoFragment)
                }

                @SuppressLint("UseCompatLoadingForDrawables", "NotifyDataSetChanged")
                override fun clickListenerFavorite(
                    baseID: Int,
                    v: View,
                    boolean: Boolean,
                    pos: Int
                ) {
                    if (!boolean) {
//                        viewModel.addFavorite("Bearer ${UserDate.TOKEN_USER}", baseID)
//                        v.img_favorite?.setImageDrawable(
//                            requireContext().resources.getDrawable(
//                                R.drawable.ic_favorite2
//                            )
//                        )
                    } else {
//                        viewModel.deleteFavorite("Bearer ${UserDate.TOKEN_USER}", baseID)
//                        v.img_favorite?.setImageDrawable(
//                            requireContext().resources.getDrawable(
//                                R.drawable.ic_favorite
//                            )
//                        )
                    }
                    Toast.makeText(requireContext(), "Удалено", Toast.LENGTH_SHORT).show()
//                    adapterProduct.deleteMyEducations(pos)
                }
            })

        recyclerViewProduct.adapter = adapterProduct
        recyclerViewProduct.setHasFixedSize(true)


        return view.root
    }


    override fun onResume() {
        super.onResume()

        viewModel.getFavorite("Bearer ${UserDate.TOKEN_USER}")
        viewModel.myGetProduct.observe(viewLifecycleOwner) {
            adapterProduct.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}