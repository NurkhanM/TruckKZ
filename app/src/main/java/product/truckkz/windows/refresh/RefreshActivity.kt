package product.truckkz.windows.refresh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import product.truckkz.FormFullRegistration.idUser
import product.truckkz.R
import product.truckkz.UserDate.APP_PREFERENCES
import product.truckkz.UserDate.KEY_TOKEN
import product.truckkz.UserDate.KEY_USER_STATUS
import product.truckkz.UserDate.KEY_USER_STATUS_FULL
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.UserDate.USER_STATUS
import product.truckkz.UserDate.USER_STATUS_FULL
import java.io.File

class RefreshActivity : AppCompatActivity() {

    private lateinit var preferencesInfo: SharedPreferences
    private lateinit var preferencesTOKEN: SharedPreferences
    private lateinit var preferencesUserStatus: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refresh)
        clearData()

        preferencesInfo = getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )
        preferencesTOKEN = getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )
        preferencesUserStatus = getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        preferencesInfo.edit().putBoolean(KEY_USER_STATUS, false).apply()
        preferencesTOKEN.edit().putString(KEY_TOKEN, "").apply()
        preferencesUserStatus.edit().putBoolean(KEY_USER_STATUS_FULL, false).apply()

        USER_STATUS = false
        USER_STATUS_FULL = false
        TOKEN_USER = ""

        idUser = "-1"

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