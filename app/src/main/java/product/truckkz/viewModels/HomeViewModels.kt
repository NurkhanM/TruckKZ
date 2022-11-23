package product.truckkz.viewModels

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.*
import product.truckkz.models.createProducts.fieldsCategory.FieldsCategoryModels
import product.truckkz.models.createProducts.newProducts.NewProductsModels
import product.truckkz.models.full.FullModels
import product.truckkz.models.nepolnyi.NepolModel
import product.truckkz.repository.Repository
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import product.truckkz.models.category.CategoryModels
import product.truckkz.models.products.index.ProductsModels
import product.truckkz.models.products.show.ProductShowModels
import product.truckkz.models.user.UserModels
import retrofit2.Response

class HomeViewModels : ViewModel() {

    private val repo = Repository()

    private val _myPostAllSignIn = MutableLiveData<JsonObject>()
    private val myList = MutableLiveData<HashMap<String, String>>()
    var myUserFullRegister: MutableLiveData<Response<FullModels>> = MutableLiveData()
    val myUser: MutableLiveData<Response<UserModels>> = MutableLiveData()
    val myProductInfo: MutableLiveData<Response<ProductShowModels>> = MutableLiveData()

    val myCategory: MutableLiveData<Response<CategoryModels>> = MutableLiveData()
    val myShowProducts: MutableLiveData<Response<ProductsModels>> = MutableLiveData()
    val myRequestSearch: MutableLiveData<Response<ProductsModels>> = MutableLiveData()
    val myFieldsCategory: MutableLiveData<Response<FieldsCategoryModels>> = MutableLiveData()
    val myFavorite: MutableLiveData<Response<ProductsModels>> = MutableLiveData()
    val myCategoryProduct: MutableLiveData<Response<ProductsModels>> = MutableLiveData()
    val myNewProductsCreate: MutableLiveData<Response<NewProductsModels>> = MutableLiveData()
    val myImageCreate: MutableLiveData<Response<String>> = MutableLiveData()
    val myAddFavorite: MutableLiveData<Response<String>> = MutableLiveData()
    val myDeleteFavorite: MutableLiveData<Response<String>> = MutableLiveData()



    fun getUser(auth: String, number: Int) {
        viewModelScope.launch {
            myUser.value = repo.getUserRepository(auth, number)
        }
    }

    fun getProductInfo(auth: String, number: Int) {
        viewModelScope.launch {
            myProductInfo.value = repo.getProductInfoRepository(auth, number)
        }
    }

    val myUserSignIn: LiveData<Response<UserModels>> =
        myList.switchMap {
            repo.postUserSignInRepository(it)
        }

    fun postUserSignIn(params: HashMap<String, String>) {
        viewModelScope.launch {
            myList.postValue(params)
        }
    }


    val myUserRegister: LiveData<Response<NepolModel>> =
        _myPostAllSignIn.switchMap {
            repo.postUserRegisterRepository(it)
        }

    fun postUserRegister(body: JsonObject) {
        viewModelScope.launch {
            _myPostAllSignIn.postValue(body)
        }
    }

    fun getCategory() {
        viewModelScope.launch {
            myCategory.value = repo.getCategoryRepository()
        }
    }

    fun getProduct(auth: String) {
        viewModelScope.launch {
            myShowProducts.value = repo.getProductRepository(auth)
        }
    }

    fun requestSearch(auth: String, text: String) {
        viewModelScope.launch {
            myRequestSearch.value = repo.requestSearchRepository(auth, text)
        }
    }

    fun getFavorite(auth: String) {
        viewModelScope.launch {
            myFavorite.value = repo.getFavoriteRepository(auth)
        }
    }

    fun getFieldsCategory(number: Int) {
        viewModelScope.launch {
            myFieldsCategory.value = repo.getFieldsCategoryRepository(number)
        }
    }

    fun getCategoryProducts(pageID: Int, categoryID: Int) {
        viewModelScope.launch {
            myCategoryProduct.value = repo.getCategoryProductsRepository(pageID, categoryID)
        }
    }

    fun postNewProductsCreate(auth: String, json: JsonObject) {
        viewModelScope.launch {
            myNewProductsCreate.value = repo.postNewProductsCreateRepository(auth, json)
        }
    }


//    val listData = Pager(PagingConfig(pageSize = 0)) {
//        HomePagingSource(RetroFitInstance.api)
//    }.flow.cachedIn(viewModelScope)

//    fun postUserFullDTORegister(auth: String, json:  JsonObject
//    ) {
//        viewModelScope.launch {
//            myUserFullDTORegister.value = repo.postUserFullDTORegisterRepository(auth, json)
//            Log.d(
//                ContentValues.TAG, "postUserFullRegister: " +
//                        "\n TOKEN_USER -> ${UserDate.TOKEN_USER}" +
//                        "\n params -> $json")
//        }
//    }

    fun postUserFullRegister(
        auth: String,
        json: JsonObject,
        images: List<MultipartBody.Part?>
    ) {
        viewModelScope.launch {
            myUserFullRegister.value = repo.postUserFullRegisterRepository(
                auth,
                json,
                images
            )

            Log.d(
                ContentValues.TAG, "postUserFullRegister: " +
                        "\n TOKEN_USER -> ${auth}" +
                        "\n json -> ${json}" +
                        "\n images -> ${images}" )

        }
    }


    fun pushImageProducts(
        auth: String,
        productsID: Int,
        imageID: Int,
        body: MultipartBody.Part?
    ) {
        viewModelScope.launch {
            myImageCreate.value = repo.pushImageProductsRepository(
                auth,
                productsID,
                imageID,
                body
            )

        }
    }

    fun addFavorite(
        auth: String,
        idProducts: Int
    ) {
        viewModelScope.launch {
            myAddFavorite.value = repo.addFavoriteRepository(
                auth,
                idProducts
            )

        }
    }

    fun deleteFavorite(
        auth: String,
        idProducts: Int
    ) {
        viewModelScope.launch {
            myDeleteFavorite.value = repo.deleteFavoriteRepository(
                auth,
                idProducts
            )

        }
    }
}