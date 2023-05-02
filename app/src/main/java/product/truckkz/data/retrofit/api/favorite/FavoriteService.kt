package product.truckkz.data.retrofit.api.favorite

import okhttp3.MultipartBody
import product.truckkz.models.favorite.FavoriteModels
import product.truckkz.models.products.index.ProductsModels
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface FavoriteService {

    @GET("api/favorites")
    @Headers("Accept: application/json")
    suspend fun getFavorite(
        @Header("Authorization") auth: String,
    ): Response<ProductsModels>


    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("api/favorites")
    suspend fun postLike(
        @Header("Authorization") auth: String,
        @Field("product_id") rating: String
    ): Response<FavoriteModels>
}
