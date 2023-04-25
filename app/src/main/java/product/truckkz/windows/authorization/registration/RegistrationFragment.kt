package product.truckkz.windows.authorization.registration

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import product.truckkz.R
import product.truckkz.UserDate
import product.truckkz.UserDate.USER_STATUS
import product.truckkz.viewModels.HomeViewModels
import com.google.gson.JsonObject
import org.json.JSONObject
import product.truckkz.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModels
    lateinit var dialog: Dialog
    lateinit var dialog2: Dialog
    private lateinit var preferencesUSERSTATUS: SharedPreferences


    @Suppress("DEPRECATION")
    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        val view = binding

        dialog = Dialog(requireContext())
        dialog2 = Dialog(requireContext())

        preferencesUSERSTATUS = (activity as AppCompatActivity).getSharedPreferences(
            UserDate.APP_PREFERENCES,
            Context.MODE_PRIVATE
        )


        view.btnBackStack.setOnClickListener {
            activity?.onBackPressed()
        }

        viewModel.myUserRegister.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                activity?.onBackPressed()
                USER_STATUS = true
                alertDialogCancel2()
            } else {
                view.scrollConst.visibility = View.VISIBLE
                view.loafer.visibility = View.GONE
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                alertDialogCancel(
                    jsonObj.getString("message").toString(),
                    jsonObj.getString("errors").toString()
                )
            }
        }

        view.btnRegistration.setOnClickListener {
            if (view.authEditName.text!!.isNotEmpty() &&
                view.authEditEmail.text!!.isNotEmpty() &&
                view.authEditPassword.text!!.isNotEmpty() &&
                view.authEditPassword2.text!!.isNotEmpty()
            ) {
                if (view.authEditPassword.text.toString() == view.authEditPassword2.text.toString()) {
                    if (view.checkboxState.isChecked) {
                        view.scrollConst.visibility = View.GONE
                        view.loafer.visibility = View.VISIBLE
                        val paramObjectt = JsonObject()
                        paramObjectt.addProperty(
                            "firstName",
                            view.authEditName.text.toString().trim()
                        )
                        paramObjectt.addProperty("email", view.authEditEmail.text.toString().trim())
                        paramObjectt.addProperty(
                            "password",
                            view.authEditPassword.text.toString().trim()
                        )

                        viewModel.postUserRegister(paramObjectt)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Нужно согласиться с пользовательским соглашением",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                } else {

                    Toast.makeText(requireContext(), "Пароли не совпадают", Toast.LENGTH_SHORT)
                        .show()
                }

            } else {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        return view.root
    }

    private fun alertDialogCancel(title: String, descrip: String) {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_error_auth)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog.findViewById<ImageView>(R.id.dialog_yes)
        val textTitle = dialog.findViewById<TextView>(R.id.txt_title)
        val textDescrip = dialog.findViewById<TextView>(R.id.txt_descript)
        textTitle.text = title
        textDescrip.text = descrip
        buttonYES.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

    private fun alertDialogCancel2() {

        dialog2.setCancelable(false)
        dialog2.setCanceledOnTouchOutside(false)
        dialog2.setContentView(R.layout.dialog_succes_register)
        dialog2.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog2.findViewById<ImageView>(R.id.dialog_yes)
        buttonYES.setOnClickListener {
            dialog2.dismiss()
        }
        dialog2.show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}