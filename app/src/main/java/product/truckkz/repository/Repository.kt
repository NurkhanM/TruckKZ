package product.truckkz.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import product.truckkz.api.RetroFitInstance
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

class Repository {


    suspend fun getUserRepository(
        auth: String,
        number: Int
    ): Response<UserModels> {
        return RetroFitInstance.api.getUser(auth, number)
    }

    suspend fun getProductInfoRepository(
        auth: String,
        number: Int
    ): Response<ProductShowModels> {
        return RetroFitInstance.api.getProductInfo(auth, number)
    }

    fun postUserSignInRepository(params: HashMap<String, String>): LiveData<Response<UserModels>> =
        liveData {
            val response = RetroFitInstance.api.postUserSignIn(params)
            emit(response)
        }

    suspend fun postNewProductsCreateRepository(
        auth: String,
        json: JsonObject
    ): Response<NewProductsModels> {
        return RetroFitInstance.api.postNewProductsCreate(auth, json)
    }

    fun postUserRegisterRepository(body: JsonObject): LiveData<Response<NepolModel>> =
        liveData {
            val response = RetroFitInstance.api.postUserRegister(body)
            emit(response)
        }

//    suspend fun postUserFullDTORegisterRepository(
//        auth: String,
//        json:  JsonObject
//    ): Response<FullModels> {
//        return RetroFitInstance.api.postUserFullDTORegister(
//            auth,
//            json
//        )
//    }

    suspend fun postUserFullRegisterRepository(
        auth: String,
        json: JsonObject,
        images: List<MultipartBody.Part?>
    ): Response<FullModels> {
        return RetroFitInstance.api.postUserFullRegister(
            auth,
            json,
            images
        )
    }

    suspend fun addFavoriteRepository(
        auth: String,
        idProducts: Int
    ): Response<String> {
        return RetroFitInstance.api.addFavorite(
            auth,
            idProducts
        )
    }

    suspend fun deleteFavoriteRepository(
        auth: String,
        idProducts: Int
    ): Response<String> {
        return RetroFitInstance.api.deleteFavorite(
            auth,
            idProducts
        )
    }

    suspend fun pushImageProductsRepository(
        auth: String,
        productsID: Int,
        imageID: Int,
        body: MultipartBody.Part?
    ): Response<String> {
        return RetroFitInstance.api.pushImageProducts(
            auth,
            productsID,
            imageID,
            body
        )
    }

    suspend fun getProductRepository(
        auth: String
    ): Response<ProductsModels> {
        return RetroFitInstance.api.getProduct(auth)
    }
    suspend fun requestSearchRepository(
        auth: String,
        text: String
    ): Response<ProductsModels> {
        return RetroFitInstance.api.requestSearch(auth, text)
    }

    suspend fun getFavoriteRepository(
        auth: String
    ): Response<ProductsModels> {
        return RetroFitInstance.api.getFavorite(auth)
    }

    suspend fun getCategoryRepository(
    ): Response<CategoryModels> {
        return RetroFitInstance.api.getCategory()
    }

    suspend fun getFieldsCategoryRepository(
        number: Int,
    ): Response<FieldsCategoryModels> {
        return RetroFitInstance.api.getFieldsCategory(number)
    }

    suspend fun getCategoryProductsRepository(
        pageID: Int,
        categoryID: Int
    ): Response<ProductsModels> {
        return RetroFitInstance.api.getCategoryProducts(pageID, categoryID)
    }
}