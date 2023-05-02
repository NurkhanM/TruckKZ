package product.truckkz.data.retrofit.api.auth

import okhttp3.MultipartBody
import okhttp3.RequestBody
import product.truckkz.models.register.RegisterModels
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface AuthorizationService {


    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("api/auth/login")
    suspend fun sendLogin(
        @FieldMap params: HashMap<String, String>,
    ): Response<RegisterModels>

    @Multipart
    @Headers("Accept: application/json")
    @POST("api/auth/register")
    suspend fun pushRegistPost(
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("password") password: RequestBody,
        @Part("password_confirmation") password_confirmation: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part img: MultipartBody.Part?
    ): Response<RegisterModels>


}