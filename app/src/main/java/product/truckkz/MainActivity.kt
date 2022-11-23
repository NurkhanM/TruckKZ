package product.truckkz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import product.truckkz.UserDate.USER_STATUS
import product.truckkz.windows.newCreateProduct.CreateActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    val viewGroup = (findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_host)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.background = null


        floatBottom.setOnClickListener {
            if (!USER_STATUS) {
                Toast.makeText(this, "Вам нужно авторизоваться", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, CreateActivity::class.java)
                startActivity(intent)
                overridePendingTransition(
                   R.anim.slide_in_right,
                   R.anim.slide_out_left
                )
            }
        }


    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host)

        if (
            navController.currentDestination!!.id == R.id.favoriteFragment ||
            navController.currentDestination!!.id == R.id.chadFragment ||
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