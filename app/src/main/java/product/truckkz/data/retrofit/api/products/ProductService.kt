package product.truckkz.data.retrofit.api.products

import okhttp3.MultipartBody
import okhttp3.RequestBody
import product.truckkz.models.products.index.ProductsModels
import product.truckkz.models.products.show.ProductShowModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ProductService {

    @GET("api/products/{idProduct}")
    @Headers("Accept: application/json")
    suspend fun getProductInfo(
        @Header("Authorization") auth: String,
        @Path("idProduct") number: Int,
    ): Response<ProductShowModels>


    @GET("api/products")
    @Headers("Accept: application/json")
    suspend fun getSortProducts(
        @Header("Authorization") auth: String,
        @QueryMap allPro: HashMap<String, String>,
//        @Query("page") page: Int,
    ): Response<ProductsModels>


    @GET("api/products")
    @Headers("Accept: application/json")
    suspend fun getMyProducts(
        @Header("Authorization") auth: String,
        @Query("user_id") idUser: String
    ): Response<ProductsModels>


    @Multipart
    @Headers("Accept: application/json")
    @POST("api/products")
    suspend fun pushProductCreate(
        @Header("Authorization") auth: String,
        @PartMap params: HashMap<String, RequestBody>,
        @PartMap fields: HashMap<String, RequestBody>,
        @Part img: MultipartBody.Part?,
        @Part images: List<MultipartBody.Part>
    ): Response<String>

    @GET("api/products")
    @Headers("Accept: application/json")
    suspend fun getCategoryProducts(
        @Header("Authorization") auth: String,
        @QueryMap allPro: HashMap<String, String>,
        @Query("page") page: Int,
    ): Response<ProductsModels>


}