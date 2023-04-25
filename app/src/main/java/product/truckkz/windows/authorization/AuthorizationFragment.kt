package product.truckkz.windows.authorization

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
import androidx.navigation.Navigation
import product.truckkz.R
import product.truckkz.UserDate.APP_PREFERENCES
import product.truckkz.UserDate.KEY_TOKEN
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.UserDate.USER_STATUS
import product.truckkz.viewModels.HomeViewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject
import product.truckkz.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {

    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModels
    private lateinit var dialog: Dialog
    private val profileAuth = HashMap<String, String>()
    private lateinit var preferencesTOKEN: SharedPreferences

    @Suppress("DEPRECATION")
    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        val view = binding

//        (activity as AppCompatActivity).bottomAppBar.visibility = View.VISIBLE
//        (activity as AppCompatActivity).floatBottom.visibility = View.VISIBLE

        dialog = Dialog(requireContext())


        preferencesTOKEN = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        view.createAccount.setOnClickListener {
            Navigation.findNavController(view.root).navigate(R.id.action_authorizationFragment_to_registrationFragment)
        }
        view.txtReset.setOnClickListener {
            Navigation.findNavController(view.root).navigate(R.id.action_authorizationFragment_to_resetFragment)
        }

        viewModel.myUserSignIn.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                view.constraintLayoutAuth.visibility = View.GONE
                view.gifAut.visibility = View.GONE
                view.textWelcome.visibility = View.VISIBLE
                USER_STATUS = true
                view.gifAut.visibility = View.GONE

                TOKEN_USER = list.body()?.token.toString()
//                idUser = list.body()?.user?.id.toString()

                CoroutineScope(Dispatchers.Main).launch {
                    delay(2000)
                    Navigation.findNavController(view.root).navigate(R.id.action_authorizationFragment_to_profileFragment)
                }

                preferencesTOKEN.edit().putString(KEY_TOKEN, TOKEN_USER).apply()
            } else {
                view.constraintLayoutAuth.visibility = View.VISIBLE
                view.gifAut.visibility = View.GONE
                view.textWelcome.visibility = View.GONE
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                alertDialogCancel(jsonObj.getString("message").toString(),jsonObj.getString("error").toString())
            }
        }

        view.btnAuth.setOnClickListener {
            if (view.authEditEmail.text!!.isNotEmpty() &&
                view.authEditPassword.text!!.isNotEmpty()
            ) {
                view.constraintLayoutAuth.visibility = View.GONE
                view.gifAut.visibility = View.VISIBLE
                view.textWelcome.visibility = View.GONE

                profileAuth["email"] = view.authEditEmail.text.toString().trim()
                profileAuth["password"] = view.authEditPassword.text.toString().trim()
                if (view.remember.isChecked) {
                    profileAuth["remember"] = "1"
                } else {
                    profileAuth["remember"] = "0"
                }

                view.btnAuth.backgroundTintList =
                    resources.getColorStateList(R.color.black_txt4)

                viewModel.postUserSignIn(profileAuth)


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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}