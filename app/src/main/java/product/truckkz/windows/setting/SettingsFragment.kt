package product.truckkz.windows.setting

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import product.truckkz.R
import kotlinx.android.synthetic.main.fragment_settings.view.*

class SettingsFragment : Fragment() {

    lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        dialog = Dialog(requireContext())


        view.removeUser.setOnClickListener {
            alertDialogCancel()
        }


        return view
    }

    private fun alertDialogCancel() {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_user_remove)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonExit = dialog.findViewById<ImageView>(R.id.dialog_exit)
        val buttonYes = dialog.findViewById<Button>(R.id.dialog_yes)
        val buttonNo = dialog.findViewById<TextView>(R.id.dialog_no)
        buttonExit.setOnClickListener {
            dialog.dismiss()
        }
        buttonYes.setOnClickListener {
            dialog.dismiss()
        }
        buttonNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

}