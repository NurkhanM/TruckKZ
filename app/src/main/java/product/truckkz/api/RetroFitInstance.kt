package product.truckkz.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import product.truckkz.api.auth.AuthorizationService
import product.truckkz.api.brands.BrandService
import product.truckkz.api.category.CategoryService
import product.truckkz.api.products.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetroFitInstance {
    private val retrofit by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES) // write timeout
            .readTimeout(2, TimeUnit.MINUTES) // read timeout
            .addInterceptor(interceptor)
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
    val authorization: AuthorizationService by lazy {
        retrofit.create(AuthorizationService::class.java)
    }
    val brand: BrandService by lazy {
        retrofit.create(BrandService::class.java)
    }
    val category: CategoryService by lazy {
        retrofit.create(CategoryService::class.java)
    }
    val product: ProductService by lazy {
        retrofit.create(ProductService::class.java)
    }

}