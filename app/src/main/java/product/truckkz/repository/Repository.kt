package product.truckkz.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import product.truckkz.api.RetroFitInstance
import product.truckkz.paging.ProductPaging
import product.truckkz.paging.SearchPaging
import product.truckkz.models.category.CategoryModels
import product.truckkz.models.products.index.ProductsModels
import product.truckkz.models.products.show.ProductShowModels
import product.truckkz.models.register.RegisterModels
import retrofit2.Response

class Repository {

    suspend fun getProductInfoRepository(
        auth: String,
        number: Int
    ): Response<ProductShowModels> {
        return RetroFitInstance.product.getProductInfo(auth, number)
    }

    suspend fun pushRegistPost(
        name: RequestBody,
        email: RequestBody,
        password: RequestBody,
        password_confirmation: RequestBody,
        phone: RequestBody,
        img: MultipartBody.Part?,
    ): Response<RegisterModels> {
        return RetroFitInstance.authorization.pushRegistPost(
            name,
            email,
            password,
            password_confirmation,
            phone,
            img
        )
    }

    fun sendLoginRepository(params: HashMap<String, String>): LiveData<Response<RegisterModels>> =
        liveData {
            val response = RetroFitInstance.authorization.sendLogin(params)
            emit(response)
        }

    suspend fun getProduct2Repository(
        auth: String
    ): Response<ProductsModels> {
        return RetroFitInstance.product.getProduct2(auth)
    }


    suspend fun getCategoryRepository(
    ): Response<CategoryModels> {
        return RetroFitInstance.category.getCategory()
    }

    fun getSortRepository(
        allPro: HashMap<String, String>,
    ) = Pager(
        config = PagingConfig(
            pageSize = 1,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { SearchPaging(RetroFitInstance.product, allPro) }
    ).liveData

    fun getProductRepository(
        auth: String
    ) = Pager(
        config = PagingConfig(
            pageSize = 1,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { ProductPaging(RetroFitInstance.product, auth) }
    ).liveData
}