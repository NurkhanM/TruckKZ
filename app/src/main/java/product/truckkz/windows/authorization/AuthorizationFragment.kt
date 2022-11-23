package product.truckkz.windows.authorization

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
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
import product.truckkz.FormFullRegistration.idUser
import product.truckkz.R
import product.truckkz.UserDate.APP_PREFERENCES
import product.truckkz.UserDate.KEY_TOKEN
import product.truckkz.UserDate.KEY_USER_ID
import product.truckkz.UserDate.KEY_USER_STATUS
import product.truckkz.UserDate.RC_SIGN_IN
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.UserDate.USER_STATUS
import product.truckkz.viewModels.HomeViewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_authorization.view.*
import kotlinx.android.synthetic.main.fragment_authorization.view.authEditEmail
import kotlinx.android.synthetic.main.fragment_authorization.view.authEditPassword
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject

class AuthorizationFragment : Fragment() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: HomeViewModels
    lateinit var dialog: Dialog
    private val profileAuth = HashMap<String, String>()
    private lateinit var preferencesTOKEN: SharedPreferences
    private lateinit var preferencesUserId: SharedPreferences
    private lateinit var preferencesUSERSTATUS: SharedPreferences

    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        val view = inflater.inflate(R.layout.fragment_authorization, container, false)
        (activity as AppCompatActivity).bottomAppBar.visibility = View.GONE
        (activity as AppCompatActivity).floatBottom.visibility = View.GONE

        auth = Firebase.auth
        dialog = Dialog(requireContext())
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("366283056587-nuovucc9jhfrcsmaor6l2hsohv54rf4i.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        preferencesTOKEN = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )
        preferencesUserId = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        preferencesUSERSTATUS = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )



        view.nextGoogle.setOnClickListener {
            signIn()
        }
        view.create_account.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_authorizationFragment_to_registrationFragment)
        }
        view.txt_reset.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_authorizationFragment_to_resetFragment)
        }

        viewModel.myUserSignIn.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                view.constraintLayoutAuth.visibility = View.GONE
                view.gif_aut.visibility = View.GONE
                view.textWelcome.visibility = View.VISIBLE
                USER_STATUS = true
                view.gif_aut.visibility = View.GONE

                TOKEN_USER = list.body()?.token.toString()
                idUser = list.body()?.user?.id.toString()

                CoroutineScope(Dispatchers.Main).launch {
                    delay(2000)
                    Navigation.findNavController(view).navigate(R.id.action_authorizationFragment_to_homeFragment)
                }

                preferencesTOKEN.edit().putString(KEY_TOKEN, TOKEN_USER).apply()
                preferencesUserId.edit().putString(KEY_USER_ID, idUser).apply()
                preferencesUSERSTATUS.edit().putBoolean(KEY_USER_STATUS, USER_STATUS).apply()
            } else {
                view.constraintLayoutAuth.visibility = View.VISIBLE
                view.gif_aut.visibility = View.GONE
                view.textWelcome.visibility = View.GONE
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                alertDialogCancel(jsonObj.getString("message").toString(),jsonObj.getString("error").toString())
            }
        }

        view.btn_auth.setOnClickListener {
            if (view.authEditEmail.text!!.isNotEmpty() &&
                view.authEditPassword.text!!.isNotEmpty()
            ) {
                view.constraintLayoutAuth.visibility = View.GONE
                view.gif_aut.visibility = View.VISIBLE
                view.textWelcome.visibility = View.GONE



                profileAuth["email"] = view.authEditEmail.text.toString().trim()
                profileAuth["password"] = view.authEditPassword.text.toString().trim()
                if (view.remember.isChecked) {
                    profileAuth["remember"] = "1"
                } else {
                    profileAuth["remember"] = "0"
                }

                view.btn_auth.backgroundTintList =
                    resources.getColorStateList(R.color.black_txt4)

                viewModel.postUserSignIn(profileAuth)


            } else {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        return view
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            USER_STATUS = true
            preferencesUSERSTATUS.edit().putBoolean(KEY_USER_STATUS, USER_STATUS).apply()
            activity?.onBackPressed()
//            val intent = Intent(requireContext(), GoogleSignInActivity::class.java)
//            intent.putExtra(EXTRA_NAME, user.displayName)
//            intent.putExtra(EXTRA_EMAIL, user.email)
//            startActivity(intent)
        }
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

}