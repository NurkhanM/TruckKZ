package product.truckkz.windows.authorization.reset

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import product.truckkz.databinding.FragmentResetBinding

class ResetFragment : Fragment() {

    private var _binding: FragmentResetBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResetBinding.inflate(inflater, container, false)
        val view = binding

        view.backAuth.setOnClickListener {
            activity?.onBackPressed()
        }
        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}