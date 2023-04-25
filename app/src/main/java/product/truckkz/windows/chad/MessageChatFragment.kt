package product.truckkz.windows.chad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import product.truckkz.databinding.FragmentMessageChatBinding

class MessageChatFragment : Fragment() {

    private var _binding: FragmentMessageChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMessageChatBinding.inflate(inflater, container, false)
        val view = binding



        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}