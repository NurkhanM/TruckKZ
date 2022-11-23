package product.truckkz.windows.home.showImage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import product.truckkz.DataAllProducts.IMAGES_INFO_ARRAY
import product.truckkz.R
import kotlinx.android.synthetic.main.fragment_show_image.view.*

class ShowImageFragment : Fragment() {

    private var indexShow: Int = -2


    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_show_image, container, false)

        val arguments = (activity as AppCompatActivity).intent.extras
        indexShow = arguments!!["index"] as Int


            view.view_pager_show.adapter = ShowImageAdapterAdvert(IMAGES_INFO_ARRAY)
            view.view_pager_show.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            view.view_pager_show.currentItem = indexShow
            view.indicator_circular_show.setViewPager((view.view_pager_show))

        view.clickShowBackCard.setOnClickListener{
            (activity as AppCompatActivity).onBackPressed()
        }

        return view
    }
}