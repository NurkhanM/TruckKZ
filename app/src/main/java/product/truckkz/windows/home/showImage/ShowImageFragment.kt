package product.truckkz.windows.home.showImage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import product.truckkz.DataAllProducts.IMAGES_INFO_ARRAY
import product.truckkz.databinding.FragmentShowImageBinding

class ShowImageFragment : Fragment() {

    private var _binding: FragmentShowImageBinding? = null
    private val binding get() = _binding!!

    private var indexShow: Int = -2


    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowImageBinding.inflate(inflater, container, false)
        val view = binding

        val arguments = (activity as AppCompatActivity).intent.extras
        indexShow = arguments!!["index"] as Int


            view.viewPagerShow.adapter = ShowImageAdapterAdvert(IMAGES_INFO_ARRAY)
            view.viewPagerShow.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            view.viewPagerShow.currentItem = indexShow
            view.indicatorCircularShow.setViewPager((view.viewPagerShow))

        view.clickShowBackCard.setOnClickListener{
            (activity as AppCompatActivity).onBackPressed()
        }

        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}