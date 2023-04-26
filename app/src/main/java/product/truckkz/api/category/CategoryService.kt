package product.truckkz.api.category

import product.truckkz.models.category.CategoryModels
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET("api/category")
    suspend fun getCategory(
    ): Response<CategoryModels>

}