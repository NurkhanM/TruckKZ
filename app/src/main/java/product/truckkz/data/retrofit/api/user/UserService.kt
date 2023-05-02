package product.truckkz.data.retrofit.api.user

import okhttp3.MultipartBody
import okhttp3.RequestBody
import product.truckkz.models.user.UserModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface UserService {

    @GET("api/user")
    @Headers("Accept: application/json")
    suspend fun getUser(
        @Header("Authorization") auth: String
    ): Response<UserModels>

    @Multipart
    @Headers("Accept: application/json")
    @POST("api/user/update")
    suspend fun updateUserPost(
        @Header("Authorization") auth: String,
        @PartMap params: HashMap<String, RequestBody>,
        @Part img: MultipartBody.Part?

    ): Response<UserModels>

}