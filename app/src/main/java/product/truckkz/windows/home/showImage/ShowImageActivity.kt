package product.truckkz.windows.home.showImage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import product.truckkz.NetworkConnection
import product.truckkz.R
import kotlinx.android.synthetic.main.activity_show_image.*

class ShowImageActivity : AppCompatActivity() {

    private lateinit var showFragment: ShowImageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image)
        val networkConnection = NetworkConnection(applicationContext)

        networkConnection.observe(this, Observer { isConnected ->
            if (isConnected){
                ShowDisconnect.visibility = View.GONE
                ShowConnect.visibility = View.VISIBLE
            } else {
                ShowDisconnect.visibility = View.VISIBLE
                ShowConnect.visibility = View.GONE
            }
        })

        showFragment = ShowImageFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerShowActivity, showFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.zoom_back, R.anim.zoom_out )
    }
}