package product.truckkz.windows.splash

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import product.truckkz.FormFullRegistration.idUser
import product.truckkz.R
import product.truckkz.UserDate.APP_PREFERENCES
import product.truckkz.UserDate.KEY_TOKEN
import product.truckkz.UserDate.KEY_USER_ID
import product.truckkz.UserDate.KEY_USER_STATUS_FULL
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.UserDate.USER_STATUS_FULL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private lateinit var preferencesTOKEN: SharedPreferences
    private lateinit var preferencesUserStatus: SharedPreferences
    private lateinit var preferencesUserId: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
//        (activity as AppCompatActivity).window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.white)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity?.window!!.decorView.windowInsetsController!!.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)
        }

        preferencesTOKEN = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        preferencesUserStatus = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        preferencesUserId = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        TOKEN_USER = preferencesTOKEN.getString(KEY_TOKEN, "").toString()
        USER_STATUS_FULL = preferencesUserStatus.getBoolean(KEY_USER_STATUS_FULL, false)
        idUser = preferencesUserId.getString(KEY_USER_ID, "15").toString()


        // Метод для показа полно экранного режима
        fullScreen()
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment)
        }
        return view
    }

    @SuppressLint("ObsoleteSdkInt")
    fun fullScreen() {

        val uiOptions = (activity as AppCompatActivity).window.decorView.systemUiVisibility
        var newUiOptions = uiOptions

        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
        (activity as AppCompatActivity).window.decorView.systemUiVisibility = newUiOptions
    }


}