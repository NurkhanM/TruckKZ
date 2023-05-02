package product.truckkz.windows.home

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.DataAllProducts.ALL_ID_PRODUCTS
import product.truckkz.DataAllProducts.IMAGES_INFO_ARRAY
import product.truckkz.R
import product.truckkz.UserDate
import product.truckkz.UserDate.USER_TOKEN
import product.truckkz.databinding.FragmentHomeInfoBinding
import product.truckkz.`interface`.IClickListnearUpdateImage
import product.truckkz.models.products.productInfo.Images
import product.truckkz.viewModels.HomeViewModels
import product.truckkz.windows.home.adapter.UpdateDataAdapter
import product.truckkz.windows.home.showImage.ShowImageActivity


class HomeInfoFragment : Fragment() {

    private var _binding: FragmentHomeInfoBinding? = null
    private val binding get() = _binding!!

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UpdateDataAdapter

    lateinit var viewModels: HomeViewModels
    private var isMoreState: Boolean = true
    private var indexShow: Int = 0
    private var isLike: Boolean = false

    private var callInfo = ""
    var productName = ""

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModels = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentHomeInfoBinding.inflate(inflater, container, false)
        val view = binding


        viewModels.getProductInfo("Bearer ${UserDate.USER_TOKEN}", ALL_ID_PRODUCTS)
        viewModels.myProductInfo.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                view.textTitle.text = list.body()?.data?.title
                view.textPrice.text = list.body()?.data?.price.toString() + " $"
                if (list.body()?.data?.description.toString() == "null") {
                    view.textDescription.text = ""
                } else {
                    view.textDescription.text = list.body()?.data?.description.toString()
                }

                callInfo = list.body()?.data?.user?.phone.toString()

//                if (list.body()?.favorite == true){
//                    view.img_favorite.setImageDrawable(requireContext().resources.getDrawable(R.drawable.ic_favorite2))
//                }else{
//                    view.img_favorite.setImageDrawable(requireContext().resources.getDrawable(R.drawable.ic_favorite))
//                }


                isLike = if (list.body()?.data?.isLike == false) {
                    binding.imgFavorite.setImageResource(R.drawable.ic_favorite)
                    false
                } else {
                    binding.imgFavorite.setImageResource(R.drawable.ic_favorite2)
                    true
                }

                binding.idProduct.text = " " + list.body()?.data?.id.toString()
                binding.idCreate.text = " " + list.body()?.data?.created_at.toString()
                binding.idUpdate.text = " " + list.body()?.data?.updated_at.toString()
                productName = list.body()?.data?.title.toString()


                val linearLayout = LinearLayout(context) // создание LinearLayout
                linearLayout.orientation = LinearLayout.VERTICAL // задание ориентации
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = 50
                } // задание параметров макета

                for (i in 0 until list.body()?.data?.characteristics?.size!!) {
                    val innerLinearLayout =
                        LinearLayout(context) // создание внутреннего LinearLayout
                    innerLinearLayout.orientation = LinearLayout.HORIZONTAL // задание ориентации
                    innerLinearLayout.layoutParams = layoutParams // задание параметров макета

                    // создание TextView для name
                    val nameTextView = TextView(context)
                    nameTextView.layoutParams = LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1.0f
                    )// задание параметров макета с весом 1
                    nameTextView.text = list.body()?.data?.characteristics!![i].name + ": "
                    // получение цвета из ресурсов
                    val colorName = ContextCompat.getColor(requireContext(), R.color.black_txt4)
                    // установка цвета текста для внутреннего TextView
                    nameTextView.setTextColor(colorName)
                    nameTextView.textSize = 13f
                    // установка жирного стиля для текста в TextView
                    nameTextView.setTypeface(null, Typeface.BOLD)

                    // создание TextView для value
                    val valueTextView = TextView(context)
                    valueTextView.layoutParams = LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        2.0f
                    ).apply {
                        gravity = Gravity.CENTER_HORIZONTAL
                    } // задание параметров макета с весом 1
                    valueTextView.text = list.body()?.data?.characteristics!![i].value
                    val colorValue = ContextCompat.getColor(requireContext(), R.color.black)
                    // установка цвета текста для внутреннего TextView
                    valueTextView.setTextColor(colorValue)

                    // добавление TextView во внутренний LinearLayout
                    innerLinearLayout.addView(nameTextView)
                    innerLinearLayout.addView(valueTextView)

                    // добавление внутреннего LinearLayout в основной LinearLayout
                    linearLayout.addView(innerLinearLayout)
                }

                view.textHarakter.addView(linearLayout) // добавление основного LinearLayout в TextView


                IMAGES_INFO_ARRAY.clear()
                for (i in 0 until list?.body()?.data?.gallery?.size!!) {

                    IMAGES_INFO_ARRAY.add(Images(i, list.body()?.data?.gallery!![i], i))
                }
                Glide.with(requireContext()).load(list.body()?.data?.img)
                    .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                    .fitCenter()
                    .into(view.imageShow)
                adapter.setListImage(IMAGES_INFO_ARRAY)

            }
        }

        recyclerView = view.recyclerUpdate
        adapter = UpdateDataAdapter(object : IClickListnearUpdateImage {
            override fun clickListener(baseID: String, index: Int) {
                Glide.with(requireContext()).load(baseID)
                    .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                    .fitCenter().into(view.imageShow)
                indexShow = index
            }

        })
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)




        view.itemFavorite.setOnClickListener {
            isLike = if (isLike) {
                view.imgFavorite.setImageResource(R.drawable.ic_favorite)
                false
            } else {
                Toast.makeText(
                    requireContext(),
                    "${resources.getText(R.string.you_added)} $productName ${
                        resources.getText(
                            R.string.fovarite_to
                        )
                    }",
                    Toast.LENGTH_SHORT
                ).show()
                view.imgFavorite.setImageResource(R.drawable.ic_favorite2)
                true
            }

            viewModels.postLike("Bearer $USER_TOKEN", ALL_ID_PRODUCTS.toString())
        }


        view.imageShow.setOnClickListener {
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
            callPhone()
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

        view.clickUpdateBackCard.setOnClickListener {
            activity?.onBackPressed()
//            Navigation.findNavController(view.root).navigateUp()
        }

        return view.root
    }

    private fun callPhone() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$callInfo")
        startActivity(intent)
    }

    private fun removeStartEnDChars(str: String): String {
        return str.substring(1, str.length - 1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}