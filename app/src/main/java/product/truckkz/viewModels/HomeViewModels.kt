package product.truckkz.viewModels

import androidx.lifecycle.*
import androidx.paging.cachedIn
import product.truckkz.repository.Repository
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import product.truckkz.models.category.CategoryModels
import product.truckkz.models.products.index.ProductsModels
import product.truckkz.models.products.show.ProductShowModels
import product.truckkz.models.register.RegisterModels
import retrofit2.Response

class HomeViewModels : ViewModel() {

    private val repo = Repository()

    val myRegisterList: MutableLiveData<Response<RegisterModels>> = MutableLiveData()

    val myProductInfo: MutableLiveData<Response<ProductShowModels>> = MutableLiveData()

    val myCategory: MutableLiveData<Response<CategoryModels>> = MutableLiveData()
    private val  myShowProducts = MutableLiveData<String>()
    val myProduct2: MutableLiveData<Response<ProductsModels>> = MutableLiveData()
    val myImageCreate: MutableLiveData<Response<String>> = MutableLiveData()
    private val currentQuery = MutableLiveData<HashMap<String, String>>()
    private val myList = MutableLiveData<HashMap<String, String>>()

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

    fun getCategory() {
        viewModelScope.launch {
            myCategory.value = repo.getCategoryRepository()
        }
    }

    val mySortProducts = currentQuery.switchMap {
        repo.getSortRepository(it).cachedIn(viewModelScope)
    }

    fun mySortProducts2(
        allPro: HashMap<String, String>,
    ) {
        currentQuery.value = allPro
    }

    val myGetProduct = myShowProducts.switchMap {
        repo.getProductRepository(it).cachedIn(viewModelScope)
    }



    fun getProduct2(auth: String) {
        viewModelScope.launch {
            myProduct2.value = repo.getProduct2Repository(auth)
        }
    }

}