package product.truckkz.windows.newCreateProduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import product.truckkz.NetworkConnection
import product.truckkz.R
import product.truckkz.databinding.ActivityCreateBinding

class CreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.createProductDisconnect.visibility = View.GONE
                binding.createProductConnect.visibility = View.VISIBLE
            } else {
                binding.createProductDisconnect.visibility = View.VISIBLE
                binding.createProductConnect.visibility = View.GONE
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