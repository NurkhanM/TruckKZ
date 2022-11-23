package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.DataAllProducts.ALL_ID_PRODUCTS
import product.truckkz.DataAllProducts.IMAGES_INFO_ARRAY
import product.truckkz.R
import product.truckkz.UserDate
import product.truckkz.UserDate.USER_STATUS_FULL
import product.truckkz.`interface`.IClickListnearUpdateImage
import product.truckkz.models.get.productInfo.Images
import product.truckkz.viewModels.HomeViewModels
import product.truckkz.windows.home.showImage.ShowImageActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home_info.view.*
import kotlinx.android.synthetic.main.fragment_home_info.view.img_favorite
import kotlinx.android.synthetic.main.item_tovar.view.*

class HomeInfoFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UpdateDataAdapter

    lateinit var viewModels: HomeViewModels
    private var isMoreState: Boolean = true
    private var indexShow: Int = 0

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModels = ViewModelProvider(this)[HomeViewModels::class.java]
        val view = inflater.inflate(R.layout.fragment_home_info, container, false)

        (activity as AppCompatActivity).bottomAppBar.visibility = View.VISIBLE
        (activity as AppCompatActivity).floatBottom.visibility = View.VISIBLE

        viewModels.getProductInfo("Bearer ${UserDate.TOKEN_USER}", ALL_ID_PRODUCTS)
        viewModels.myProductInfo.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                view.textTitle.text = list.body()?.data?.title
                view.textPrice.text = list.body()?.data?.price.toString() + " сом/ день"
                view.textDescription.text = list.body()?.data?.description.toString()
//                if (list.body()?.favorite == true){
//                    view.img_favorite.setImageDrawable(requireContext().resources.getDrawable(R.drawable.ic_favorite2))
//                }else{
//                    view.img_favorite.setImageDrawable(requireContext().resources.getDrawable(R.drawable.ic_favorite))
//                }

                view.textHarakter.text =
                    " ✯ " + removeStartEnDChars(list.body()?.data?.characteristics.toString()).replace(
                        ",",
                        "\n ✯"
                    ).replace("=", ":  ➤  ")
                IMAGES_INFO_ARRAY.clear()
                for (i in 0 until list?.body()?.data?.gallery?.size!!) {

                    IMAGES_INFO_ARRAY.add(Images(i, list.body()?.data?.gallery!![i], i))
                }
                Glide.with(requireContext()).load(list.body()?.data?.img)
                    .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                    .fitCenter()
                    .into(view.image_show)
                adapter.setListImage(IMAGES_INFO_ARRAY)

            }
        }

        recyclerView = view.recyclerUpdate
        adapter = UpdateDataAdapter(object : IClickListnearUpdateImage {
            override fun clickListener(baseID: String, index: Int) {
                Glide.with(requireContext()).load(baseID)
                    .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                    .fitCenter().into(view.image_show)
                indexShow = index
            }

        })
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)



        view.image_show.setOnClickListener {
            val intent = Intent(requireActivity(), ShowImageActivity::class.java)
            intent.putExtra("index", indexShow)
            startActivity(intent)
            (activity as AppCompatActivity).overridePendingTransition(
                R.anim.zoom_enter,
                R.anim.zoom_exit
            )
        }

        view.linerImageMove.setOnClickListener {
            if (isMoreState) {
                isMoreState = false
                view.imageMove.setImageResource(R.drawable.bottom_right)
                view.textHarakter.visibility = View.GONE
            } else {
                isMoreState = true
                view.imageMove.setImageResource(R.drawable.bottom)
                view.textHarakter.visibility = View.VISIBLE
            }
        }

        view.btnBook.setOnClickListener {
            if (USER_STATUS_FULL) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_homeInfoFragment_to_calendarFragment)
            } else {
                Navigation.findNavController(view)
                    .navigate(R.id.action_homeInfoFragment_to_fullRegistrationFragment)
            }
        }

        view.fragmentContainerUpdate.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
            if (scrollY > 650) {
                val typedValue = TypedValue()
                val theme: Resources.Theme = requireActivity().theme
                theme.resolveAttribute(android.R.attr.windowBackground, typedValue, true)
                val primaryColor = typedValue.data
//                view.updateToolbar.setBackgroundColor(primaryColor)
                view.updateToolbar.setBackgroundColor(primaryColor)
//                view.view_pager_show.background.setTint(ContextCompat.getColor(requireContext(), R.color.white))
            } else {
                view.updateToolbar.setBackgroundColor(0)
            }
        })

        return view
    }

    private fun removeStartEnDChars(str: String): String {
        return str.substring(1, str.length - 1)
    }
}