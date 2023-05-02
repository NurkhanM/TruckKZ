package product.truckkz.data.retrofit.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import product.truckkz.data.retrofit.api.auth.AuthorizationService
import product.truckkz.data.retrofit.api.brands.BrandService
import product.truckkz.data.retrofit.api.category.CategoryService
import product.truckkz.data.retrofit.api.favorite.FavoriteService
import product.truckkz.data.retrofit.api.products.ProductService
import product.truckkz.data.retrofit.api.user.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetroFitInstance {
    private val retrofit by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.MINUTES)
            .writeTimeout(15, TimeUnit.MINUTES) // write timeout
            .readTimeout(15, TimeUnit.MINUTES) // read timeout
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
    val user: UserService by lazy {
        retrofit.create(UserService::class.java)
    }
    val favorite: FavoriteService by lazy {
        retrofit.create(FavoriteService::class.java)
    }

}