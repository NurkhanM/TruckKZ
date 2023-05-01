package product.truckkz.windows.profile.myAds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import product.truckkz.databinding.FragmentMyAdsBinding

class MyAdsFragment : Fragment() {

    private var _binding: FragmentMyAdsBinding? = null
    private val binding get() = _binding!!


    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyAdsBinding.inflate(inflater, container, false)



        binding.ochBackCard.setOnClickListener {
            activity?.onBackPressed()
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}