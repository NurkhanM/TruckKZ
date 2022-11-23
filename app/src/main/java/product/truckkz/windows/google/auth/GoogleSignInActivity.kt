package product.truckkz.windows.google.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import product.truckkz.R

class GoogleSignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_sign_in)
        //Google
//
//        text_display_name.text = intent.getStringExtra(EXTRA_NAME)
//        text_display_email.text = intent.getStringExtra(EXTRA_EMAIL)
//        logout.setOnClickListener {
//            Firebase.auth.signOut()
//            val intent = Intent(applicationContext, MainActivity::class.java)
//            startActivity(intent)
//        }
    }
}