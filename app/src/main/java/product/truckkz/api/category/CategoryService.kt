package product.truckkz.api.category

import product.truckkz.models.category.CategoryModels
import product.truckkz.models.categoryShow.CategoryShowModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface CategoryService {

    @GET("api/category")
    @Headers("Accept: application/json")
    suspend fun getCategory(
    ): Response<CategoryModels>

    @GET("api/category/{idCategory}")
    @Headers("Accept: application/json")
    suspend fun getCategoryID(
        @Header("Authorization") auth: String,
        @Path("idCategory") number: Int
    ): Response<CategoryShowModels>


}