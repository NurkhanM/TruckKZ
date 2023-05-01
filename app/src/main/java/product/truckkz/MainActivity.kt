package product.truckkz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import product.truckkz.windows.createProduct.CreateActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import product.truckkz.MyUtils.uToast
import product.truckkz.UserDate.USER_TOKEN
import product.truckkz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_host)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.background = null


        binding.floatBottom.setOnClickListener {
            if(USER_TOKEN.isNotEmpty()){
                val intent = Intent(this, CreateActivity::class.java)
                startActivity(intent)
                overridePendingTransition(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
            }else {
                uToast(this, "Нужно авторизоваться!")
            }

        }
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host)

        if (
            navController.currentDestination!!.id == R.id.authorizationFragment||
            navController.currentDestination!!.id == R.id.profileFragment
        ) {
            navController.navigate(R.id.homeFragment)
        } else {
            if (navController.currentDestination!!.id != R.id.homeFragment) {
                super.onBackPressed()
            } else {
                val startMain = Intent(Intent.ACTION_MAIN)
                startMain.addCategory(Intent.CATEGORY_HOME)
                startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(startMain)
            }
        }
    }

}