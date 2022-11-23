package product.truckkz.api

import product.truckkz.models.createProducts.fieldsCategory.FieldsCategoryModels
import product.truckkz.models.createProducts.newProducts.NewProductsModels
import product.truckkz.models.full.FullModels
import product.truckkz.models.nepolnyi.NepolModel
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import product.truckkz.models.category.CategoryModels
import product.truckkz.models.products.index.ProductsModels
import product.truckkz.models.products.show.ProductShowModels
import product.truckkz.models.user.UserModels
import retrofit2.Response
import retrofit2.http.*


interface ApiService {

    @GET("/api/v1/users/{idUser}")
    suspend fun getUser(
        @Header("Authorization") auth: String,
        @Path("idUser") number: Int,
    ): Response<UserModels>


    @GET("api/products/{idProduct}")
    suspend fun getProductInfo(
        @Header("Authorization") auth: String,
        @Path("idProduct") number: Int,
    ): Response<ProductShowModels>

    @GET("api/category")
    suspend fun getCategory(
    ): Response<CategoryModels>

    @GET("api/products")
    suspend fun getProduct(
        @Header("Authorization") auth: String
    ): Response<ProductsModels>

    @GET("/products/get/search/{text}")
    suspend fun requestSearch(
        @Header("Authorization") auth: String,
        @Path("text") text: String
    ): Response<ProductsModels>

    @GET("/products/get/favorites")
    suspend fun getFavorite(
        @Header("Authorization") auth: String
    ): Response<ProductsModels>

    @GET("/categories/get/fields-by-id/{idCategory}")
    suspend fun getFieldsCategory(
        @Path("idCategory") id: Int,
    ): Response<FieldsCategoryModels>



    @FormUrlEncoded
    @POST("api/auth/login")
    suspend fun postUserSignIn(
        @FieldMap params: HashMap<String, String>,
    ): Response<UserModels>


    @Headers("Accept: application/json")
    @POST("/products/add-to-favorites/{idProducts}")
    suspend fun addFavorite(
        @Header("Authorization") auth: String,
        @Path("idProducts") idProducts: Int
    ): Response<String>

    @Headers("Accept: application/json")
    @DELETE("/products/delete-from-favorites/{idProducts}")
    suspend fun deleteFavorite(
        @Header("Authorization") auth: String,
        @Path("idProducts") idProducts: Int
    ): Response<String>

    @Headers("Accept: application/json")
    @POST("/products/publish/details")
    suspend fun postNewProductsCreate(
        @Header("Authorization") auth: String,
        @Body json: JsonObject
    ): Response<NewProductsModels>

    @Headers("Accept: application/json")
    @POST("/api/auth/sign-up-incomplete")
    suspend fun postUserRegister(
        @Body body: JsonObject
    ): Response<NepolModel>


    @Multipart
    @Headers("Accept: application/json")
    @PUT("/api/v1/users/sign-up-complete")
    suspend fun postUserFullRegister(
        @Header("Authorization") auth: String,
        @Part ("userCompleteRegisterDto") json: JsonObject,
        @Part images: List<MultipartBody.Part?>
    ): Response<FullModels>



    @GET("/products/get/main-page-by-category/{idPage}/{idCategory}")
    suspend fun getCategoryProducts(
        @Path ("idPage") pageID: Int,
        @Path ("idCategory") categoryID: Int,
    ): Response<ProductsModels>

    @Multipart
    @Headers("Accept: application/json")
    @POST("/products/publish/image/{idProducts}/{idImage}")
    suspend fun pushImageProducts(
        @Header("Authorization") auth: String,
        @Path ("idProducts") productsID: Int,
        @Path ("idImage") imageID: Int,
        @Part body: MultipartBody.Part?
    ): Response<String>


}

