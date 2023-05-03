package product.truckkz.viewModels

import android.os.Bundle
import androidx.lifecycle.*
import androidx.paging.cachedIn
import product.truckkz.repository.Repository
import kotlinx.coroutines.launch
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
import retrofit2.Response

class HomeViewModels : ViewModel() {

    private val repo = Repository()

    val myRegisterList: MutableLiveData<Response<RegisterModels>> = MutableLiveData()

    val myProductInfo: MutableLiveData<Response<ProductShowModels>> = MutableLiveData()

    val myCategory: MutableLiveData<Response<CategoryModels>> = MutableLiveData()
    val myBrand: MutableLiveData<Response<BrandModels>> = MutableLiveData()
    private val myList = MutableLiveData<HashMap<String, String>>()
    var myProductCreate: MutableLiveData<Response<String>> = MutableLiveData()
    val myUser: MutableLiveData<Response<UserModels>> = MutableLiveData()
    val myUpdateUserPost: MutableLiveData<Response<UserModels>> = MutableLiveData()
    val myProductsCategory: MutableLiveData<Response<ProductsModels>> = MutableLiveData()
    val myGetFavorite: MutableLiveData<Response<ProductsModels>> = MutableLiveData()
    val myGetMyProducts: MutableLiveData<Response<ProductsModels>> = MutableLiveData()
    private val posLikeList: MutableLiveData<Response<FavoriteModels>> = MutableLiveData()


    fun getProductInfo(auth: String, number: Int) {
        viewModelScope.launch {
            myProductInfo.value = repo.getProductInfoRepository(auth, number)
        }
    }

    fun pushRegist(
        name: RequestBody,
        email: RequestBody,
        password: RequestBody,
        password_confirmation: RequestBody,
        phone: RequestBody,
        img: MultipartBody.Part?,
    ) {
        viewModelScope.launch {
            myRegisterList.value = repo.pushRegistPost(
                name,
                email,
                password,
                password_confirmation,
                phone,
                img
            )
        }
    }

    val mySendLogin: LiveData<Response<RegisterModels>> =
        myList.switchMap {
            repo.sendLoginRepository(it)
        }

    fun sendLogin(params: HashMap<String, String>) {
        viewModelScope.launch {
            myList.postValue(params)
        }
    }

    fun getUser(auth: String) {
        viewModelScope.launch {
            myUser.value = repo.getUserRepository(auth)
        }
    }

    fun updateUserPost(
        auth: String,
        params: HashMap<String, RequestBody>,
        img: MultipartBody.Part?
    ) {
        viewModelScope.launch {
            myUpdateUserPost.value = repo.updateUserPostRepository(
                auth,
                params,
                img
            )
        }
    }

    fun getProductsCategory(
        auth: String,
        allPro: HashMap<String, String>
    ) {
        viewModelScope.launch {
            myProductsCategory.value = repo.getProductsCategoryRepository(
                auth,
                allPro
            )
        }
    }

    fun getFavorite(
        auth: String
    ) {
        viewModelScope.launch {
            myGetFavorite.value = repo.getFavoriteRepository(
                auth
            )
        }
    }

    fun postLike(auth: String, number: String) {
        viewModelScope.launch {
            posLikeList.value = repo.postLikeRepository(auth, number)
        }
    }

    fun getMyProducts(
        auth: String,
        idUser: String
    ) {
        viewModelScope.launch {
            myGetMyProducts.value = repo.getMyProductsRepository(
                auth,
                idUser
            )
        }
    }

    fun getCategory() {
        viewModelScope.launch {
            myCategory.value = repo.getCategoryRepository()
        }
    }

    fun getBrand() {
        viewModelScope.launch {
            myBrand.value = repo.getBrandRepository()
        }
    }

    fun pushProductCreate(
        auth: String,
        params: HashMap<String, RequestBody>,
        fields: HashMap<String, RequestBody>,
        img: MultipartBody.Part?,
        images: List<MultipartBody.Part>,
    ) {
        viewModelScope.launch {
            myProductCreate.value = repo.pushProductCreate(
                auth,
                fields,
                params,
                img,
                images
            )
        }
    }


    fun getCategoryPagingLiveData() = repo.getCategoryPagingRepository().cachedIn(viewModelScope)
    fun getCategoryProductLiveData(auth: String, allPro: HashMap<String, String>) = repo.getCategoryProductRepository(auth, allPro).cachedIn(viewModelScope)


}