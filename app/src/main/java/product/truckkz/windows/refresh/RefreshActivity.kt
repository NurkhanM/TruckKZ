package product.truckkz.windows.refresh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import product.truckkz.UserDate.APP_PREFERENCES
import product.truckkz.UserDate.KEY_TOKEN
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.UserDate.USER_STATUS
import product.truckkz.UserDate.USER_STATUS_FULL
import product.truckkz.databinding.ActivityRefreshBinding
import java.io.File

class RefreshActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRefreshBinding

    private lateinit var preferencesTOKEN: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefreshBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clearData()

        preferencesTOKEN = getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        preferencesTOKEN.edit().putString(KEY_TOKEN, "").apply()

        TOKEN_USER = ""


        refreshNextIntent()


    }

    private fun refreshNextIntent() {
        val intent = Intent(this, product.truckkz.MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun clearData() {
        val cache = cacheDir
        val appDir = cache?.parent?.let { File(it) }
        if (appDir?.exists() == true) {
            val children = appDir.list();
            for (s in children!!) {
                if (!s.equals("lib")) {
                    deleteDir(File(appDir, s))
                }
            }
        }
    }

    private fun deleteDir(dir: File?): Boolean {
        if (dir != null && dir.isDirectory) {
            val children = dir.list()
            for (i in children!!) {
                val success = deleteDir(File(dir, i));
                if (!success) {
                    return false
                }
            }
        }

        return dir!!.delete()
    }
}