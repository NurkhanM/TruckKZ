package product.truckkz.windows.newCreateProduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import product.truckkz.NetworkConnection
import product.truckkz.R
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                createProductDisconnect.visibility = View.GONE
                createProductConnect.visibility = View.VISIBLE
            } else {
                createProductDisconnect.visibility = View.VISIBLE
                createProductConnect.visibility = View.GONE
            }
        }
    }

    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}