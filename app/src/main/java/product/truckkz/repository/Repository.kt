package product.truckkz.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import product.truckkz.data.retrofit.api.RetroFitInstance
import product.truckkz.models.brand.BrandModels
import product.truckkz.models.category.CategoryModels
import product.truckkz.models.favorite.FavoriteModels
import product.truckkz.models.products.index.ProductsModels
import product.truckkz.models.products.show.ProductShowModels
import product.truckkz.models.register.RegisterModels
import product.truckkz.models.user.UserModels
import product.truckkz.windows.home.paging.CategorySource
import product.truckkz.windows.home.paging.ProductsSource
import retrofit2.Response

class Repository() {

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

    suspend fun pushProductCreate(
        auth: String,
        params: HashMap<String, RequestBody>,
        fields: HashMap<String, RequestBody>,
        img: MultipartBody.Part?,
        images: List<MultipartBody.Part>,

        ): Response<String> {
        return RetroFitInstance.product.pushProductCreate(
            auth,
            params,
            fields,
            img,
            images
        )
    }


    suspend fun getUserRepository(auth: String): Response<UserModels> {
        return RetroFitInstance.user.getUser(auth)
    }

    suspend fun getCategoryRepository(
    ): Response<CategoryModels> {
        return RetroFitInstance.category.getCategory()
    }

    suspend fun updateUserPostRepository(
        auth: String,
        params: HashMap<String, RequestBody>,
        img: MultipartBody.Part?
    ): Response<UserModels> {
        return RetroFitInstance.user.updateUserPost(
            auth,
            params,
            img
        )
    }


    suspend fun getProductsCategoryRepository(
        auth: String,
        allPro: HashMap<String, String>
    ): Response<ProductsModels> {
        return RetroFitInstance.product.getSortProducts(
            auth,
            allPro
        )
    }


    suspend fun getFavoriteRepository(
        auth: String
    ): Response<ProductsModels> {
        return RetroFitInstance.favorite.getFavorite(
            auth
        )
    }

    suspend fun postLikeRepository(auth: String, number: String): Response<FavoriteModels> {
        return RetroFitInstance.favorite.postLike(auth, number)
    }

    suspend fun getMyProductsRepository(
        auth: String,
        idUser: String
    ): Response<ProductsModels> {
        return RetroFitInstance.product.getMyProducts(
            auth,
            idUser
        )
    }

    fun getCategoryPagingRepository(
    ) = Pager(
        config = PagingConfig(
            pageSize = 3,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { CategorySource(RetroFitInstance.category) }
    ).liveData

    fun getCategoryProductRepository(
        auth: String,
        allPro: HashMap<String, String>
    ) = Pager(
        config = PagingConfig(
            pageSize = 5,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { ProductsSource(RetroFitInstance.product, auth, allPro) }
    ).liveData

    suspend fun getBrandRepository(
    ): Response<BrandModels> {
        return RetroFitInstance.brand.getBrand()
    }
}