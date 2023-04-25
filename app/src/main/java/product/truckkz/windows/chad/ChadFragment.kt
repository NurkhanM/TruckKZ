package product.truckkz.windows.chad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import product.truckkz.databinding.FragmentChatBinding

class ChadFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        val view = binding


        return view.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}