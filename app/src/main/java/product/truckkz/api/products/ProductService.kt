package product.truckkz.api.products

import product.truckkz.models.products.index.ProductsModels
import product.truckkz.models.products.show.ProductShowModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ProductService {

    @GET("api/products/{idProduct}")
    suspend fun getProductInfo(
        @Header("Authorization") auth: String,
        @Path("idProduct") number: Int,
    ): Response<ProductShowModels>

    @GET("api/products")
    suspend fun getProduct(
        @Header("Authorization") auth: String
    ): Response<ProductsModels>

    @GET("api/products")
    suspend fun getProduct2(
        @Header("Authorization") auth: String
    ): Response<ProductsModels>

    @GET("api/products")
    suspend fun getSortProducts(
        @Header("Authorization") auth: String,
        @QueryMap allPro: HashMap<String, String>,
        @Query("page") page: Int,
    ): Response<ProductsModels>


}