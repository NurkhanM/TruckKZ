package product.truckkz.data.retrofit.api.brands

import product.truckkz.models.brand.BrandModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface BrandService {
    @GET("api/brand")
    @Headers("Accept: application/json")
    suspend fun getBrand(
    ): Response<BrandModels>

}