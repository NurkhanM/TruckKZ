package product.truckkz.windows.homeInfo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import product.truckkz.NetworkConnection
import product.truckkz.R
import product.truckkz.databinding.ActivityHomeInfoBinding
import product.truckkz.databinding.ActivityMainBinding

class HomeInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeInfoBinding

    private lateinit var mCompanyFragment: HomeInfoFragment

    private val resultIntent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.disconnect.root.visibility = View.GONE
                binding.companyConnect.visibility = View.VISIBLE
            } else {
                binding.disconnect.root.visibility = View.VISIBLE
                binding.companyConnect.visibility = View.GONE
            }
        }

        mCompanyFragment = HomeInfoFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerCompany, mCompanyFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()



    }

    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        resultIntent.putExtra("key", "value") // добавляем данные в Intent
        setResult(Activity.RESULT_OK, resultIntent) // передаем Intent в setResult()
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}