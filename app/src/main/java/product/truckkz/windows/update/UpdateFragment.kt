package product.truckkz.windows.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import product.truckkz.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment(){

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        val view = binding



        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}