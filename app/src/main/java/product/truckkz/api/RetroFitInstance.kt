package product.truckkz.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetroFitInstance {
    private val retrofit by lazy {

        val interceptor = HttpLoggingInterceptor()
//        val interceptor = TokenInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES) // write timeout
            .readTimeout(2, TimeUnit.MINUTES) // read timeout
            .addInterceptor(interceptor)
//            .addInterceptor(OAuthInterceptor("Bearer", TOKEN_USER))
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        Retrofit.Builder().baseUrl("https://atlassoft.space/car/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
    val api: product.truckkz.api.ApiService by lazy {
        product.truckkz.api.RetroFitInstance.retrofit.create(product.truckkz.api.ApiService::class.java)
    }

}