package product.truckkz.windows.authorization.reset

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import product.truckkz.R
import kotlinx.android.synthetic.main.fragment_reset.view.*

class ResetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_reset, container, false)

        view.back_auth.setOnClickListener {
            activity?.onBackPressed()
        }
        return view
    }

}