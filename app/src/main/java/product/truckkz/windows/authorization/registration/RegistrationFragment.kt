package product.truckkz.windows.authorization.registration

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues
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
import product.truckkz.R
import product.truckkz.UserDate
import product.truckkz.UserDate.RC_SIGN_IN
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
import kotlinx.android.synthetic.main.fragment_registration.view.*
import kotlinx.android.synthetic.main.fragment_registration.view.authEditEmail
import kotlinx.android.synthetic.main.fragment_registration.view.authEditPassword
import kotlinx.android.synthetic.main.fragment_registration.view.btnSignInGoogle
import org.json.JSONObject

class RegistrationFragment : Fragment() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: HomeViewModels
    lateinit var dialog: Dialog
    lateinit var dialog2: Dialog
    private lateinit var preferencesUSERSTATUS: SharedPreferences



    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        auth = Firebase.auth
        dialog = Dialog(requireContext())
        dialog2 = Dialog(requireContext())
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("366283056587-nuovucc9jhfrcsmaor6l2hsohv54rf4i.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        preferencesUSERSTATUS = (activity as AppCompatActivity).getSharedPreferences(
            UserDate.APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        view.btnSignInGoogle.setOnClickListener {
            signIn()
        }

        view.btn_back_stack.setOnClickListener {
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

        view.btn_registration.setOnClickListener {
            if (view.authEditName.text!!.isNotEmpty() &&
                view.authEditEmail.text!!.isNotEmpty() &&
                view.authEditPassword.text!!.isNotEmpty() &&
                view.authEditPassword2.text!!.isNotEmpty()
            ) {
                if (view.authEditPassword.text.toString() == view.authEditPassword2.text.toString()){
                    if (view.checkboxState.isChecked){
                        view.scrollConst.visibility = View.GONE
                        view.loafer.visibility = View.VISIBLE
                        val paramObjectt = JsonObject()
                        paramObjectt.addProperty("firstName", view.authEditName.text.toString().trim())
                        paramObjectt.addProperty("email", view.authEditEmail.text.toString().trim())
                        paramObjectt.addProperty("password", view.authEditPassword.text.toString().trim())

                        viewModel.postUserRegister(paramObjectt)
                    }else{
                        Toast.makeText(requireContext(), "Нужно согласиться с пользовательским соглашением", Toast.LENGTH_SHORT)
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
                Log.d(ContentValues.TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(ContentValues.TAG, "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            USER_STATUS = true
            preferencesUSERSTATUS.edit().putBoolean(UserDate.KEY_USER_STATUS, USER_STATUS).apply()
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

}