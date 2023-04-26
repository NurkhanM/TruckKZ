package product.truckkz

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

object MyUtils {

    fun uToast (context: Context, message: String?){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun uLogD (message: String?){
        Log.d("test", "-> = $message")
    }

    fun uGlide(context: Context, view: ImageView, url: Any?){
        Glide.with(context).load(url)
            .placeholder(R.drawable.loader2)
            .centerCrop()
            .into(view)
    }


}